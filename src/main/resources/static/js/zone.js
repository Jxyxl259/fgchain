/* 后台页面加载时执行 */
$(function(){

    $("#zone_menu_tree_container_div li").click(function(){
        var iframe_url = $(this).children("a").attr("content");
        $("#zone_iframe_detail_container_div").attr("src", iframe_url);
    });

});