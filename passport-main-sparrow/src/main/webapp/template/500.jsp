<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<%@taglib uri="http://www.sparrowzoo.com/el" prefix="e" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>500 ${flash_exception_result.code}-${flash_exception_result.message}-${website_name}</title>
    <meta content="500 error" name="keywords"/>
    <meta content="${flash_exception_result.message}" name="description"/>
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
        <h1>服务器错误</h1>
        <h2>
            错误代码:${flash_exception_result.code}
            <br/><a href="${root_path}">返回首页</a>
        </h2>
    </div>
    <div class="content">
        ${flash_exception_result.message}<br/>
        <c:if test="${pageContext.request.queryString!=null}">
            <span url="${pageContext.request.queryString}" id="timer">50</span>秒以后自动跳转
            或者<a href="${pageContext.request.queryString}" target="_self">直接点击这里跳转</a>
        </c:if>
        <script type="text/javascript">
            $.waitRedirect("timer");
        </script>
        <br/>
    </div>
</div>
</body>
</html>
