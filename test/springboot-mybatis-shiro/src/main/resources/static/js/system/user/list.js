layui.use(['commonTable','element', 'jquery'], function () {
    var commonTable = layui.commonTable;
    var element = layui.element,
        $ = layui.jquery;

    //获取当前用户当前页面的按钮权限
    $.get("/auth/getUserPerms",function(data){

        if(data!=null){

            getButton(data);


        }else{

            layer.alert("用户按钮权限不足，只限于只读")

        }

    });
    var getButton=function(data){

        //生成按钮
        for(var i=0;i<data.length;i++){
            var node = data[i];
            if(node.spUri == "/sysUser/list" && node.spType == 3){

                var button=$("<button class='layui-btn search' type='button' id='search'>搜索</button>");
                var buttonSelect=$("<button class='layui-btn layui-btn-danger' type='button' id='clear'>清空</button>");
                $(".diy-button").append(button);
                $(".diy-button").append(buttonSelect);
            }
            else if(node.spUri == "/sysUser/add" && node.spType == 3){

                var button=$("<button class='layui-btn' type='button' id='add'>新增</button>");
                $(".diy-button").append(button);

            }
        }

    };

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