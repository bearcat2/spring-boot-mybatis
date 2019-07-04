layui.use(['commonTable'], function () {
    var commonTable = layui.commonTable;

    // 渲染表格
    var customConfig = {
        cols: [[
            {field: 'soName', title: '操作名称'},
            {field: 'soShowName', title: '显示名称'},
            {field: 'soOrderd', title: '序号'},
            {
                field: 'soCreateTime', title: '创建时间', templet: function (d) {
                    return formatDate(d.soCreateTime, DATE_TIME_FORMAT);
                }
            },
            {
                title: '操作', toolbar: '#toolBar', fixed: 'right'
            }
        ]]
    };
    commonTable.render(customConfig);
});