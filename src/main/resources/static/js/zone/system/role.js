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
    init : function(){
        //this.permsAllocate();
    },
    showRolePerms : function (btn) {
        if(!btn) return;
        var roleId = $(btn).parent().parent().children("td").eq(0).html();
        console.log("roleId : " + roleId);
        $.ajax({
            url:"/zone/sys/user/getPermByRoleId",
            type:"post",
            async:true,
            data:{"roleId": roleId},
            dataType:"json",
            success: function(result){
                if(result.success){
                    console.log(JSON.stringify(result));
                    obj.showRoleMenuPerms(result.t.menus);
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

        var setting = {
            check: {
                enable: true,
                autoCheckTrigger: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onCheck: function onCheck(event, treeId, treeNode) {
                    if (treeNode.checkedEx) return;
                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                    treeNode.halfCheck = false;
                    zTree.updateNode(treeNode);
                    treeNode.checkedEx = true;
                }
            }
        };

        var zNodes = [
            {name:"test1", open:true, children:[
                    {name:"test1_1"}, {name:"test1_2"}]},
            {name:"test2", open:true, children:[
                    {name:"test2_1"}, {name:"test2_2"}]}
        ];

        var zNodes = [];

        $.each(root_menu.childMenu, function(i, _lv_1){
            zNodes[i]={name:_lv_1.nemuName, open:true};
            $.each(_lv_1.childMenu, function(j, _lv_2){
                zNodes[i].children={name:_lv_2.menuName};
            })
        });


    },
};
obj.init();
