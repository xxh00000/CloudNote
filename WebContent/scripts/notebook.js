
//加载笔记本列表
function loadNoteBooks(){
	
	  $.ajax({
          url:"http://localhost:8080/SDAU_CloudNote/notebook/loadbooks.do",
          type:"post",
          dataType:"json",
          data:{"userId":userId},
          success:function(result){
                    if(result.status==0){//声明后台加载笔记本成功
                        //alert("现在进入到了这个方法");
                        var notebooks=result.data;

                        for(var  i =0;i<notebooks.length;i++)
                            {
                              var bookname= notebooks[i].cn_notebook_name;
                          //    alert(bookname);
                              var bookId=notebooks[i].cn_notebook_id;//获取笔记本Id
                           //   alert(bookId);      
                           
                              
                              
                              var s_li='<li class="online">';
								s_li+="<a>";
								s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
								s_li+='</i>'+bookname+'</a></li>'
								//拼接后的字符串是DOM格式，需要转换为jQuery格式
								var $s_li=$(s_li);
								//给li添加上bookId
								$s_li.data("bookId",bookId);
								//将字符串$s_li添加到ul列表中
							//	$.Cookie('data',bookId)
								$("#book_list").append($s_li);
							 $s_li.click(loadNote);
                              
                            }
                        }
              
              }
              

    });
}
//弹出笔记本的框
function showAddBookWindow(){
	   $(".opacity_bg").show();//显示灰色背景
       $("#can").load("alert/alert_notebook.html");//弹出新建笔记本窗口
}
//关闭添加笔记本的框
function closeAddBookWindow(){
    $("#can").empty();
    $(".opacity_bg").hide();//隐藏CSS样式
}

function addNoteBook(){

        //获取添加笔记本框的笔记本名
         var bookName=$("#input_notebook").val().trim();
          //alert(bookName);
         //TODO检查bookName是否为空
         $.ajax({
             url:"http://localhost:8080/SDAU_CloudNote/notebook/addNoteBook.do",
             type:"post", 
             data:{"bookName":bookName,"userId":userId},
             dataType:"json",
             success:function(result){
                 if(bookName!=null)
                 {     alert("笔记本添加成功");
                 var bookId=result.data;
                 var s_li='<li class="online">';
					s_li+="<a>";
					s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
					s_li+='</i>'+bookName+'</a></li>'
					var $s_li=$(s_li);
					$s_li.data("bookId",bookId);
					$("#book_list").prepend($s_li);
					closeAddBookWindow();
                 }
                 }

                 })
	
}
var temp=1;
function moveSelect()
{

$.ajax({
    url:"http://localhost:8080/SDAU_CloudNote/notebook/loadbooks.do",
    type:"post",
    dataType:"json",
    data:{"userId":userId},
    success:function(result){
              if(temp==1){//声明后台加载笔记本成功
                  //alert("现在进入到了这个方法");
                  var notebooks=result.data;
                for(var  i =0;i<notebooks.length;i++)
                      {
                        var bookname= notebooks[i].cn_notebook_name;
                      var bookId=notebooks[i].cn_notebook_id;//获取笔记本Id
                     $("#moveSelect").append("<option value='"+bookId+"'>"+bookname+"</option>");      
                    }
                  temp=2;
                  }
        
        }
        

});




}