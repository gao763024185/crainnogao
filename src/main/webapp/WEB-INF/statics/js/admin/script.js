$(function () {
    //登录验证
    $(".submit_lgbtn").click(function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        var codetext = $("#codetext").val();
        var data = {
            userName:userName,
            password:password,
            codetext:codetext
        };;;;;;;;;;;;;;;;;;;;;;
        $.ajax({
            type: 'POST',
            url: "/crainnogao/admin/login",
            data: data,
            dataType:"text",
            success: function (resp) {
                if(resp.result!=null && resp.result==0) {
                    alert("登录成功");
                }else{
                    alert("登录失败");
                }
            },
            error:function () {
                alert("失败");
            }

        });
    });;;;;;;;;;;;;;;;;;;;;;
    //点击刷新图片验证码
    $(".noclear").click(function () {
        var time = new Date().getTime();
       document.getElementById("verPic").src="/VerifyCodeServlet?time="+time;
    })
});;;;;;;;;;;;;;;;;;;;;;
