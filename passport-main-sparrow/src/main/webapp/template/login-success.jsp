<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<%@taglib uri="http://www.sparrowzoo.com/el" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>${e:i18n('login_success_msg')}-${website_name}</title>
    <meta content="error" name="keywords"/>
    <meta content="${e:i18n('login_success_msg')}" name="description"/>
    <meta name="application-name" content="${website_name}"/>
    <meta name="msapplication-tooltip" content="${website_name}"/>
    <j:style href="$resource/styles/pure-css/pure-min.css"/>
    <!--[if lte IE 8]>
    <j:style href="$resource/styles/layouts-old-ie.css"/>
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <j:style href="$resource/styles/layouts.css"/>
    <!--<![endif]-->
    <j:style href="$resource/styles/sparrow.css"/>
    <j:script src="$resource/scripts/sparrow.js"/>
</head>
<body>
<j:script src="$resource/scripts/baidu.js"/>
<div class="body">
    <div class="header">
        <h1>${e:i18n('login_success_msg')}-${flash_success_result.userName}</h1>
    </div>
    <div class="content">
        <br/>
        <span class="highlight" url="${pageContext.request.queryString}" id="timer">5</span>秒以后将自动跳转,或者<a
            href="${pageContext.request.queryString}" target="_self">直接点击这里跳转</a>
        <script type="text/javascript">
            $.waitRedirect("timer");
        </script>
        <br/>
        <c:if test="${not empty default_welcome_index}">
            <a href="${default_welcome_index}">或点击这里,直接返回首页</a>
        </c:if>
    </div>
</div>
</body>
</html>