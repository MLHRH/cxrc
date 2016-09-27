<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IUGS Communication Work IMS</title>
<link href="<%=ctx %>/static/bootstrap/2.1.1/css/bootstrap.min.css" rel="stylesheet" media="screen">

<style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 5px;
        background-color: #fff;
      }

      .form-signin {
        max-width: 340px;
        padding: 10px 39px 10px;
        margin: 0 auto 10px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 5px;
        margin-top: 1px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>
<body >
<script src="http://code.jquery.com/jquery.js"></script>
<script src="<%=ctx %>/static/bootstrap/2.1.1/js/bootstrap.min.js"></script>
    <div class="navbar navbar-inverse navbar-fixed-top ">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="brand" href="http://www.iugs.org"><i class="icon-home icon-white"></i>IUGS</a>
          <ul class="nav">
              <li><a href="mailto:iugs.beijing@gmail.com?subject=Feedback for MIS"><i class="icon-envelope icon-white"></i>Contact Secretariat</a></li>
            </ul>
        </div>
      </div>
    </div>      
<div class="row-fluid">
<table id="__01" width="800" height="600" border="0" cellpadding="0" cellspacing="0" >
	<tr width="800" height="200">
		<td width="360">
			<img src="images/login_01.gif" width="358" height="188" alt=""></td>
		<td width="440">
      <form class="form-signin" action="<%=ctx%>/login" method="post">
        <h3 class="form-signin-heading">Please sign in</h3>
<label class="control-label" for="filename">Email address</label>
        <input type="text" name="email" class="input-block-level" placeholder="Email address">
<a href="#" class="btn btn-warning">This account does not exist!</a>
<label class="control-label" for="filename">Password</label>
        <input type="password" name="login_pwd" class="input-block-level" placeholder="Password">
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
        <a href="#" class="btn btn-link">Forgot Your Password?</a>
      </form>

</td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="images/login.gif" width="800" height="276" alt=""></td>
	</tr>
	<tr>
		<td colspan="2"  align="center" valign="middle">
			<a href="#" class="btn btn-link"><p>&copy;  2013 International Union of Geological Sciences - ALL RIGHTS RESERVED WORLDWIDE.</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>