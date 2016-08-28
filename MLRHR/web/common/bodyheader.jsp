<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<c:if test="${empty sessionScope.loginuser.name}">
	<c:redirect url="login"></c:redirect>
</c:if>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="nav-collapse collapse" style="height: auto !important;">
				<a href="javascript:void(0)" class="brand">国土资源科技创新人才工程管理信息系统</a>
				<p class="navbar-text pull-right">
					<a href="${ctx}/userBaseInfor" class="active">
						<i class="icon-user"></i> ${sessionScope.loginuser.name}
					</a>
					&nbsp;
					<a href="${ctx}/changepassword">
						<i class="icon-wrench"></i> 修改密码
					</a>
					<a href="${ctx}/j_spring_security_logout">
						<i class="icon-off"></i> 退 出
					</a>
				</p>
				<ul id="bodyHeaderMenuId" class="nav nav-pills">
					<li>
						<a href="${ctx}/index">首页</a>
					</li>
					<security:authorize ifAnyGranted="ROLE_USER">
						<li>
							<a href="${ctx}/userBaseInfor">我的档案</a>
						</li>
						<li>
							<a href="${ctx}/zhichengApplylist">人才申报</a>
						</li>
					</security:authorize>

					<security:authorize ifAnyGranted="ROLE_HR">
						<li>
							<a href="${ctx}/bodylist">人才审核</a>
						</li>
					</security:authorize>

					<security:authorize ifAnyGranted="ROLE_HR">
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
								系统管理<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<security:authorize ifAnyGranted="ROLE_PROFESSOR">
									<li>
										<a href="${ctx}/newslist">公告管理</a>
									</li>
									<li>
										<a href="${ctx}/calendarEdit?id=1">申请设置</a>
									</li>
								</security:authorize>
								<li>
									<a href="${ctx}/bodyManger">分组管理</a>
								</li>

							</ul>
						</li>
					</security:authorize>

				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>