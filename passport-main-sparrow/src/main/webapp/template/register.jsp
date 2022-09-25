<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>新用户注册-${website_name}</title>
    <meta content="register 注册 " name="keywords"/>
    <meta content="${websiteConfig.description}" name="description"/>
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
    <j:script src="$resource/ext/scripts/system/language/$language/user.js"/>
    <j:script src="$resource/ext/scripts/passport.js"/>
</head>
<body>
<J:JScript src="$resource/$website/javascript/baidu.js"/>

<div class="body">

    <div class="header">
        <h1>${website_name}- 新用户注册</h1>
        <h2>
            您已有帐号?
            <a href="${root_path}/login">直接登录</a>
        </h2>
    </div>

    <div class="content">
        <br/>
        <j:span id="errorRegister" name="error" cssClass="error"/>
        <form action="register.do" method="post" class="pure-form pure-form-aligned">
            <j:hidden name="introducer" id="hdnIntroducer"/>
            <fieldset>
                <div class="pure-control-group">

                    <label> 电子邮箱 </label>
                    <input type="text" value="${email}" tabindex="1"
                           onfocus="$.v.showMessage(regInfo,this);" onblur="$.v.isEmail(regInfo,this);"
                           name="email" id="txtEmail"/>
                    <j:span name="register_user_email" id="errorEmail" cssClass="error"/>
                </div>
                <div class="pure-control-group">
                    <label> 用户名 </label>
                    <input value="${userName}" type="text" tabIndex="2"
                           onfocus='$.v.showMessage(regInfo,this);' onblur='$.v.isUserNameRule(regInfo,this);'
                           name="userName" id="txtUserName"/>
                    <j:span name="register_user_name" id="errorUserName" cssClass="error"/>
                </div>
                <div class="pure-control-group">
                    <label> 登陆密码 </label> <input class="input" type="password"
                                                 tabindex="3" onfocus="$.v.showMessage(regInfo,this);"
                                                 onblur="$.v.isNull(regInfo,this);" maxlength="16"
                                                 name="password" id="txtPassword"/>
                    <j:span id="errorRegPassword" cssClass="error" name="register_password"/>
                </div>
                <div class="pure-control-group">
                    <label> 确认密码 </label> <input name="passwordConfirm" class="input" type="password"
                                                 tabindex="4" onfocus="$.v.showMessage(regInfo,this);"
                                                 onblur="$.v.isEqual(regInfo,this);" maxlength="16"
                                                 id="txtConfirmPassword"/>

                    <j:span id="errorConfirmPassword" cssClass="error" name="register_confirm_password"/>
                </div>
                <div class="pure-control-group">
                    <label> 验证码 </label>
                    <input class="input"
                           type="text" tabindex="5"
                           onfocus="$.v.showMessage(regInfo,this)"
                           onblur="$.v.isNull(regInfo,this);" maxlength="4"
                           name="validateCode" id="txtValidateCode"/>
                    <img alt="validate code" align="absMiddle" id="imgValidateCode" onclick="$(this).fresh();"
                         src="ValidateCode"/>
                    <a href="javascript:$('#imgValidateCode').fresh();"> 看不清 换一张</a>
                    <j:span id="errorValidateCode" name="register_validate_code" cssClass="error"/>
                </div>
                <div class="pure-controls">

                    <button onenter="true" type="button" onclick="$.v.getValidateResult(regInfo);"
                            class="pure-button pure-button-primary">注册
                    </button>

                    <br/> <br/> <a target="_blank"
                                   href="${rootPath}/provision.jsp">${website_name}服务条款</a>
                </div>
            </fieldset>
    </div>
</div>
</body>
</html>
