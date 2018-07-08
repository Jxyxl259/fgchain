$(function(){

/**
 * 用户登陆
 */
$("#login_btn").click(function(){

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