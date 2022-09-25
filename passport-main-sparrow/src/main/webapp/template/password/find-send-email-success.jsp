<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<html>
<head>
    <base/>
    <title>找回密码-${website_name}</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="找回密码"/>
    <meta http-equiv="description" content="找回密码"/>

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
        <h1>${website_name}-找回密码</h1>
        <h2>
            通过邮箱找回
        </h2>
    </div>

    <div class="content">
<br/><br/>

                <p>密码找回验证邮件已发送至${email}  <a target="_blank" href="${value}"
                                                        onclick="$.browser.hyperClick(this,lang.message.email_no_config);">进入验证邮箱</a> <br/>
                </p> <br/>

                未收到?


        <input type="button" class="pure-button pure-button-primary button-xlarge pure-input-1-4"  onclick="$.ajax.json('${root_path}/password/email/send.json','email=${email}')" value="重新发送"/>
    </div>
</div>
</body>
</html>
