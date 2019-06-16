layui.config({
    version: '1.0.0',
    base: '../../../static/js/modules/'
}).use(['treeTable', 'form', 'jquery'], function () {
    var treeTable = layui.treeTable,
        form = layui.form,
        $ = layui.jquery;

    // 监听表单提交
    form.on('submit(formDemo)', function (data) {
        console.log(data.field);
        // 关闭iframe 弹窗
        // var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        // parent.layer.close(index); //再执行关闭
        return false;
    });

    treeTable.render({
        elem: '#tree1',
        url: '../../../data/table-tree.json',
        icon_key: 'title',
        cols: [
            {
                key: 'title',
                title: '名称',
            }
        ],
        is_cache: false
    });

    $('#tree1').on('click', '[data-down]', function () {
        $(this).parents('.layui-unselect').find('input').val($(this).text());
        var dataId = $(this).parent('ul').data('id');
        $('#pId').val(dataId);
    });

    $('.layui-select-title').click(function () {
        $(this).parent().hasClass('layui-form-selected') ? $(this).next().hide() : $(this).next().show();
        $(this).parent().toggleClass('layui-form-selected');
    });

    $(document).on("click", function (i) {
        !$(i.target).parent().hasClass('layui-select-title') && !$(i.target).parents('table').length && !(!$(i.target).parents('table').length && $(i.target).hasClass('layui-icon')) && $(".layui-form-select").removeClass("layui-form-selected").find('.layui-anim').hide();
    });
});