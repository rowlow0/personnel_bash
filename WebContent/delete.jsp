<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 퇴사처리 화면</title>
</head>
<body>
<h1>인사관리 퇴사처리 화면</h1>
<hr>
<fieldset><legend>인사관리 사원정보 변경</legend>
<form method="get" action="DeleteAction">
성명 : <input type="text" name="name"><br>
사원번호 : <input type="text" name="id"><br>
<input type="submit" value="삭제"/><input type="button" value="취소" onclick="location.href='index.jsp'"/>
</form>
</fieldset>
</body>
</html>