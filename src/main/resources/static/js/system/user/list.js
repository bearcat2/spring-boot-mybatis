layui.use(['commonTable', 'jquery'], function () {
    var commonTable = layui.commonTable,
        $ = layui.jquery;

    // 渲染表格
    var customConfig = {
        cols: [[
            {field: 'suLoginName', title: '登录名'},
            {field: 'suRealName', title: '真实姓名'},
            {
                field: 'suCreateTime', title: '创建时间', templet: function (d) {
                    return formatDate(d.suCreateTime, DATE_TIME_FORMAT);
                }
            },
            {
                title: '操作', toolbar: '#toolBar', fixed: 'right'
            }
        ]]
    };
    commonTable.render(customConfig);
});