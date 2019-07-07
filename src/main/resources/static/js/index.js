layui.use(['element', 'jquery', 'form'], function () {
    //使用layui定好的模块
    var element = layui.element,
        form = layui.form,
        $ = layui.jquery;

    // 定义和tab相关事件
    var tabActive = {
        //在这里给active绑定几项事件，后面可通过active调用这些事件
        tabAdd: function (url, id, name) {
            //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
            //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
            element.tabAdd('customTab', {
                title: name,
                content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src=" ' + url + ' " width="100%"  height="100%"></iframe>',
                id: id //规定好的id
            });
            CustomRightClick(id); //给tab绑定右击事件
            FrameWH();  //计算ifram层的大小
        },
        tabChange: function (id) {
            //切换到指定Tab项
            element.tabChange('customTab', id); //根据传入的id传入到指定的tab项
        },
        tabDelete: function (id) {
            element.tabDelete("customTab", id);//删除
        },
        tabDeleteAll: function (ids) {//删除所有
            $.each(ids, function (i, item) {
                element.tabDelete("customTab", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
            });
        }
    };

    // 点击左侧导航栏,右边显示对应的tab选项卡
    $('.site-customTab-active').on('click', function () {
        var dataid = $(this);
        //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
        if ($(".layui-tab-title li[lay-id]").length <= 0) {
            //如果比零小，则直接打开新的tab项
            tabActive.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
        } else {
            //否则判断该tab项是否以及存在
            var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
            $.each($(".layui-tab-title li[lay-id]"), function () {
                //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                    isData = true;
                }
            });
            if (!isData) {
                //标志为false 新增一个tab项
                tabActive.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
            }
        }
        //最后不管是否新增tab，最后都转到要打开的选项页面上
        tabActive.tabChange(dataid.attr("data-id"));
    });

    // 切换tab选项卡切换动态选择左侧导航栏
    element.on('tab(customTab)', function () {
        var layId = this.getAttribute("lay-id");
        $.each($(".site-customTab-active"), function () {
            if ($(this).attr("data-id") === layId) {
                $(".site-customTab-active").parent("dd").removeClass("layui-this");
                $(this).parent("dd").addClass("layui-this");
            }
        });
    });

    // 基本资料
    $('.layui-nav-child .basicInfo').on('click', function () {
        var userId = $('#userId').val();
        var params = {suId: userId};
        $.get('/sysUser/basicInfo', params, function (res) {
            layer.open({
                title: '设置我的基本资料',
                skin: 'layui-layer-lan',
                type: 1,
                area: ['482px', '280px'],
                maxmin: true,
                content: res,
                success: function (layero, index) {
                    // 渲染表单元素
                    form.render();
                    // 页面加载成功,改变下布局
                    $('#layui-form-page').css({
                        marginTop: '20px',
                        marginRight: '30px'
                    });
                    // 监控表单提交
                    form.on('submit(form)', function (data) {
                        // 异步提交表单
                        $.ajax({
                            url: '/sysUser/edit',
                            data: data.field,
                            type: 'POST',
                            dataType: 'json',
                            success: function (data) {
                                var msg = '';
                                if (data.code === REQUEST_SUCCESS_CODE) {
                                    layer.close(index);
                                    msg = '设置成功';
                                } else {
                                    msg = data.msg;
                                }
                                layer.msg(msg);
                            },
                            error: function (data) {
                                console.error("调用出错", data);
                            }
                        });
                        //阻止表单跳转(同步)
                        return false;
                    });
                }
            }, 'html');
        });
    });

    // 修改密码
    $('.layui-nav-child .updatePassword').on('click', function () {
        var userId = $('#userId').val();
        var params = {suId: userId};
        $.get('/sysUser/updatePassword', params, function (res) {
            layer.open({
                title: '修改密码',
                skin: 'layui-layer-lan',
                type: 1,
                area: ['482px', '350px'],
                maxmin: true,
                content: res,
                success: function (layero, index) {
                    // 渲染表单元素
                    form.render();
                    // 页面加载成功,改变下布局
                    $('#layui-form-page').css({
                        marginTop: '20px',
                        marginRight: '30px'
                    });
                    // 监控表单提交
                    form.on('submit(form)', function (data) {
                        var params = data.field
                        if (params.newPassword !== params.confirmPassword) {
                            layer.msg("确认密码与新密码不一致,请重新输入");
                            return false;
                        }

                        // 异步提交表单
                        $.ajax({
                            url: '/sysUser/updatePassword',
                            data: params,
                            type: 'POST',
                            dataType: 'json',
                            success: function (data) {
                                var msg = '';
                                if (data.code === REQUEST_SUCCESS_CODE) {
                                    layer.close(index);
                                    msg = '密码修改成功';
                                    // 密码修改成功,跳转到登录页重新登录
                                    window.location.href = '/sysUser/doLogin';
                                } else {
                                    msg = data.msg;
                                }
                                parent.layer.msg(msg);
                            },
                            error: function (data) {
                                console.error("调用出错", data);
                            }
                        });
                        //阻止表单跳转(同步)
                        return false;
                    });
                }
            }, 'html');
        });
    });

    // tab标题右键事件
    function CustomRightClick(id) {
        //取消右键 rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
        $('.layui-tab-title li').on('contextmenu', function () {
            return false;
        });

        $('.layui-tab-title,.layui-tab-title li').on('click', function () {
            $('.rightmenu').hide();
        });

        //桌面点击右击
        $('.layui-tab-title li').on('contextmenu', function (e) {
            var popupmenu = $(".rightmenu");
            //判断右侧菜单的位置
            var l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
            var t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
            //进行绝对定位
            popupmenu.show().css({'left': (l - 130) + 'px', 'top': (t - 45) + 'px'});
            return false;
        });
    }

    // 右侧菜单鼠标移动添加背景色
    $(".rightmenu li").hover(
        function () {
            $(this).addClass("layui-bg-green");
            $(this).css("cursor", "pointer");
        },
        function () {
            $(this).removeClass("layui-bg-green");
        }
    );

    // 点击右键菜单触发
    $(".rightmenu li").on('click', function () {
        // 获取tab选中项
        var selectedItem = $(".layui-tab-title").find(".layui-this");
        switch ($(this).attr("data-type")) {
            case "closethis":
                tabActive.tabDelete(selectedItem.attr("lay-id"));
                break;

            case "closeother":
                tabActive.tabDeleteAll(getCloseTabId(selectedItem.siblings()));
                break;

            case "closeleftall":
                tabActive.tabDeleteAll(getCloseTabId(selectedItem.prevAll()));
                break;

            case "closerightall":
                tabActive.tabDeleteAll(getCloseTabId(selectedItem.nextAll()));
                break;

            case "closeall":
                tabActive.tabDeleteAll(getCloseTabId($(".layui-tab-title li")));
                break;

            default:
                console.log("操作不支持");
                break;
        }
        $('.rightmenu').hide();
    });

    // 获得要关闭的tab选项卡id集合
    function getCloseTabId(e) {
        var ids = [];
        $.each(e, function (i) {
            ids[i] = $(this).attr("lay-id");
        });
        return ids;
    }

    // 计算iframe宽高
    function FrameWH() {
        var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10 - 10 - 10;
        $("iframe").css("height", h + "px");
    }

    // 浏览器窗口改变计算重新设置iframe大小
    $(window).resize(function () {
        FrameWH();
    });
});
