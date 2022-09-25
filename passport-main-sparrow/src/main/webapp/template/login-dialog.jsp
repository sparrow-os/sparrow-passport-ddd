<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>快捷登录</title>
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
    <j:script src="$resource/scripts/passport.js"/>


    <meta name="application-name" content="${website_name}"/>
    <meta name="msapplication-tooltip" content="${website_name}"/>
</head>

<body style="width: 650px; height:450px;">

<div id="tabs" class="tab">
    <div class="pure-menu pure-menu-horizontal">
        <ul class="pure-menu-list" style="width: 100%;">
            <li class="pure-menu-item pure-menu-selected">
                <a class="pure-menu-link" href="javascript:void(0);"><span>登&nbsp;&nbsp;录</span></a>
            </li>
            <li class="pure-menu-item"><a class="pure-menu-link" href="javascript:void(0);"><span>注&nbsp;&nbsp;册</span>
            </a></li>
            <li class="pure-menu-item more"><a class="pure-menu-link" href="javascript:void(0);"
                                               onclick="parent.$.win.closeClick();"><span>关闭</span> </a></li>
        </ul>
    </div>
    <div class="tab-content">
        <div id="divShortCutLogin" class="block">
            <form method="post" class="pure-form pure-form-aligned">
                <input type="hidden" name="parameter" value="shortcut"/> <br/>
                <fieldset>
                    <div class="pure-control-group">
                        <label for="txtusername">
                            用户名
                        </label>
                        <input class="input" type="text" name="userName"
                               onfocus="$.v.showMessage(loginInfo,this);"
                               onblur="$.v.isNull(loginInfo,this);" id="txtUserName"/>
                        <j:span id="errorUserName" name="login_user_name" cssClass="pure-form-message-inline"/>
                    </div>
                    <div class="pure-control-group">
                        <label>
                            密 码
                        </label>

                        <input class="input" type="password"
                               onfocus="$.v.showMessage(loginInfo,this);"
                               onblur="$.v.isNull(loginInfo,this);" id="txtPassword"
                               name="password"/>
                        <j:span id="errorPassword" name="login_password" cssClass="pure-form-message-inline"/>
                    </div>
                    <div class="pure-control-group">
                        <label>
                            验证码
                        </label>
                        <input class="input" onfocus="$.v.showMessage(loginInfo,this);"
                               onblur="$.v.isNull(loginInfo,this);" type="text"
                               maxlength="4" name="validateCode" id="txtValidateCode"/>

                        <img id="imgLoginValidateCode"
                             onclick="$(this).fresh()" src="${rootPath}/ValidateCode"/>
                        <a href="javascript:$('#imgLoginValidateCode').fresh();"> 看不清 换一张</a>
                    </div>

                    <div class="pure-controls">
                        <j:span id="errorValidateCode" name="login_validate_code" cssClass="prompt"/>
                        <label for="chbLoginDays" class="pure-checkbox">
                            <input id="chbLoginDays" value="14" name="loginDays" type="checkbox"> 两周直接登录(家庭登录模式)<a
                                href="${root_path}/password/find-by-email">忘记密码</a><br/>
                            <span class="highlight">温馨提示</span>为了您的密码安全,如果您在网吧等公共场所请不要勾选此项
                        </label>

                        <button onenter="true" id="btnLogin"type="button"
                                class="pure-button pure-button-primary">登录
                        </button>
                    </div>
                </fieldset>
                <j:hidden name="redirectUrl" id="hdnRedirectUrl"/>
            </form>
        </div>
        <div id="divShortCutRegister" class="none">
            <form method="post" class="pure-form pure-form-aligned">
                <j:hidden name="introducer" id="hdnIntroducer"/>
                <fieldset>
                    <div class="pure-control-group">

                        <label> 电子邮箱 </label>
                        <input type="text" tabindex="1"
                               onfocus="$.v.showMessage(regInfo,this);" onblur="$.register.validate.email(this);"
                               name="email" id="txtEmail"/>
                        <j:span name="register_user_email" id="errorEmail" cssClass="prompt"/>
                    </div>
                    <div class="pure-control-group">
                        <label> 用户名 </label>
                        <input type="text" tabIndex="2"
                               onfocus='$.v.showMessage(regInfo,this);' onblur='$.register.validate.user(this);'
                               name="userName" id="txtRegUserName"/>
                        <j:span name="register_user_name" id="errorRegUserName" cssClass="prompt"/>
                    </div>
                    <div class="pure-control-group">
                        <label> 登陆密码 </label> <input class="input" type="password"
                                                     tabindex="3" onfocus="$.v.showMessage(regInfo,this);"
                                                     onblur="$.v.isNull(regInfo,this);" maxlength="16"
                                                     name="password" id="txtRegPassword"/>
                        <span id="errorRegPassword" class="prompt"></span>
                    </div>
                    <div class="pure-control-group">
                        <label> 确认密码 </label> <input name="passwordConfirm" class="input" type="password"
                                                     tabindex="4" onfocus="$.v.showMessage(regInfo,this);"
                                                     onblur="$.v.isEqual(regInfo,this);" maxlength="16"
                                                     id="txtConfirmPassword"/> <span
                            id="errorConfirmPassword" class="prompt"></span>
                    </div>
                    <div class="pure-control-group">
                        <label> 验证码 </label>

                        <input class="input"
                               type="text" tabindex="5"
                               onfocus="$.v.showMessage(regInfo,this)"
                               onblur="$.v.isNull(regInfo,this);" maxlength="4"
                               name="validateCode" id="txtRegValidateCode"/>
                        <img alt="validate code" align="absMiddle" id="imgValidateCode" onclick="$(this).fresh();"
                             src="ValidateCode"/>
                        <a href="javascript:$('#imgValidateCode').fresh();"> 看不清 换一张</a>
                    </div>
                    <div class="pure-controls">
                        <j:span id="errorRegValidateCode" name="register_validate_code" cssClass="prompt"/>
                        <br/>
                        <button onenter="true" id="btnRegister" type="button"
                                class="pure-button pure-button-primary">注册
                        </button>

                        <br/> <br/> <a target="_blank"
                                       href="${rootPath}/provision.jsp">${website_name}服务条款</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
