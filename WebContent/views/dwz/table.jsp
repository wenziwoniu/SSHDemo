<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table-practice</title>
<script type="text/javascript">
		function query() {
			$("#queryForm").submit();
		};
	</script>

</head>
<body>

	<form id="pagerForm" method="post" action="/SSHDemo/student/redirect.action">
		<input type="hidden" name="status"   value="${param.status}">
		<input type="hidden" name="keywords" value="${param.keywords}" />
		<input type="hidden" name="pageNum" value="1" />
		<input type="hidden" name="numPerPage" value="5" />
		<input type="hidden" name="studentName" value="${query.studentName}" />
		
		<input type="hidden" name="orderField" 		value="${param.orderField}" />
		<input type="hidden" name="orderDirection"  value="${param.orderDirection}" />
	</form>
		
	<div class="pageHeader">
		<form id="queryForm" onsubmit="return navTabSearch(this);" action="/SSHDemo/student/redirect.action" method="post">
		<div class="searchBar">
			<label>真实姓名:</label><input type="text" id="studentName" name="studentName" value="${query.studentName}" />
		</div>
		</form>
	</div>

	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a onclick="query()"><span>查询</span></a></li>
				<li class="line"></li>
				<li><a href="peopleAdd.jsp" target="dialog" rel="peopleAdd"><span>新增</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="150">
			<thead>
				<tr>
					<th width="80">序号</th>
					<th width="120">名字</th>
					<th width="120">真实姓名</th>
					<th width="120">性别</th>
					<th>phone</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${pages.list}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>a</td>
						<td>b</td>
						<td>${p.studentName}</td>
						<td>${p.optlock}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="5" <c:if test="${pages.numPerPage == 5}">selected="selected"</c:if>>5</option>
					<option value="20" <c:if test="${pages.numPerPage == 20}">selected="selected"</c:if>>20</option>
					<option value="50" <c:if test="${pages.numPerPage == 50}">selected="selected"</c:if>>50</option>
				</select>
				<span>条，共${pages.totalCount}条</span>
			</div>
			
			<div class="pagination" targetType="navTab" totalCount="${pages.totalCount}" numPerPage="${pages.numPerPage}" pageNumShown="10" currentPage="${pages.pageNum}"></div>
		</div>
		
	</div>
	
</body>
</html>