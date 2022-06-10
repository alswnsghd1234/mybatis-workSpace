<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#list-area {
			border : 1px solid white;
			text-align : center;
		}
		
		.outer a {
			color : white;
			text-decoration : none;
		}
	
	</style>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>

    <div class="outer" align="center">
        <h1 align="center">게시판</h1>

        <table id="list-area">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400">제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody> 
               <c:forEach var="b" items="${list}">
	                <tr>
	                	<td>${b.boardNo}</td>
	                	<td>${b.boardTitle }</td>
	                	<td>${b.boardWriter }</td>
	                	<td>${b.count }</td>
						<td>${b.createDate }</td>                
	                </tr>
				</c:forEach>
            </tbody>
        </table>
    	
    	<br><br>
    	
    	<div id="paging-area">
    		<c:if test="${pi.currentPage ne 1 }">
    			<button onclick="location.href='list.bo?cPage=${pi.currentPage-1}'">[이전]</button>
    		</c:if>
            
            <c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}" step="1">
	 			<c:choose>
	 				<c:when test="${ i ne pi.currentPage }">
	 					<button onclick="location.href='list.bo?cPage=${i}'">[${i}]</button>
	 				</c:when>
	 				<c:otherwise>
				  	<button disabled>[${i}]</button>         
	 				</c:otherwise>
	            </c:choose>
            </c:forEach>
            <c:if test="${ pi.currentPage ne pi.maxPage }">
            	<button onclick="location.href='list.bo?cPage=${pi.currentPage+1}'">[다음]</button>
            </c:if>
    	</div>
    
    </div>
</body>
</html>