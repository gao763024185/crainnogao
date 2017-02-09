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
            var r=confirm("您真的要删了我嘛?");
            if(r==true){
                $.post('/delete',data,function (resp) {
                    if (resp.result==0){
                        window.location.href='/crainnogao/admin/crainnogao_ad';
                    }else {
                        alert("删除失败!")
                    }
                })
            }
        };
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
            content: ['userEdit?id='+id]
        });
    });;;

    //搜索日志
    $(document).on('click','.search-bt',function () {
        var logTitle = $('#inlogTitle') .val();
        var data={logTitle:logTitle,pageNum:1};
        ajaxFenye(data);
    });;;

    //分页
    var pageNuminit = $('#pageNuminit').val();
    // // var pageNum = $('#pageNum').val();
    var totalPage = $('#totalPage').val();
    //上一页初始化
    if(pageNuminit==1){
        $('.prevPage').addClass('disabled');
        $('.prevPage').removeAttr("href");
        document.getElementById('prevPage').style.backgroundColor="#f4f5ef";
    }
    if(pageNuminit==totalPage){
        $('.nextPage').addClass('disabled');
        $('.nextPage').removeAttr("href");
        document.getElementById('nextPage').style.backgroundColor="#f4f5ef";
    }

    // if(pageNum==totalPage){
    //     $('.nextPage').addClass('disabled');
    //     $('.nextPage').removeAttr("href");
    //     document.getElementById('nextPage').style.backgroundColor="#f4f5ef";
    // }

    // $(document).on('click','.midPage a',function () {
    //     var _index = $(this).index();
    //     $(this).addClass('current').siblings('a').removeClass('current');
        // $(this).addClass('disabled');
        // $(this).removeAttr("href");
    // })


        $(document).on('click','.tcdNumber',function () {
            var logTitle = $('#inlogTitle').val();
            var data = {
                pageNum:$(this).index(),
                item:2,
                logTitle:logTitle
            };
            ajaxFenye(data);
        });;;

    function ajaxFenye(data) {
        $.ajax({
            url:"/crainnogao/fenye",
            type:"post",
            data:data,
            dataType:"json",
            success:function (resp) {
                var $str = '<table class="table table-hover"><thead><tr><th>日志ID</th><th>主题</th>'+
                    '<th>概要</th><th>上传时间</th><th>更新时间</th><th>操作</th></tr></thead><tbody>';
                for (var i=1;i<=resp.len;i++){
                    $str += '<tr><td>'+resp.logs2[i-1].logId+'</td><td>'+resp.logs2[i-1].logTitle+'</td>'+
                        '<td>'+resp.logs2[i-1].logSummary+'</td><td>'+resp.logs2[i-1].logCreatedStr+'</td>'+
                        '<td>'+resp.logs2[i-1].logUpdateStr+'</td><td><a class="delete">删除</a>&nbsp;<a class="update">编辑</a></td></tr>';
                }
                document.getElementById("ajshow0").innerHTML=$str;
                var $str1 = '<div class="tcdPageCode">'+
                    '<a href="javascript:;" class="prevPage"><i class="material-icons">navigate_before</i></a>';
                for(var i=1 ;i<=resp.toPage;i++){
                    if (i==data.pageNum){
                        $str1 += '<a href="javascript:;" class="tcdNumber current">'+i+'</a>';
                    }else{
                        $str1 += '<a href="javascript:;" class="tcdNumber">'+i+'</a>';
                    }
                }
                $str1 += '<a href="javascript:;" class="nextPage"><i class="material-icons">navigate_next</i></a></div>';
                document.getElementById("fenye").innerHTML=$str1;
            },
            error:function () {
                alert("网络连接失败！");
            }
        })
    }
});
