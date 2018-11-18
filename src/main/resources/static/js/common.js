
$(function(){

});

/* 获取条件查询参数 */
var search_form_data = function(){
    var cond_data = {};
    var conds = $("#condition_search_form input.condition_search_input");
    conds.each(function(index, input_ele){
        cond_data[input_ele.name] = input_ele.value;
    });
    return cond_data;
};


/*"<tbody>"
"<tr>"
"<td>Tanmay</td>"
"<td>Bangalore</td>"
"<td>560001</td>"
"</tr>"*/

/* 初始化数据表格 */
var init_data_table = function(data_format, table_data){
    var loop_times = data_format.col_num;
    var data_models = data_format.col_attr;

    // 组织thead
    var thead = "<thead><tr>";
    for(var j = 0 ; j < loop_times; j++){
        var data_model = data_models[j];
        if("none" === data_model.display){
            thead += "<th style='display: none' >" + data_model.col_header + "</th>";
        }else{
            thead += "<th style='width: "+ data_model.width +"' >" + data_model.col_header + "</th>";
        }
    }
    thead += "</tr></thead>";

    // 组织tbody
    var tbody = "</tbody>";
    for(var key in table_data){
        var item = table_data[key];
        tbody += "<tr>";
        for(var i = 0; i < loop_times; i++){

            var data_model = data_models[i];
            var attr = data_model.col_name;
            if(!data_model.ext){// dto属性
                if("none" === data_model.display){
                    tbody += "<td style='display: none' >" + item[attr] + "</td>";
                }else{
                    tbody += "<td style='width: "+ data_model.width +"' >" + item[attr] + "</td>";
                }
            }else{// html代码

                tbody += "<td style='width: "+ data_model.width +"' >" + data_model.html_content + "</td>";
            }
        }
        tbody += "</tr>";
    };
    tbody += "</tbody>";
    return thead + tbody;
};

/* 回显分页信息 */
var full_pagination_info = function (paginationInfo){

};




/* 判断是否为空 */
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}