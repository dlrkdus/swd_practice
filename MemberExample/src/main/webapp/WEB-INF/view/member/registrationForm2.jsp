<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>SpringIdol 오디션 지원</title>
</head>
<body>
<form:form modelAttribute="regReq" method="post">

	<label for="name">이름</label>:
	<form:input path="name" />
	<form:errors path="name" />
	<br/>

	<label for="password">비밀번호</label>:
	<form:password path="password" showPassword="true" />
	<form:errors path="password" />
	<br/>

	<label for="confirmPassword">비밀번호 확인</label>:
	<form:password path="confirmPassword" showPassword="true"/>
	<form:errors path="confirmPassword" />
	<form:errors path="samePasswordConfirmPassword" />
	<br/>

	<label for="phone">휴대폰 번호</label>:
	<form:input path="phone" placeholder="예: 01x-1234-5678"/>
	<form:errors path="phone"/>
	<br/>

	<label for="email">이메일</label>:
	<form:input path="email" placeholder="예: abc@gmail.com"/>
	<form:errors path="email" />
	<br/>

	<!-- 주소 필드 -->
	<label for="address.address1">주소: street </label>
	<form:input path="address.address1" />
	<form:errors path="address.address1"/>

	<label for="address.address2">city </label>
	<form:input path="address.address2" />
	<form:errors path="address.address2" />
	<label for="address.zipcode">zipcode </label>
	<form:input path="address.zipcode" />
	<form:errors path="address.zipcode" />
	<br/>

	<!--지원 분야: 보컬, 랩, 댄스, 연기, 기타 중 선택 (default: 보컬)
✓ drop-down menu(<select />)나 radio button(<input type=”radio” />) 이용-->
	<label for="performerType">지원 분야:</label>
	<form:select path="performerType">
		<form:option value="보컬">보컬</form:option>
		<form:option value="랩">랩</form:option>
		<form:option value="댄스">댄스</form:option>
		<form:option value="연기">연기</form:option>
		<form:option value="기타">기타</form:option>
	</form:select>
	<form:errors path="performerType"/>

	<br/>

	<label for="performTitle">공연/연기명</label>:
	<form:input path="performTitle" />
	<form:errors path="performTitle"/>
	<br/>

	<label for="performTime">공연 시간</label>:
	<form:input path="performTime" />
	<form:errors path="performTime"/>
	<br/>

	<label for="requestedTerm">요청 사항</label>:
	<form:input path="requestedTerm" />
	<form:errors path="requestedTerm"/>
	<br/>

	<label>온라인 공연
	<form:checkbox path="onlinePerform"/>
	</label>
	<br/><br/>
	<input type="submit" value="신청" />
</form:form>
</body>
</html>