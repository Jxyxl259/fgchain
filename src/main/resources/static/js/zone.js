/* 后台页面加载时执行 */
$(function(){

    zone.init();


    //$("div.menu_L1").

    $("#zone_menu_tree_container_div").mouseout( function(){
        $("#zone_menu_tree_container_div").addClass("menu_shrink");
        $("#zone_iframe_detail_container_div").addClass("iframe_expansion");
        $(".menu_L2").removeClass("in").attr("aria-expanded")
    });

    setTimeout("zone.addEventToMenuLv_1()",1000);
});




// TODO 权限菜单加载
var zone = {

    /**
     * 文档初始化
     */
    init:function(){
        zone.fetchMenuPerms();
    },

    /**
     * 拉取用户的菜单权限
     */
    fetchMenuPerms : function(){
        $.post(
            "/user/fetchUserPerms",
            function(result){
                if(result.success){
                    //console.log(result);
                    zone.showMenus(result.t);
                }else{
                    console.log(result);
                    obj.showInteractiveHint("执行角色分配失败,请联系管理员");
                }
            },"json"
        );
    },

    showMenus : function(root_menu){

        var menu_tree_content_html =
        '{{each(idx, _m_lv_1) childMenu}}'+
        ' <div class="menu_L1 panel panel-default">'+
        '     <div class="less_padding panel-heading">'+
        '           <h4 class="panel-title">'+
        '               <a class="${_m_lv_1.menuIcon}" data-toggle="collapse" data-parent="#menu_tree_div" href="#menu_level_1_id_${_m_lv_1.menuId}" ></a>'+
        '           </h4>'+
        '     </div>'+
        '     <div id="menu_level_1_id_${_m_lv_1.menuId}" class="menu_L2 panel-collapse collapse" >'+
        '           <div class="panel-body">'+
        '               <div class="row">'+
        '                    <ul type="none">'+
        '                        {{each(idx, _m_lv_2) childMenu}}'+
        '                        <li><a target="detail_iframe" href="${_m_lv_2.menuRelativeUrl}">${_m_lv_2.menuName}</a></li>'+
        '                        {{/each}}'+
        '                    </ul>'+
        '               </div>'+
        '           </div>'+
        '      </div>'+
        ' </div>'+
        '{{/each}}';

        $.template("menu_tree_tmpl", menu_tree_content_html);
        $.tmpl("menu_tree_tmpl", root_menu).appendTo("#zone_menu_tree_container_div");

    },


    /**
     * 鼠标移动到一级菜单，即展开耳机菜单
     * 为左侧一级菜单添加 mouseover事件
     * 延迟1000ms 触发，(等待jQuery.tmpl函数执行完)，
     */
    addEventToMenuLv_1 : function(){
        $("div.menu_L1,#zone_menu_tree_container_div").mouseover(this,function(){
            $("#zone_menu_tree_container_div").removeClass("menu_shrink");
            $("#zone_iframe_detail_container_div").removeClass("iframe_expansion");
            $($(this).children().eq(1)).addClass("in");
        });
    }
};