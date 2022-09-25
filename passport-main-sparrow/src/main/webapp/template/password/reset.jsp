<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<html>
<head>
    <base/>
    <title>密码重置成功-${website_name}</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="密码重置成功"/>
    <meta http-equiv="description" content="密码重置成功"/>
    <j:style href="$resource/styles/pure-css/pure-min.css"/>
    <!--[if lte IE 8]>
    <j:style href="$resource/styles/layouts-old-ie.css"/>
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <j:style href="$resource/styles/layouts.css"/>
    <!--<![endif]-->
    <j:style href="$resource/styles/sparrow.css"/>
    <j:script src="$resource/scripts/sparrow.js"/>
    <j:script src="$resource/scripts/system/language/$language/user.js"/>

</head>
<body>
<j:script src="$resource/scripts/baidu.js"/>
<div class="body">

    <div class="header">
        <h1>${website_name}-密码重置成功</h1>
        <h2>
            <a href="${root_path}">回到${website_name}</a>
            或点击<a href="${root_path}/login">重新登录</a>
        </h2>
    </div>

    <div class="content">

    </div>
</div>
</body>
</html>
