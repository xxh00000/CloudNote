tempf;
tempz;

function loadNote(){
//	var BookId1=$.Cookie('data');
    $("#book_list li a").removeClass("checked"); 
    $("#notebookId  h3").html("全部笔记");
	$("#notelist").empty();
    var BookId1=$(this).data('bookId');
    $(this).find("a").addClass("checked");
  tempf=BookId1;
	$.ajax({
		   url:"http://localhost:8080/SDAU_CloudNote/note/loadNote.do",
		   type:"post",
		   dataType:"json",
		   data:{"noteBookId":BookId1},
		   success:function(result){
			   if(result.status==0)
				   {
				  // alert("点击成功");
				   //alert(BookId1);
				   var notes=result.data;
				   for( var i=0;i<notes.length;i++)
					   {
					   var notename=notes[i].cn_note_title;
					   var noteId=notes[i].cn_note_id;
                      

					   var n_li='<li class="online">';
						n_li+="<a >";
						n_li+='	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+notename+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"  ><i class="fa fa-chevron-down"></i></button>';
						n_li+='	</a>';
						n_li+='	<div class="note_menu" tabindex="-1">';
						n_li+='	<dl>';
						n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
						n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
						n_li+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
						n_li+='	</dl>';
						n_li+='	</div>';
						n_li+='	</li>'
							var $n_li=$(n_li);
						$n_li.data("noteId",noteId);
						$("#notelist").append($n_li);
					   }
				   }
		   }
		
	})
	
}

function showAddNoteWindow(){
	   $(".opacity_bg").show();//显示灰色背景
    $("#can").load("alert/alert_note.html");//弹出新建笔记本窗口
}

function closeAddNoteWindow(){
	$("#can").empty();
	$(".opacity_bg").hide();
}

function addNote()
{
	//alert("123123");
    var noteName=$("#input_note").val().trim();
	alert(noteName);
    var bookId=tempf;
    alert(bookId);
    $.ajax({
    	url:"http://localhost:8080/SDAU_CloudNote/note/addNote.do",
    	type:"post",
    	data:{"noteName":noteName,"bookId":bookId,"userId":userId},
    	dataType:"json",
    	success:function(result){
    		//alert("333");
    		if(noteName!=null)
    			{
    			alert("笔记添加成功");
    			closeAddNoteWindow();
    			}
    	}
    	
    	
    })



}
function editNote(){
    //给当前被选中的笔记li添加选中的样式
    $("#notelist li a").removeClass("checked");
    $(this).find("a").addClass("checked");
            //alert("1111");
            //获取数据,笔记的id
         var noteId=$(this).data("noteId");
         tempz=noteId;
        // alert(noteId);
         //发送ajax请求
         $.ajax({
                url:"http://localhost:8080/SDAU_CloudNote/note/findNote.do",
                type:"post",
                data:{"noteId":noteId},
                dataType:"json",
                success:function(result){
             //     alert(result.msg);
                  if(result.status==0){
                   var note=result.data;
                   var note_title=note.cn_note_title;
                   var note_body=note.cn_note_body;
                //   alert(note_title);
                   $("#input_note_title").val(note_title);
                   //给文本框设置内容
                   um.setContent(note_body);
                   }
                   
                    }
                
             });
           
	
	
	
}



function saveNote()
{
	//alert("保存笔记按钮");
    var title=$("#input_note_title").val();
    var body=um.getContent();
    var noteId=tempz;

    //alert(title);
    //alert(body);
   // alert(noteId);
    $.ajax({
    	url:"http://localhost:8080/SDAU_CloudNote/note/saveChangeNote.do",
    	type:"post",
    	data:{"noteId":noteId,"noteTitle":title,"noteBody":body},
    	dataType:"json",
    	success:function(result){
    		alert("保存界面");
    		if(result.status==0)
    			{
    			alert("保存成功");
    			//标题修改
    			var now_title=$("#notelist li a.checked").text().trim();
    			//alert(now_title);
    			//alert(title);
    			if(now_title!=title)
    				{
    			  
    				var a='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+title+
    				'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down" ><i class="fa fa-chevron-down"></i></button>';
    				$("#notelist li a.checked").html(a);
    				}
    			}
    		
    		
    	}

    })
}
function displayall(){
	//alert("111222");
	   //var ax=document.getElementsByClassName("note_menu");
	   //ax[0].style.display="block";
	//隐藏其他的笔记菜单
	$("#notelist .note_menu").hide();
	
	   //选中笔记
	 //  var li=$(this).parents("li") ;
	   //查找笔记下面的菜单
	  // var menu=li.find(".note_menu");
	  //显示菜单
	  // menu.show();
	
	
	   $(this).parent().next().show();
        //离开笔记li的时候，菜单应该收起
	 

}
function delNote1()
{
//alert("2333");	
	  $(".opacity_bg").show();//显示灰色背景
	    $("#can").load("alert/alert_delete_note.html");//弹出新建笔记本窗口
}
function closeDelWindow()
{

	
	$("#can").empty();
	$(".opacity_bg").hide();

}
function delNote2()
{
//alert("3344");	
var noteId=tempz;
alert(noteId);
//另外一种获得ID的方式
var li=$("#notelist a.checked").parents("li");
//var noteId=li.data("noteId");
$.ajax({
       url:"http://localhost:8080/SDAU_CloudNote/note/deleteNote.do",
       type:"post",
       data:{"noteId":noteId},
       dataType:"json",
       success:function(result)
       {
    	   //alert("可以进行删除");
    	  
    	   li.remove();
    	   um.setContent("");
    	   $("#input_note_title").val("");
     	   alert(result.msg);
    	   closeDelWindow();
       }

})

}
function moveNote1()
{
//alert("6666");	
	  $(".opacity_bg").show();//显示灰色背景
	    $("#can").load("alert/alert_move.html");//弹出移动笔记本窗口
   //     $("#moveSelect").append("<option value='777' >"+'555'+"</option>");         

}

