$(function () {
    $(document).on('click','#crainnogao_ad',function () {
        window.location.href="/crainnogao/admin/crainnogao_ad";
    });

    if ($('#detaillogcontentfir').val()!=undefined){
        var detailcontentshow = $('#detaillogcontentfir').val();
        $('#detaillog').html(marked(detailcontentshow));
    }
    var count = $('#count').val();
    for (var i=1;i<=count;i++){
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
    var current ="";
    for (var i =1;i<=totalPage;i++){
       var number = $("#number-"+i).val();
        if (number==pageNum){
            current = i;
            $('.tcdNumber-'+i).addClass('disabled current');
            $('.tcdNumber-'+i).removeAttr("href");
            document.getElementById('tcdNumber-'+i).style.backgroundColor="#f4f5ef";
        }
    }
    $(document).on('click','.prevPage',function () {
        if (current>1){
            location.href='/crainnogao/?pageNum='+ --current;
        }
    });
    $(document).on('click','.nextPage',function () {
        if (current<totalPage){
            location.href='/crainnogao/?pageNum='+ ++current;
        }
    })
});

