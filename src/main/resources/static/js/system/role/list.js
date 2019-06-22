layui.use(['commonTable', 'jquery', 'table', 'tree','form'], function () {
    var commonTable = layui.commonTable,
        table = layui.table,
        tree = layui.tree,
        form = layui.form,
        $ = layui.jquery;

    // 渲染表格
    var customConfig = {
        cols: [[
            {field: 'srName', title: '角色名'},
            {field: 'srDescription', title: '角色描述'},
            {
                field: 'srCreateTime', title: '创建时间', templet: function (d) {
                    return formatDate(d.srCreateTime, DATE_TIME_FORMAT);
                }
            },
            {
                title: '操作', toolbar: '#toolBar', fixed: 'right'
            }
        ]]
    };
    commonTable.render(customConfig);

    // 分配权限按钮,不是所有页面共用的,在这单独处理即可
    table.on('tool(dataTableFilter)', function (obj) {
        //获得当前行数据
        var data = obj.data;
        //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var layEvent = obj.event;
        if (layEvent === 'allotPrivilege') {
            layer.open({
                type: 2,
                title: '分配权限',
                skin: 'layui-layer-lan',
                maxmin: true,
                area: ['480px', '385px'],
                content: 'allotPrivilege_ui?roleId='+ data.srId,
                // resize: false,
            });
        }
    });
});