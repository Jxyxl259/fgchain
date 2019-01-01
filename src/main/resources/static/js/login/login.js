$(function(){

    /**
     * 显示/隐藏 登录div
     */
    $("#show_login_form_btn").click(
        function(){
            $("#login_form_container").toggleClass("vanish");
        }
    );


    /**
     * 用户登陆
     */
    $("#login_btn").click(function(){

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

function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}



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
