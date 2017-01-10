$(function () {
    //登录验证
    $(".submit_lgbtn").click(function () {
        var unamevalid = /^[a-zA-Z0-9_\u4e00-\u9fa5]{5,10}$/;  //只含有汉字、数字、字母、下划线，下划线位置不限
        var pwdvalid = /^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){4,19}$/;   //只能输入5-20个以字母开头、可带数字或“_”的字串
        var userName = $("#username").val();
        var password = $("#password").val();
        var codetext = $("#codetext").val();
        if (userName == "") {
            alert("用户名不能为空");
            $("#userName").focus();
        } else if (password == "") {
            alert("密码不能为空");
            $("#password").focus();
        } else if (codetext == "") {
            alert("验证码不能为空");
            $("#codetext").focus();
        } else if (!unamevalid.test(userName)) {
            alert("用户名只含有汉子、数字、字母、下划线的5~10位");
            $("#userName").focus();
        } else if (!pwdvalid.test(password)) {
            alert("只能输入5-20个以字母开头、可带数字或“_”的密码");
            $("#password").focus();
        } else {
            var data = {
                userName: userName,
                password: password,
                codetext: codetext
            };
            $.ajax({
                type: 'POST',
                url: "/crainnogao/admin/login",
                data: data,
                dataType: "json",
                success: function (data) {
                    //var resp=eval("("+resp+")"); 两种jQuery解析json数据的方法
                    // var resp = JSON.parse(data);
                    if (data.result == 0) {
                        window.location.href='/crainnogao/admin/crainnogao_ad'
                    } else {
                        alert(resp.msg);
                    }
                },
                error: function () {
                    alert("失败");
                }

            });
        }
    });
    //点击刷新图片验证码
    $(".noclear").click(function () {
        var time = new Date().getTime();
       document.getElementById("verPic").src="/VerifyCodeServlet?time="+time;
    });;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

    $(document).on('click','.issuesubmit',function () {
        var codetext = $("#codetext").val();
        var logTitle = $("#logTitle").val();
        var logSummary = $("#logSummary").val();
        var logContent = $("#ts").val();
        var data = {
            codetext:codetext,
            logTitle:logTitle,
            logSummary:logSummary,
            logContent:logContent
        };;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        $.ajax({
            url:"/issue",
            type:"post",
            data:data,
            dateType:"json",
            success:function (data) {
                if(data.result==0){
                    alert("发表成功!");;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                    window.location.href='/crainnogao/admin/crainnogao_ad'
                }else{
                    alert("发表失败!")
                }
            },
            error:function(){
                alert("网络连接失败!");
            }
        })
    })
});
