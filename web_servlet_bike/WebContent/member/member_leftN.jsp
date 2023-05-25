<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="b_left">
	<P>MEMBER</P>
	<ul>
		<li><a href="javascript:void()" onClick="goMember('login')"><c:if test="${t_requestPage eq 'login' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> LOGIN</a></li>
		<li><a href="javascript:void()" onClick="goMember('passwordFind')"><c:if test="${t_requestPage eq 'passwordFind' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> ID / PASSWORD</a></li>
		<li><a href="javascript:void()" onClick="goMember('join')"><c:if test="${t_requestPage eq 'join' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> JOIN</a></li>
	</ul>
</div>

