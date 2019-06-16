layui.use(['treeTable', 'layer', 'jquery', 'commonTable'], function () {
    var treeTable = layui.treeTable,
        commonTable = layui.commonTable,
        layer = layui.layer,
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
                template: function (item) {
                    var html = '';
                    html += '<a class="layui-btn layui-btn-xs" lay-filter="edit">编辑</a>';
                    html += '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-filter="delete">删除</a>';
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

    // 点击批量删除
    $('.batchDelete').on('click', function () {
        var checked = treeTable.checked(render);
        if (checked.length === 0) {
            layer.msg("请选择需要删除的菜单项");
            return;
        }

        layer.confirm('删除操作不可恢复,确定要删除吗？',
            {title: '操作提示', area: ['300px', '160px']},
            function (index) {
                console.log("确定被点击了...");
                layer.close(index);
            }
        );
    });
});