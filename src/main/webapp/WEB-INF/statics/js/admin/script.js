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
                url: "/crainnogao/admin/loginVal",
                data: data,
                dataType: "json",
                success: function (resp) {
                    if (resp.result == 0) {
                        // alert(JSON.stringify(resp.data));
                        document.cookie = "uid="+resp.data.uid;
                        document.cookie = "name="+resp.data.userName;
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
    });

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
        };
        $.ajax({
            url:"/issue",
            type:"post",
            data:data,
            dateType:"json",
            success:function (data) {
                if(data.result==0){
                    alert("发表成功!");
                    window.location.href='/crainnogao/admin/crainnogao_ad'
                }else{
                    alert("发表失败!")
                }
            },
            error:function(){
                alert("网络连接失败!");
            }
        })
    });
    //删除日志
    var abcSort = document.getElementById('abc');
    var deleteSort = abcSort.getElementsByClassName('delete');
    var editSort = abcSort.getElementsByClassName('update');
    for (var i = 0;i<deleteSort.length;i++){
        deleteSort[i].index = i;
        deleteSort[i].onclick=function () {
            var logId = $(this).parent().parent().data('id');
            var data = {logId:logId};
            $.post('/delete',data,function (resp) {
                if (resp.result==0){
                    window.location.href='/crainnogao/admin/crainnogao_ad';
                    alert("删除成功!")
                }else {
                    alert("删除失败!")
                }
            })
        };;;;;;;
        editSort[i].onclick=function () {
            var logId = $(this).parent().parent().data('id');
            var data = {logId:logId};
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['600px', '400px'], //宽高
                content: 'logId='+logId
            });
        }
    }
    //编辑用户
    $(document).on('click','.edit',function () {
        var id = $("#uid").val();
        layer.open({
            type: 2,
            skin: 'layui-layer-rim', //加上边框
            area: ['600px', '400px'], //宽高
            content: ['/crainnogao/userinfo/edit?id='+id,'no']
        });
    })
});
