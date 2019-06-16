layui.use(['commonTable', 'jquery'], function () {
    var commonTable = layui.commonTable,
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
});