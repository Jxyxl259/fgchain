
$(function(){

    /* 显示登陆 iframe 页面 */
    $("#show_login_form_btn").click(
        function(){
            $("#login_form_container").show();
        }
    );

    /**
     * 用户登录
     */
    $("#login_btn").click(function(){

        /* 获取登录表单的值 */
        var username = $("#username").val();
        var password = $("#password").val();

        if(isEmpty(username) || isEmpty(password) ){
            alert("请输入用户名 及密码");
            return;
        }

        //var flag = false;
        var form = new FormData(document.getElementById("login_form"));

        $.ajax({
            url:"/doLogin",
            type:"post",
            data:form,
            async:false,
            processData:false,
            contentType:false,
            success:function(res){
                // TODO 重置登陆form表单内容, 隐藏登陆 iframe DIV 导航上不再显示登陆按钮, 显示登陆用户名 并显示"我的"
                if(res.success){
                    console.log("登陆成功,跳转到首页");
                    window.location.href=window.location.href.substr(0,window.location.href.lastIndexOf("/"));

                }else{
                    console.error("登陆失败, 错误原因:" + res.resultMsg);
                }
            }
        });

        return false;
    })

});



/**
 * 用户头像回显
 */
function showUserHeaderIcon(input_ele){
    var username = $(input_ele).val();
    $.ajax({
        url:"/user/userHeaderIcon/" + username,
        type:"post",
        async:true,
        success:function(res){
            if(res.success){
                console.log("获取用户头像成功");
                $("table>thead>tr>td>div>img").attr("src",res.t.userHeadIconUrl);

            }else{
                console.error("未能获取到用户头像");
            }
        }
    });
}


/* 判断是否为空 */
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}