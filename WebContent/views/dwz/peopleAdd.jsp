<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table-practice</title>
<script type="text/javascript">
</script>

</head>
<body>
	
	<div class="pageContent">
		<form method="post" action="/SSHDemo/student/saveStudent.action" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
			<div class="pageFormContent" layoutH="50">
				<p>
					<label>姓名：</label>
					<input type="text" name="peopleName" />
				</p>
				
				<p>
					<label>乐观锁：</label>
					<input type="text" name="optlock" />
				</p>
				
			</div>
			
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">保存</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		
		</form>
	
	</div>
	
	
</body>
</html>