$(function () {
    /* 菜单栏 start */
    // var offset = $("#tab-menu").offset();
    // var topPadding = 15;
    // $(window).scroll(function() {
    //     if ($(window).scrollTop() > offset.top) {
    //         $("#tab-menu").stop().animate({
    //             marginTop: $(window).scrollTop() - offset.top + topPadding
    //         });
    //     } else {
    //         $("#tab-menu").stop().animate({
    //             marginTop: 0
    //         });
    //     }
    // });
    $('#tab-menu > li').click(function(){
        $('#tab-menu > li').removeClass('selected');
        $(this).addClass('selected');
        $('.tab-content div.tab').slideUp('slow');
        $('.tab-content div.tab:eq(' + $('#tab-menu > li').index(this) + ')').slideDown('slow');
    }).mouseover(function() {
        $(this).addClass('mouseover');
        $(this).removeClass('mouseout');
    }).mouseout(function() {
        $(this).addClass('mouseout');
        $(this).removeClass('mouseover');
    });

    // $("#ajshow").on('click','.logTitle',function () {
    //     hljs.initHighlightingOnLoad();
    //     var oLogTitle = document.getElementsByClassName('logTitle');
    //     var _index = $(this).index();
    //     var logId = $("#logId-"+_index).val();
    //     var data = {logId:logId};
    //     $.ajax({
    //         url:"logshow",
    //         type:"post",
    //         data:data,
    //         dataType:"json",
    //         success:function (resp) {
    //             var $tr=  '<div class="panel-heading"><div class="col-lg-12"><span class="col-lg-8"><a href="/crainnogao/detail?logId='+resp.logId+'"><blockquote>'+resp.logTitle+'</blockquote></a></span><span class="col-lg-4">'+resp.logCreatedStr+'</span></div></div>'+
    //                     '<div  class="contentshow"></div>'+
    //                     '<div class="panel-footer"><span>关键字：'+resp.logSummary+'</span></div>'+
    //                     '<input type="hidden" class="logContent" value="'+resp.logContent+'"/>';
    //             document.getElementById("logshow").innerHTML=$tr;
    //             $("#firstshow").hide();
    //             // oLogTitle[_index].css('color','#2a6496');
    //             var contentshow = $('.logContent').val();
    //             $('.contentshow').html(marked(contentshow));
    //
    //         },
    //         error:function () {
    //             alert("失败");
    //         }
    //     })
    // });

    $(document).on('click','#crainnogao_ad',function () {
        window.location.href="/crainnogao/admin/crainnogao_ad";
    });

    if ($('#detaillogcontentfir').val()!=undefined){
        var detailcontentshow = $('#detaillogcontentfir').val();
        $('#detaillog').html(marked(detailcontentshow));
    }
    for (var i=1;i<=5;i++){
        var contentshow = $('#logcontentfir-'+i).val();
        $('#firstlog-'+i).html(marked(contentshow));
    }

    //分页js
    var pageNum = $('#pageNum').val();
    var totalPage = $('#totalPage').val();
    if(pageNum==1){
        $('.prevPage').addClass('disabled');
        $('.prevPage').removeAttr("href");
        document.getElementById('prevPage').style.backgroundColor="#f4f5ef";
    }
    if(pageNum==totalPage){
        $('.nextPage').addClass('disabled');
        $('.nextPage').removeAttr("href");
        document.getElementById('nextPage').style.backgroundColor="#f4f5ef";
    }
    for (var i =1;i<=totalPage;i++){
       var number = $("#number-"+i).val();
        if (number==pageNum){
            $('.tcdNumber-'+i).addClass('disabled');
            $('.tcdNumber-'+i).removeAttr("href");
            document.getElementById('tcdNumber-'+i).style.backgroundColor="#f4f5ef";
        }
    }
});

