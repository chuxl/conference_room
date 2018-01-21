<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>预约会议室</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currDate = dateFormat.format(new Date());
    List dateList=new ArrayList();
    for (int i = 0; i < 16; i++) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(currDate));

        calendar.add(Calendar.DAY_OF_MONTH, i);

        String nextDay= dateFormat.format(calendar.getTime());
        dateList.add(nextDay);
    }
    request.setAttribute("dateList",dateList);
%>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">添加会议室预约</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form"
                          action="${pageContext.request.contextPath}/ordinary/reserveRoom" id="editfrom" method="post">

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">会议室名称</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="inputPassword3" name="name">
                                    <c:forEach items="${nameList}" var="item">
                                        <option value="${item.name}">${item.name}</option>
                                    </c:forEach>
                                </select>
                                <%--<input type="text" class="form-control" id="inputPassword3" name="name" placeholder="请输入会议室名称">--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">借用人</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputPassword3-1" name="user"
                                       value=<shiro:principal/>>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="mobile">联系电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3-2" name="mobile"
                                       placeholder="请输入借用人联系电话">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="date">借用日期</label>
                            <div  class="col-sm-10">
                                <%--<input type="date" value="2018-01-01" name="date" />--%>
                                <select class="form-control" name="date">
                                    <option>${dateList[0]}</option>
                                    <option >${dateList[1]}</option>
                                    <option >${dateList[2]}</option>
                                    <option >${dateList[3]}</option>
                                    <option >${dateList[4]}</option>
                                    <option >${dateList[5]}</option>
                                    <option >${dateList[6]}</option>
                                    <option >${dateList[7]}</option>
                                    <option >${dateList[8]}</option>
                                    <option >${dateList[9]}</option>
                                    <option >${dateList[10]}</option>
                                    <option >${dateList[11]}</option>
                                    <option >${dateList[12]}</option>
                                    <option >${dateList[13]}</option>
                                    <option >${dateList[14]}</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="beginTime">开始时间</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="beginTime">
                                    <option >9:00:00</option>
                                    <option >9:30:00</option>
                                    <option >10:00:00</option>
                                    <option >10:30:00</option>
                                    <option >11:00:00</option>
                                    <option >11:30:00</option>
                                    <option >12:00:00</option>
                                    <option >12:30:00</option>
                                    <option >13:00:00</option>
                                    <option >13:30:00</option>
                                    <option >14:00:00</option>
                                    <option >14:30:00</option>
                                    <option >15:00:00</option>
                                    <option >15:30:00</option>
                                    <option >16:00:00</option>
                                    <option >16:30:00</option>
                                    <option >17:00:00</option>
                                    <option >17:30:00</option>
                                    <option >18:00:00</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="endTime">结束时间</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="endTime">
                                    <option >9:00:00</option>
                                    <option >9:30:00</option>
                                    <option >10:00:00</option>
                                    <option >10:30:00</option>
                                    <option >11:00:00</option>
                                    <option >11:30:00</option>
                                    <option >12:00:00</option>
                                    <option >12:30:00</option>
                                    <option >13:00:00</option>
                                    <option >13:30:00</option>
                                    <option >14:00:00</option>
                                    <option >14:30:00</option>
                                    <option >15:00:00</option>
                                    <option >15:30:00</option>
                                    <option >16:00:00</option>
                                    <option >16:30:00</option>
                                    <option >17:00:00</option>
                                    <option >17:30:00</option>
                                    <option >18:00:00</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    <%--设置菜单中--%>
    $("#nav li:nth-child(3)").addClass("active")

    <c:if test="${pagingVO != null}">
    if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
        $(".pagination li:last-child").addClass("disabled")
    }
    ;

    if (${pagingVO.curentPageNo} == ${1}) {
        $(".pagination li:nth-child(1)").addClass("disabled")
    }
    ;
    </c:if>

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });
</script>
</html>