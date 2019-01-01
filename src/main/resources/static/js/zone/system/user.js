
var data_format = {
    "col_num":10,
    "col_attr": [
        // user_id 列 (隐藏)
        {"ext": false,"col_name": "userId","display": "none"},
        // checkbox 列
        {"ext": true, "col_header": "<input type='checkbox'>", "width": "5%", "html_content": "<input type='checkbox'>"},
        // user_Name 列
        {"ext": false,"col_name": "userName", "col_header": "名称", "width": "20%"},
        // user_age 列
        {"ext": false,"col_name": "userAge", "col_header": "年龄", "width": "10%"},
        // user_gender 列
        {"ext": false, "col_name": "userGender", "col_header": "性别", "width": "10%"},
        // user_account_state 列
        {"ext": false, "col_name": "userAccountState", "col_header": "状态","width": "10%"},
        // user_regist_date 列
        {"ext": false, "col_name": "userRegistDate", "col_header": "注册日期", "width": "20%"},
        // 操作按钮列
        {"ext": true, "col_header": "操作", "width": "20%", "html_content": "<button class='btn btn-info btn-xs' onclick='obj.showAssignRoleToUserModal(this)' data-toggle='modal' data-target='#roleAssign_modal'>角色分配</button>&nbsp;&nbsp;<button class='btn btn-danger btn-xs'>删除</button>"},
        // user_role 用户角色列
        {"ext":false, "col_name": "userId", "display": "none"},
        // 附加隐藏列
        {"ext":false, "col_name": "userId", "display": "none"}
    ]
};

var page_num = 1;
var page_size = 9;


$(function(){

    fetch_table_data(page_num, page_size);

});


var fetch_table_data = function(page_num, page_size){

    // 获取到条件查询参数
    var data = search_form_data();
    data.pageSize = page_size;
    data.pageNum = page_num;

    $.ajax({
        url:"/zone/sys/user/list",
        type:"post",
        contentType:"application/json",
        async:true,
        data:JSON.stringify(data),
        dataType:"json",
        success: function(result){
            if(result.success){
                //console.log(data);
                //console.log(result.t.datas);
                //console.log(result.t.pageNum);

                var table_html = init_data_table(data_format, result.t.datas);
                var pagination_html = fill_pagination_info(result.t);
                $("#data_table").html(table_html);
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

    userId : null,
    /**
     * 为用户分配角色
     * @param btn
     */
    showAssignRoleToUserModal : function(btn){
        // 先清除模态框中的checkBox
        $("#assign_role_to_user").html("");
        // 先获取到用户ID
        var tdNodes = $(btn).parent().parent().children();
        this.userId = $(tdNodes[0]).html();
        // 弹出模态框
        console.log("userId" + this.userId);

        // 拉取所有角色信息(checkbox)
        $.post(
            "/zone/sys/user/getRoleByUserId",
            { "userId": obj.userId },
            function(result){
                if(result.success){
                    console.log(result.t);
                    obj.showUserRoles(result);
                }else{
                    console.log(result);
                }
                //process(data);
            },"json"
        );
    },

    /**
     * 回显用户拥有的角色
     * @param result
     */
    showUserRoles : function(result){

        var tmpl_html =
            '{{each(idx, role_vo) t}}'+
            '     <label class="checkbox-inline">'+
            '         <input ' +
            '           type="checkbox" ' +
            '           name="userRole" ' +
            '           value="${role_vo.roleId}" ' +
            '           ${ role_vo.checked ? "checked" : null }'+
            '           />${role_vo.roleName}'+
            '     </label>'+
            '{{/each}}';

        $.template("form_tmpl",tmpl_html);
        //然后再使用模板
        $.tmpl("form_tmpl", result).appendTo("#assign_role_to_user");
    },

    /**
     * 执行用户角色分配
     */
    assignUserRole : function () {
        var userRoles = $("#assign_role_to_user input:checked");
        var userRoleIds = [];
        $.each(userRoles, function(i, checked){
            userRoleIds[i] = checked.value;
        });

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
    },

    /**
     * 手动显示消息提示模态框
     * @param hint
     */
    showInteractiveHint : function (hint) {
        $("#hint_info_container").html(hint);
        $('#hint_modal').modal('show');
    },

    /**
     * 手动关闭消息提示模态框
     */
    closeInteractiveHint : function(){
        var isBlock = $("#hint_modal").css("display");
        // 如果用户没有手动关闭，那么消息提示模态框显示1.5秒之后自动关闭
        if("block" === isBlock){
            $("#hint_modal").modal('hide');
        }

        $("#roleAssign_modal").modal('hide');
    }
};