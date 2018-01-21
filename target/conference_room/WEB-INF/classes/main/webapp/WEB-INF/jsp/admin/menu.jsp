<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/admin/showRoom">会议室信息管理<span class="glyphicon glyphicon-pencil pull-right"/></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showReservation">预约审核管理<span class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showRecord">预约记录查询<span class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/userRegister">用户注册管理<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
        <%--<li><a href="${pageContext.request.contextPath}/admin/passwordReset">修改密码<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>--%>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <%--<li class="disabled"><a href="##">Responsive</a></li>--%>
    </ul>
</div>