layui.use(['form', 'layer', 'jquery'], function () {
    var $ = layui.jquery,
        form = layui.form,
        layer = layui.layer;

    var projectName = $('#baseUrl').val();


    // 提交监听
    form.on('submit(login)', function (data) {
        $.ajax({
            url: projectName + '/sysUser/login',
            type: 'POST',
            data: data.field,
            dataType: 'json',
            success: function (data) {
                if (data.code === 0) {
                    // 登录成功跳转到首页
                    window.location.href = projectName + "/index";
                } else {
                    layer.msg("系统提示 : " + data.msg);
                }
            }
        });
        return false;
    });

    //刷新验证码
    $("#captcha").on('click', function () {
        // 请求路径带上随机数,避免浏览器缓存
        // var projectName = $('#baseUrl').val();
        var refreshUrl = projectName + "/getCaptcha?random=" + new Date().getTime();
        $(this).attr("src", refreshUrl);
    });
});