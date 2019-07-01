layui.use(['treeTable', 'commonTable', 'treeSelect', 'layer', 'jquery', 'transfer'], function () {
    var treeTable = layui.treeTable,
        commonTable = layui.commonTable,
        treeSelect = layui.treeSelect,
        layer = layui.layer,
        transfer = layui.transfer,
        $ = layui.jquery;

    var render = treeTable.render({
        elem: '#treeTable',
        url: '/sysMenu/list',
        method: 'POST',
        cols: [
            {
                key: 'title',
                title: '菜单名'
            },
            {
                key: 'url',
                title: 'url'
            },
            {
                key: 'orderd',
                title: '序号'
            },
            {
                title: '操作',
                template: function (data) {
                    var html = '';
                    html += '<a class="layui-btn layui-btn-xs" lay-filter="edit">编辑</a>';
                    html += '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-filter="delete">删除</a>';
                    html += '<a class="layui-btn layui-btn-normal layui-btn-xs" lay-filter="allotButton">分配按钮</a>';
                    return html;
                }
            }
        ],
        icon_key: 'title',
    });

    // 监听编辑操作
    treeTable.on('tree(edit)', function (data) {
        commonTable.commonLayerPage(2, data.item);
    });

    // 监听删除操作
    treeTable.on('tree(delete)', function (data) {
        if (!data.item.is_end) {
            // 非叶子节点,无法删除
            layer.msg("模块下有子菜单，请先删除子菜单");
            return;
        }
        layer.confirm(
            '删除操作不可恢复，确认要删除吗？',
            {
                skin: 'layui-layer-lan'
            },
            function (layerIndex) {
                // 确定按钮被点击,向后台发起删除请求,请求成功再关闭该询问框
                $.ajax({
                    url: 'delete',
                    data: data.item,
                    type: 'POST',
                    dataType: 'json',
                    success: function (data) {
                        var msg = '';
                        if (data.code === REQUEST_SUCCESS_CODE) {
                            // 关闭重新向后台发起数据,刷新树节点
                            layer.close(layerIndex);
                            treeTable.render(render);
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
    });

    // 监听分配按钮
    treeTable.on('tree(allotButton)', function (res) {
        var title = res.item.title + ' > 分配按钮';
        var menuId = res.item.id;
        var menuUrl = res.item.url;
        layer.open({
            type: 1,
            title: title,
            skin: 'layui-layer-lan',
            btn: ['确定', '取消'],
            maxmin: true,
            area: ['479px', '393px'],
            content: $('#allotButton'),
            // resize: false,
            success: function (layero, index) {
                // 弹出层成功回调函数,渲染穿梭框数据
                var params = {menuId: menuId};
                $.post("/sysMenu/getTransferData", params, function (result) {
                    //渲染
                    transfer.render({
                        elem: '#allotButton',
                        data: result.data,
                        value: result.rightSelectData,
                        title: ['待选区', '已选区'],
                        showSearch: true,
                        height: 300,
                        id: 'allotButtonTransfer'
                    });
                }, 'json');
            },
            yes: function (index, layero) {
                // 获得穿梭框右侧选中数据
                var transferSelectData = transfer.getData('allotButtonTransfer');
                var arr = [];
                $.each(transferSelectData, function (i, e) {
                    arr.push(
                        {
                            spId: menuId,
                            spUri: menuUrl,
                            spOperateName: e.value,
                            spName: e.title
                        }
                    );
                });

                if (arr.length === 0) {
                    // 右侧没有选中数据
                    arr.push(
                        {
                            spId: menuId
                        }
                    );
                }

                $.ajax({
                    url: '/sysMenu/allotButton',
                    data: JSON.stringify(arr),
                    type: 'POST',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        var msg = '';
                        if (data.code === REQUEST_SUCCESS_CODE) {
                            msg = '按钮分配成功';
                            // 关闭弹出层
                            layer.close(index);
                        } else {
                            msg = data.msg;
                        }
                        layer.msg(msg);
                    }
                });
            }
        });
    });

    // 定义回调成功函数,type 1 新增,2编辑
    window.layerPageSuccessCallback = function (type) {
        treeSelect.render({
            // 选择器
            elem: '#treeSelect',
            // 数据
            data: '/sysMenu/getTreeSelectNode',
            // 异步加载方式：get/post，默认get
            type: 'post',
            // 占位符
            placeholder: '请选择上级菜单',
            // 是否开启搜索功能：true/false，默认false
            search: true,
            // 点击回调
            click: function (data) {
                // 设置父节点id 到表单隐藏域
                $('#spParentId').val(data.current.id);
            }
        });
    };
});