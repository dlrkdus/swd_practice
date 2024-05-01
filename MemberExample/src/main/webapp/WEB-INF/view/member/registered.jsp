<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<h1>${regReq.name}님의 오디션 지원이 접수되었습니다.</h1><br/><br/>
접수 내용 <br/><br/>
<ul>
	<li>ID: ${memberId}</li>
	<li>이름: ${regReq.name}</li>
	<li>주소: ${regReq.address.address1}, ${regReq.address.address2} (우편번호: ${regReq.address.zipcode})</li>
	<li>이메일: ${regReq.email}</li>
	<li>지원 분야: ${regReq.performerType}</li>
	<li>공연/연기명: ${regReq.performTitle}</li>
	<li>공연 시간: ${regReq.performTime}</li>
	<li>요청 사항: ${regReq.requestedTerm}</li>
	<li>온라인 공연 희망: ${regReq.onlinePerform ? '예' : '아니오'}</li>
</ul>
접수 일시: ${reqTime}<br/></br>

공연 일정: <br/>
<table style="width:70%; border-collapse: collapse;">
	<tr>
		<th style="border: 1px solid black; padding: 8px;">순번</th>
		<th style="border: 1px solid black; padding: 8px;">공연자</th>
		<th style="border: 1px solid black; padding: 8px;">종류</th>
		<th style="border: 1px solid black; padding: 8px;">곡명</th>
		<th style="border: 1px solid black; padding: 8px;">공연시간</th>
		<th style="border: 1px solid black; padding: 8px;">요청 사항</th>
	</tr>
	<c:forEach var="member" items="${members}" varStatus="status">
		<tr>
			<td style="border: 1px solid black; padding: 8px;">${status.count}</td>
			<td style="border: 1px solid black; padding: 8px;">${member.name}</td>
			<td style="border: 1px solid black; padding: 8px;">${member.performerType}</td>
			<td style="border: 1px solid black; padding: 8px;">${member.performTitle}</td>
			<td style="border: 1px solid black; padding: 8px;">${member.performTime}</td>
			<td style="border: 1px solid black; padding: 8px;">${member.requestedTerm}</td>
		</tr>
	</c:forEach>
</table>

<p><a href="<c:url value='/index' />">Go to index</a></p>
</body>
</html>