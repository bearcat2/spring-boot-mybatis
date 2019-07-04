// 将表格常用操作定义为通用模块
layui.define(['table', 'jquery', 'form'], function (exports) {
    var table = layui.table,
        $ = layui.jquery,
        form = layui.form;

    // 定义模块名，建议和文件名保持一致，可以省去很多麻烦的
    const MODULE_NAME = "commonTable";

    // 定义模块所有动作或行为
    var tableIns;
    var action = {
        render: function (customConfig) {
            var config = {
                elem: '#dataTable',
                method: 'POST',
                url: 'list',
                page: true, //开启分页,默认：false
                even: true, // 开启隔行变色,默认：false
                limit: 15, // 每页显示15条,默认10条
                limits: [15, 20, 25, 30, 35, 40, 45, 50]// 每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
            };

            //【核心】用一个或多个其他对象来扩展一个对象，返回被扩展的对象,如果用户自定配置和全局配置一致会覆盖掉全局配置
            $.extend(config, customConfig);
            // 渲染表格
            tableIns = table.render(config);
        },
        commonLayerPage: commonLayerPage
    };

    // 点击搜索按钮
    $('#search').on('click', function () {
        // 获取查询参数
        var serializeArray = $('#searchForm').serializeArray();
        var queryParams = {};
        $.each(serializeArray, function (index, element) {
            // 暂不考虑,有多个相同name属性的表单元素,例如checkbox,后期根据需求再做对应的处理
            queryParams[element.name] = element.value;
        });

        // 进行表格重载
        tableIns.reload({
            page: {
                // 表格重载从第一页开始
                curr: 1
            },
            where: queryParams
        });
    });

    // 点清空击按钮
    $('#clear').on('click', function () {
        $('#searchForm')[0].reset();
    });

    // 点击新增按钮
    $('#add').on('click', function () {
        commonLayerPage(1, null);
    });

    /**
     * 通用 layer 页面函数
     * @param type 触发类型(1:新增,2:编辑,3:查看详情)
     * @param params 请求参数
     */
    function commonLayerPage(type, params) {
        // 后台对应功能的ui地址，前端点击增加或编辑等先向后台返回对应操作也的html页面
        var htmlUrl = '';
        // 弹出页面是否需要监控表单提交按钮,true - 需要 ,false 不需要
        var isSubmit = true;
        // 在isSubmit为true起作用,异步表单提交地址
        var ajaxFormSubmitUrl = '';
        // 在isSubmit为true起作用,异步表单提交成功后的提示消息
        var ajaxFormSubmitSuccessMsg = '';
        // 下面几个是从页面获取自定义的layer 弹出层的配置信息
        var $selector = '';
        var defaultTilte = '';
        var defaultWidth = 'auto';
        var defaultHeight = 'auto';
        // 页面弹出成功是否开启回调函数便于在外部处理一些逻辑,默认不开启
        var defaultIsCallback = false;

        switch (type) {
            case 1:
                // 新增
                htmlUrl = 'add';
                ajaxFormSubmitUrl = 'add';
                ajaxFormSubmitSuccessMsg = '新增成功';
                $selector = $('#addConfig');
                defaultTilte = '新增';
                break;
            case 2:
                // 编辑
                htmlUrl = 'edit';
                ajaxFormSubmitUrl = 'edit';
                ajaxFormSubmitSuccessMsg = '编辑成功';
                $selector = $('#editConfig');
                defaultTilte = '编辑';
                break;
            case 3:
                // 查看详情
                htmlUrl = 'detail';
                $selector = $('#detailConfig');
                defaultTilte = '查看详情';
                isSubmit = false;
                break;
        }

        $.get(htmlUrl, params, function (data) {
            var tilte = $selector.data('title');
            var width = $selector.data('width');
            var height = $selector.data('height');
            var isCallback = $selector.data('callback');

            // 优先使用外部配置的属性,外部没配置的使用默认设置
            tilte = tilte ? tilte : defaultTilte;
            width = width ? width + 'px' : defaultWidth;
            height = height ? height + 'px' : defaultHeight;
            isCallback = isCallback ? true : defaultIsCallback;
            var area = [];
            area.push(width);
            area.push(height);

            var isCancel = false;
            layer.open({
                type: 1,
                title: tilte,
                skin: 'layui-layer-lan',
                // maxmin: true,
                area: area,
                content: data,
                // resize: false,
                success: function (layero, index) {
                    // 渲染表单元素
                    form.render();

                    // 页面加载成功,改变下布局
                    $('#layui-form-page').css({
                        marginTop: '20px',
                        marginRight: '30px'
                    });

                    // 避免select框被页面覆盖
                    // $('.layui-layer-page .layui-layer-content').css('overflow', 'visible');

                    if (isSubmit) {
                        // 监控表单提交
                        form.on('submit(form)', function (data) {
                            // 异步提交表单
                            $.ajax({
                                url: ajaxFormSubmitUrl,
                                data: data.field,
                                type: 'POST',
                                dataType: 'json',
                                success: function (data) {
                                    var msg = '';
                                    if (data.code === REQUEST_SUCCESS_CODE) {
                                        layer.close(index);
                                        msg = ajaxFormSubmitSuccessMsg;
                                    } else {
                                        msg = "发生错误了,错误原因：" + data.msg;
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

                    // 回调函数
                    if (isCallback) {
                        layerPageSuccessCallback(type);
                    }
                },
                cancel: function () {
                    isCancel = true;
                },
                end: function () {
                    // 页面关闭后,执行表格重载
                    if (isCancel) {
                        // 点击右上角取消按钮,不重载表格减少向服务请求
                        return;
                    }
                    if (tableIns) {
                        tableIns.reload();
                    } else {
                        window.location.reload();
                    }
                }
            });
        }, 'html');
    }

    /**
     * 监听表格工具条
     * tool是工具条事件名，dataTableFilter是table原始容器的属性 lay-filter="对应的值"
     */
    table.on('tool(dataTableFilter)', function (obj) {
        //获得当前行数据
        var data = obj.data;
        //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var layEvent = obj.event;
        //获得当前行 tr 的DOM对象
        var tr = obj.tr;
        switch (layEvent) {
            case 'detail':
                // 查看
                showDetail(data);
                break;
            case 'edit':
                // 编辑
                editData(data);
                break;
            case 'del':
                // 删除
                deleteData(data);
                break;
            case 'allotPrivilege':
                // 分配权限,分配权限并不是所有页面共有的回调外部定义方法即可
                allotPrivilege(data);
                break;
        }
    });

    // 点击查看按钮触发该函数
    function showDetail(data) {
        // 从服务器获取详情页html元素内容
        commonLayerPage(3, data);
    }

    // 点击编辑按钮触发该函数
    function editData(data) {
        // 从服务器获取编辑页html元素内容
        commonLayerPage(2, data);
    }

    // 点击删除按钮触发该函数
    function deleteData(data) {
        layer.confirm(
            '删除操作不可恢复，确认要删除吗？',
            {
                skin: 'layui-layer-lan'
            },
            function (layerIndex) {
                // 确定按钮被点击,向后台发起删除请求,请求成功再关闭该询问框
                $.ajax({
                    url: 'delete',
                    data: data,
                    type: 'POST',
                    dataType: 'json',
                    success: function (data) {
                        var msg = '';
                        if (data.code === REQUEST_SUCCESS_CODE) {
                            // 关闭询问框重载表格数据，并弹出提示消息
                            layer.close(layerIndex);
                            tableIns.reload();
                            msg = '数据删除成功';
                        } else {
                            msg = "发生错误了,错误原因：" + data.msg;
                        }
                        layer.msg(msg);
                    },
                    error: function (data) {
                        console.error("调用出错", data);
                    }
                });
            }
        );
    }

    exports(MODULE_NAME, action);
});