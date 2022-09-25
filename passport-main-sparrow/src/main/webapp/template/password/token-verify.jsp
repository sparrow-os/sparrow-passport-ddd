<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<html>
<head>
    <base/>
    <title>密码重置-${website_name}</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="密码重置"/>
    <meta http-equiv="description" content="密码重置"/>
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
        <h1>${website_name}-密码重置</h1>
        <h2>
            请输入您的新密码
        </h2>
    </div>

    <div class="content">
        <form action="/password/email/reset.do" method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <j:hidden name="token" id="hdnValidateToken"/>
                <div class="pure-control-group">
                    <label for="txtPassword">
                        新密码
                    </label>
                    <input type="password"
                           onfocus="$.v.showMessage(password,this);"
                           onblur="$.v.isNull(password,this);" id="txtPassword"
                           name="newPassword"/>
                    <j:span id="errorPassword" name="password" cssClass="pure-form-message-inline"/>
                </div>
                <div class="pure-control-group">
                    <label for="txtConfirmPassword">确认密码</label>
                    <input type="password" onfocus="$.v.showMessage(password,this);"
                                                                        onblur="$.v.isEqual(password,this);"
                                                                        id="txtConfirmPassword" name="newPassword2"/>
                    <j:span id="errorConfirmPassword" name="confirm_password" cssClass="pure-form-message-inline"/>
                </div>

                <div class="pure-controls">
                    <button onenter="true" type="button" onclick="$.v.getValidateResult(password);"
                            class="pure-button pure-button-primary">提交
                    </button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
