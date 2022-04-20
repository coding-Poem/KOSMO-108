<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHECKBOX TAG</title>
<script type="text/javascript">


</script>




<style type="text/css">

	table {
		border: 1px solid blue;
		width: 300px;
		height: 50px;
		margin: 5px auto;
		text-align: center;
	}
	
	h3,hr {
		text-align: center;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h3>CHECKBOX TAG</h3>
		<hr>
		<form name="check_form_1" id="check_form_1">
			<table>
				<thead>
					<tr>
						<td class="tt">
							<input type="checkbox" class="chkAll" name="chkAll" id="chkAll">
						</td>
						<td class="tt">순번</td>
						<td class="tT">이름</td>
					</tr>
				</thead>
					<%
						for(int i=0; i<5; i++){
					%>
				<tbody>
					<tr>
						<td class="tt">
							<input type="checkbox" class="mnumCheck" name="mnumCheck" value=<%= i %> onclick="checkOnly(this)">
						</td>
					</tr>
				</tbody>		
			</table>
		</form>
	</div>
</body>
</html>