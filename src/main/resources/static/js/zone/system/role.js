var data_format = {
    "col_num":5,
    "col_attr": [
        // user_id 列 (隐藏)
        {"ext": false,"col_name": "roleId","display": "none"},
        // checkbox 列
        {"ext": true, "col_header": "<input type='checkbox'>", "width": "5%", "html_content": "<input type='checkbox'>"},
        // user_Name 列
        {"ext": false,"col_name": "roleName", "col_header": "角色名称", "width": "10%"},
        // 操作按钮列
        {"ext": true, "col_header": "操作", "width": "10%", "html_content": "<button class='btn btn-info btn-xs perms_allocate_btn' onclick='obj.showRolePerms(this)' >权限分配</button>&nbsp;&nbsp;<button class='btn btn-danger btn-xs'>删除</button>"},
        // 附加隐藏列
        {"ext":false, "col_name": "userId", "display": "none"}
    ]
};



$(function(){

    fetch_table_data(1, 0);

});


/**
 * 拉取数据表格的信息
 * @param page_num
 * @param page_size
 */
var fetch_table_data = function(page_num, page_size){

    var data = {};
    data.pageSize = page_size;
    data.pageNum = page_num;

    $.ajax({
        url:"/zone/sys/role/list",
        type:"post",
        contentType:"application/json",
        async:true,
        data:JSON.stringify(data),
        dataType:"json",
        success: function(result){
            if(result.success){
                var table_html = "<caption><b>全部角色</b></caption>";
                table_html += init_data_table(data_format, result.t.datas);
                $("#data_table").html( table_html);
            }else{
                console.log(result);
                console.log("未能成功获取到数据");
                alert("!!!");
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            console.log("请求用户列表数据出错，\n错误信息:{" + textStatus + "}\n异常信息:{" + errorThrown + "}");
        }

    });
};




var obj = {
    roleId : null,
    setting : {
        check: {
            enable: true,
            autoCheckTrigger: true,
            chkStyle: "checkstyle",
            chkboxType: { "Y" : "ps", "N" : "ps" }
        },
        data: {
            simpleData: {
                enable: false
            }
        }
    },

    init : function(){
        //this.permsAllocate();
    },

    /**
     * 回显角色所属的所有权限
     * @param btn
     */
    showRolePerms : function (btn) {
        if(!btn) return;
        $("#perm_allocation_container_div").removeClass("vanish");
        this.roleId = $(btn).parent().parent().children("td").eq(0).html();
        console.log("roleId : " + this.roleId);
        $.ajax({
            url:"/zone/sys/user/getPermByRoleId",
            type:"post",
            async:true,
            data:{"roleId": this.roleId},
            dataType:"json",
            success: function(result){
                if(result.success){
                    //console.log(JSON.stringify(result));
                    // 回显所属角色的菜单权限
                    obj.showRoleMenuPerms(result.t.menus);
                    // 回显所属角色的按钮权限
                    //obj.showRoleButtonPerms(result.t.buttons);
                }else{
                    console.log(result);
                    console.log("未能成功获取到数据");
                    alert("!!!");
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                console.log("请求用户列表数据出错，\n错误信息:{" + textStatus + "}\n异常信息:{" + errorThrown + "}");
            }
        });
    },

    /**
     * 回显该角色下面的菜单权限（zTree回显菜单树）
     * @param data
     */
    showRoleMenuPerms : function(root_menu){

        var zNodes = [];

        $.each(root_menu.childMenu, function(i, _lv_1){
            zNodes[i]={id:_lv_1.menuId, pId:root_menu.menuId, name:_lv_1.menuName, open:true, isParent:true};
            var lv_2_menus = [];
            var _lv_2_checked_num = 0;
            $.each(_lv_1.childMenu, function(j, _lv_2){
                lv_2_menus[j] = {id:_lv_2.menuId, pId:_lv_1.menuId, name: _lv_2.menuName, isParent:false};
                if(_lv_2.checked) {
                    lv_2_menus[j].checked = true;
                    _lv_2_checked_num++;
                }
            });
            // 二级菜单都被选中时，一级菜单也设置为选中状态（ztree没有为 zNode设置半选中属性，所以）
            zNodes[i].children = lv_2_menus;
            if(_lv_1.childMenu.length === _lv_2_checked_num){
                zNodes[i].checked = true;
            }
        });

        $.fn.zTree.init($("#menu_tree"), this.setting, zNodes);
    },

    /**
     * 回显该角色下面的按钮权限（checkbox复选框展示）
     * @param data
     */
    showRoleButtonPerms : function(buttons){

    },

    /**
     * 为角色分配权限
     */
    rolePermsAllocate : function(){
        var treeObj = $.fn.zTree.getZTreeObj("menu_tree");

        // 获取到所有选中的菜单权限
        var checked_menu_perms = treeObj.getCheckedNodes(true);
        var menu_ids = [];
        $.each(checked_menu_perms, function(i, menu_perm){
            menu_ids[i] = menu_perm.id;
        });
        console.log(String(menu_ids));
        // 获取到所有选中的按钮权限

        // 请求后台
        $.ajax({
            url:"/zone/sys/role/setRolePerms",
            type:"post",
            async:true,
            data:{
                "roleId": parseInt(this.roleId),
                "menuIds": String(menu_ids),
                "btnIds":""},
            dataType:"json",
            success: function(result){
                if(result.success){
                    // 提示：角色权限分配成功

                }else{
                    console.log(result);
                    console.log("未能成功给角色分配权限");
                    alert("!!!");
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                console.log("为角色分配权限出错，\n错误信息:{" + textStatus + "}\n异常信息:{" + errorThrown + "}");
            }
        })
    }
};
obj.init();
