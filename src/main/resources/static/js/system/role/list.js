layui.use(['commonTable', 'table'], function () {
    var commonTable = layui.commonTable,
        table = layui.table;

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

    // 分配权限回调函数
    window.allotPrivilege = function (data) {
        layer.open({
            type: 2,
            title: '分配权限',
            skin: 'layui-layer-lan',
            maxmin: true,
            area: ['480px', '385px'],
            content: 'allotPrivilege?roleId=' + data.srId,
            // resize: false,
        });
    }
});