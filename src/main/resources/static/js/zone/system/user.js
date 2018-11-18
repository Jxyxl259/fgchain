
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
        {"ext": true, "col_header": "操作", "width": "25%", "html_content": "<button>删除</button><button>编辑</button><button>详情</button>"},
        // 附加隐藏列
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
                console.log(table_html)
                $("#data_table").html(table_html);
                //full_pagination_info(result.paginationInfo);
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

