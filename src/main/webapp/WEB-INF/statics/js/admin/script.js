$(function () {
    $("#loginSubmit").click(function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        var data = {
            userName:userName,
            password:password
        }
        $.ajax({
            type: 'POST',
            url: "/gaobh/blog/login",
            data: data,
            dataType:"text",
            success: function (resp) {
                alert("成功");
            },
            error:function () {
                alert("失败");
            }

        });
    })
})
