<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="noticeDAO" class="com.zimcarry.notice.NoticeDAO" />
<c:if test="${not empty noticeDAO.noticeDataToJSON(param.noIdx)}" >
	${noticeDAO.noticeDataToJSON(param.noIdx)}
	<%System.out.println(noticeDAO.noticeDataToJSON("1")); %>
</c:if>
