/* 后台页面加载时执行 */
$(function(){

    // 先向后台请求用户的权限数据
    // 设置为全局变量
    // 作为参数传入菜单收缩函数
    // 函数中对数据做处理，生成展开菜单

    /* 左侧菜单栏展示js */
    $("div.menu_L1,#zone_menu_tree_container_div").mouseover(this,function(){
        if(this.id == "zone_menu_tree_container_div"){
            $("#zone_menu_tree_container_div").removeClass("menu_shrink");
            $("#zone_iframe_detail_container_div").removeClass("iframe_expansion");
        }else{
            $($(this).children().eq(1)).addClass("in");
        }
    });

    $("#zone_menu_tree_container_div").mouseout(function(){
        $("#zone_menu_tree_container_div").addClass("menu_shrink");
        $("#zone_iframe_detail_container_div").addClass("iframe_expansion");
        $(".menu_L2").removeClass("in").attr("aria-expanded")
    });

});


// TODO 权限菜单加载
var zone = {

    /**
     *
     */
    init:function(){
        zone.fetchMenuPerms();
    },

    /**
     * 拉取用户的菜单权限
     */
    fetchMenuPerms : function(){
        $.post(
            "/zone/sys/user/assignRoles",
            { "userId": obj.userId, "roleIds":String(userRoleIds)},
            function(result){
                if(result.success){
                    //console.log(result.t);
                    //显示消息提示模态框, 并设置1.5秒之后关闭模态框
                    setTimeout("obj.closeInteractiveHint()", 1500);
                    obj.showInteractiveHint(result.message);
                }else{
                    console.log(result);
                    obj.showInteractiveHint("执行角色分配失败,请联系管理员");
                }
            },"json"
        );
    }

};