<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td>textarea {
	width:100%;
	height:100%;
	resize:none;
	box-sizing:border-box;
	}
	button {
	width:100%;
	height:30px
	}





</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>

	<h1 align="center">게시글 상세 조회</h1>
	
		<tr>
           	<td>${b.boardNo}></td>
           	<td>${b.boardTitle}</td>
           	<td>${b.boardWriter}</td>
           	<td>${b.count}</td>
			<td>${b.createDate }</td>       
         </tr>
         
         <table align="center" border="1">
         	<tr>
         		<td width="100">댓글작성</td>
         		<td width="400"><textarea></textarea></td>
         		<td width="100"><button>등록</button></td>
         	</tr>
         	<tr>
         		<td colspan="3"> <b>${l.replyNo}</b> </td>
         	</tr>
         	
         	<tr>
         	<c:forEach var="l" items="${list}">
         		<td width="100"><b>${l.replyWriter }</b></td>
         		<td width="100"><b>${l.replyContent}</b></td>
         		<td width="100"><b>${l.createDate }</b></td>
         		
         	</c:forEach>          	
         	</tr>      
         </table>
</body>
</html>