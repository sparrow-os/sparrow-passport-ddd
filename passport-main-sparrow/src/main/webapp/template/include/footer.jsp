<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="footer">
    <dl class="foot-body">
        <dd>
            ${websitConfig.description} <br/>Copyright&copy;<fmt:formatDate value="${now}" type="both" dateStyle="long"
                                                                            pattern="yyyy"/>
            ${website_name} All Rights Reserved ${websitConfig.icp}
        </dd>
        <dd>
            <!-- <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd HH:mm:ss"/> -->
            <!-- 2014-11-18 16:28:22 2822 -->
            ${websitConfig.contact}
        </dd>
        <dd>${indexFriendHyperLink}</dd>
    </dl>
</div>