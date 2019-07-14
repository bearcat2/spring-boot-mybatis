layui.use(['commonTable', 'table'], function () {
    var commonTable = layui.commonTable,
        table = layui.table;

    // 渲染表格
    var customConfig = {
        cols: [[
            {field: 'sjName', title: '任务名',width:100},
            {field: 'sjGroup', title: '任务分组',width:100},
            {
                field: 'sjStatus', title: '任务状态',width:100, templet: function (d) {
                    var status = '';
                    switch (d.sjStatus) {
                        case 1:
                            status = '停止';
                            break;
                        case 2:
                            status = '运行';
                            break;
                        default:
                            status = '未知';
                            break;
                    }
                    return status;
                }
            },
            {field: 'sjCronExpression', title: 'corn表达式',width:100},
            {field: 'sjBeanClass', title: '调用类名称',width:250},
            {field: 'sjSpringBeanName', title: 'springBean',width:150},
            {field: 'sjMethodName', title: '方法名',width:80},
            {field: 'sjDescription', title: '描述',width:100},
            {
                field: 'sjCreateTime', title: '创建时间',width:160, templet: function (d) {
                    return formatDate(d.sjCreateTime, DATE_TIME_FORMAT);
                }
            },
            {
                field: 'sjUpdateTime', title: '修改时间',width:160, templet: function (d) {
                    return formatDate(d.sjUpdateTime, DATE_TIME_FORMAT);
                }
            },
            {
                title: '操作', toolbar: '#toolBar', fixed: 'right',width:200
            }
        ]]
    };
    commonTable.render(customConfig);
});