function moveSelect2(){
	//alert("112233");
	//var value=$("#moveSelect option:selected").text();
	//alert(value)
	var bookId=$("#moveSelect option:selected").val();
  //	alert(bookId);
	var noteId=tempz;
//	alert(noteId);
	var li=$("#notelist a.checked").parents("li");
	$.ajax({
		url:"http://localhost:8080/SDAU_CloudNote/note/moveNote.do",
		type:"post",
		data:{"noteId":noteId,"bookId":bookId},
		dataType:"json",
		success:function(result){
	//	  alert("移动成功");	
		  alert(result.msg);
		  li.remove();
   	   um.setContent("");
		  closeDelWindow();
		}
	});
}
function shareNote()
{
	var noteId=tempz;
	//$(".opacity_bg").show();//显示灰色背景
    //$("#can").load("alert/alert_move.html");//弹出分享笔记本窗口
	
	$.ajax({
		url:"http://localhost:8080/SDAU_CloudNote/sharenote/addShareNote.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result!=null)
				{
				alert(result.msg);
				
				}
		}
		
	});
	
}
function searchNote(){
	//alert("查找笔记");
	var temp=$("#search_note").val();
	//alert(temp);
	$("#notebookId  h3").html("已经分享的笔记");
	$("#notelist").empty();
	$.ajax({
		url:"http://localhost:8080/SDAU_CloudNote/sharenote/searchShareNote.do",
		type:"post",
		data:{"words":temp},
		dataType:"json",
		success:function(result){
			if(result!=null)
				{
				 var notes=result.data;
				   for( var i=0;i<notes.length;i++)
					   {
					   var notename=notes[i].cn_share_title;
					   var noteId=notes[i].cn_note_id;
                     var n_li='<li class="online">';
						n_li+="<a >";
						n_li+='	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+notename+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"  ><i class="fa fa-chevron-down"></i></button>';
						n_li+='	</a>';
						n_li+='	<div class="note_menu" tabindex="-1">';
						n_li+='	<dl>';
						n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
						n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
						n_li+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
						n_li+='	</dl>';
						n_li+='	</div>';
						n_li+='	</li>'
							var $n_li=$(n_li);
						$n_li.data("noteId",noteId);
						$("#notelist").append($n_li);}
				}
		}
	})
}

function rollBackNote()
{
	$("#notebookId  h3").html("回收站笔记");
$("#notelist").empty();
$.ajax({
    url:"http://localhost:8080/SDAU_CloudNote/note/rollBackNote.do",
    type:"post",
    data:{"userId":userId},
    dataType:"json",
    success:function(result){
    	if(result!=null)
    		{
    		alert("加载回收站成功");
    		 var notes=result.data;
			   for( var i=0;i<notes.length;i++)
				   {
				   var notename=notes[i].cn_note_title;
				   var noteId=notes[i].cn_note_id;
               var n_li='<li class="online">';
					n_li+="<a >";
					n_li+='	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+notename+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"  ><i class="fa fa-chevron-down"></i></button>';
					n_li+='	</a>';
					n_li+='	<div class="note_menu" tabindex="-1">';
					n_li+='	<dl>';
					n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					n_li+='	<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					n_li+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					n_li+='	</dl>';
					n_li+='	</div>';
					n_li+='	</li>'
						var $n_li=$(n_li);
					$n_li.data("noteId",noteId);
					$("#notelist").append($n_li);}
    		}
    	
    	
    }
	
	


})





}

