<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>国土资源科技创新人才工程管理信息系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
      body {
        padding-top: 70px;
        padding-bottom: 10px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>

  </head>
<%@ include file="/common/common.jsp" %>
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" /> 
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" ></script>
<%@ include file="/common/jquery.noty.jsp"%>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script>
	$(document).ready(function() {
		/* $.validator.addMethod('require-one', function(value) {
	        return $('.require-one:checked').size() > 0;
	}, 'Please select the type of email receivers'); */
		 $("#submit").click(function() {
			$("#ExpensesAllocedit").validate({
     	    highlight: function(label) {
     	    	$(label).closest('.control-group').addClass('error');
     	    },
     	    unhighlight: function(label) {
     	    	$(label).closest('.control-group').removeClass('error');
     	    },
     	    errorElement: 'span',
     	    submitHandler:function(){
     	   		var tovalue = "";
     	   		tovalue=$.map($('.require-one:checked'), function(e, i) {
     	   			return $(e).attr("value");}).join(",");
     	       if(tovalue.length==0)
     	       {
     	    	  generatenoty('center','Please select the type of email receivers','error');
     	    	  return;
     	       }else{
	     		arrData = new Array();
	     		arrData.push({ "name": "to", "value":  tovalue });
	     		arrData.push({ "name": "subject", "value": $("#subject").val() });
	     		arrData.push({ "name": "others", "value": $("#others").val() });
	     		arrData.push({ "name": "content", "value": $("#content").val() });
	  	    	$.ajax({
	                  "dataType": 'json', 
	                  "type":"post",
	                  "url": "${ctx}/sendmm", 
	                  "data": arrData, 
	                  "success": function(rst){
	                  	if(rst.result==1){
	                  		noty({
	                  	  		text: 'Send email successfully. Now going back to the list.',
	                  	  		type: 'success',
	                  	        dismissQueue: false,
	                  	        closeWith: ['click','button'],
	                  	        timeout: 3000,
	                  	  		layout: 'top',
	                  	  		callback:{afterClose:function(){
	                  	  			location.href='${ctx}/emailsend';
	                  	  		}},
	                  	  		theme: 'defaultTheme'
	                  	  	});
	                  	}
	                  	else{
	                  		generatenoty('center',rst.msg,'error');
	                  	}
	                  }
	              });
     	    	   }
   	   }
  	  });
  });
});
</script>
  <body>
  <%@ include file="/common/bodyheader.jsp" %>
  <div class="container-fluid">
    	 <div class="row-fluid">
  <div class="row-fluid">

  <div class="page-header">  
<h2>Mass-Mailing</h2>
          </div>  <div class="span9">
    <form id="ExpensesAllocedit" class="form-horizontal" method="post" action="${ctx}/sendmm">
    <div class="control-group">
	    <label class="control-label" for="to">To</label>
	    <div class="controls">
	      <label class="checkbox inline">
    <input type="checkbox" id="inlineCheckbox1" name="to" value="adh" class="require-one"> Adhering Organizations
    </label>
    <label class="checkbox inline">
    <input type="checkbox" id="inlineCheckbox2" name="to" value="aff" class="require-one"> Affiliated Organizations
    </label>
    <label class="checkbox inline">
    <input type="checkbox" id="inlineCheckbox3" name="to" value="act" class="require-one"> Activities
    </label>
	  	</div>
	</div>
	 <div class="control-group">
	    <label class="control-label" for="to">Cc</label>
	     <div class="controls">
	       <input type="text" id="others" name="others"  class="input-xxlarge" >
	  	</div>
	</div>
	
	 <div class="control-group">
	    <label class="control-label" for="cpi">Subject</label>
	    <div class="controls">
	       <input type="text" id="subject" name="subject"  class="input-xxlarge required" >
	  	</div>
	</div>
  <div class="control-group">
	    <label class="control-label" for="content">Content</label>
	    <div class="controls">
	      <textarea rows="14" id="content" class="input-xxlarge form-control required" name="content" ></textarea>
	     
	  	</div>
	</div>
	<div class="control-group">
	    <label class="control-label" for="content">Attachment</label>
	    <div class="controls">
	      <button class="btn btn-primary" id="uploadinwindow">Upload
								Documents</button>     
	  	</div>
	</div>
   <div class="control-group">
	    <div class="controls">
	       <input id="submit" type="submit" class="btn btn-primary" value="Send">
	       <button type="button"  class="btn " onClick="javascript:history.back(-1);">Back</button>
	    </div>
  	</div>
	</form>
	 </div> 
       </div> 
      </div> 
   <hr>
     <%@ include file="/common/footer.jsp" %>

    </div><!--/.fluid-container-->
  </body>
</html>
