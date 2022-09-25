<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="J" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
<script type="text/javascript" charset="utf-8" src="http://lead.soperson.com/20000205/10039929.js"></script>
-->
<div class="banner" id="divBanner">
    <div class="welcome">
        <div class="center">
            <div class="left"><span> 欢迎致电 <span class="bold">13581579282</span> </span><span class="left-border">QQ:1016400800</span></div>
            <div class="login-bar right">
                <div id="divAccount">
                    <a class="name" href="javascript:void(0);" id="hyperUser"></a>
                    <a class="left-border" href="javascript:void(0);"
                             onclick="browser.logout();"> 安全退出</a>
                </div>
                <div id="divLogin">
                    <!-- onmouseover="showD3Login(event);"  -->
                    <a target="_blank"
                       href="${rootPath}/login">登 录</a> <a class="left-border" target="_blank"
                                                           href="${rootPath}/register">注 册</a>
                    <ul class="list" id="ulLogin"
                        onmouseover="$.event(event).cancelBubble();">
                        <li><a href="javascript:oauth.qqlogin();">QQ登录</a></li>
                        <li>微博登录</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="picture">
        <div class="logo left">
            <a target="_blank" href="${rootPath}"><img alt="${website_name}"
                                                       src="${websiteConfig.logo}"/> </a>
        </div>
        <div class="advertisement right">
            <img alt="${website_name}" src="${websiteConfig.banner}"/>
        </div>
    </div>
</div>