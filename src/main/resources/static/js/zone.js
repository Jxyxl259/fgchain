/* 后台页面加载时执行 */
$(function(){

    // 先向后台请求用户的权限数据
    // 设置为全局变量
    // 作为参数传入菜单收缩函数
    // 函数中对数据做处理，生成展开菜单

    /* 左侧菜单栏展示js */
    $("#zone_menu_tree_container_div").mouseover(function(){
        $("#zone_menu_tree_container_div").removeClass("menu_shrink");
        $("#zone_iframe_detail_container_div").removeClass("iframe_expansion");
    });

    $("#zone_menu_tree_container_div").mouseout(function(){
        $("#zone_menu_tree_container_div").addClass("menu_shrink");
        $("#zone_iframe_detail_container_div").addClass("iframe_expansion");
    });

});