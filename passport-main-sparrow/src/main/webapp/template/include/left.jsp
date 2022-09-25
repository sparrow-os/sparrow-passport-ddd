<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<div class="left_menu">
    <ul id="divLeftMenu">
        <c:forEach items="${menuList}" var="menu" varStatus="status">
            <li class="item"><a class="link" href="${menu.hyperLink}"
                                target="_blank">${menu.title}</a>
                <c:if test="${f:length(menu.childs)>0}">
                    <ul class="list">
                        <c:forEach items="${menu.childs}" var="sub" varStatus="subStauts">
                            <li><a href="${sub.hyperLink}" target="_blank">${sub.title}</a></li>
                        </c:forEach>
                    </ul>
                </c:if>
            </li>
        </c:forEach>
    </ul>
</div>