<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>tabPanel</title>
</head>
<body>

	<div class="pageContent">
		<!-- tabs开始 -->
		<div class="tabs" currentIndex="0" eventType="click">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>标题1</span></a></li>
						<li><a href="javascript:;"><span>标题2</span></a></li>
						<li><a href="/SSHDemo/student/redirect.action" target="ajax" rel="box"><span>标题3</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 100%">
				<div style="height: 500px;">
					内容1
				</div>
				<div>内容2</div>
				<div id="box"></div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
		<!-- tabs结束 -->
	</div>

</body>
</html>