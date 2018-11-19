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
        {"ext": true, "col_header": "操作", "width": "10%", "html_content": "<button class='btn btn-info btn-xs'>权限分配</button>&nbsp;&nbsp;<button class='btn btn-danger btn-xs'>删除</button>"},
        // 附加隐藏列
        {"ext":false, "col_name": "userId", "display": "none"}
    ]
};



$(function(){

    fetch_table_data(1, 0);

});



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
                var table_html = init_data_table(data_format, result.t.datas);
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