package com.sparrow.passport.config;

import com.sparrow.passport.ValidateCode;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.ClientInfoConstant;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.enums.Platform;
import com.sparrow.support.web.ServletUtility;
import com.sparrow.utility.StringUtility;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurerAdapter implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    private ServletUtility servletUtility = ServletUtility.getInstance();

    @Bean
    public ServletRegistrationBean servletTLReportServlet() {
        return new ServletRegistrationBean(new ValidateCode(), "/validate-code");
    }

    /**
     * 配置静态访问资源
     * <p>
     * http://localhost:8000/s/static.html
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/s/**").addResourceLocations("classpath:/static/");
    }

    @Override public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HandlerMethodArgumentResolver() {
                                  @Override public boolean supportsParameter(MethodParameter parameter) {
                                      return parameter.getParameter().getParameterizedType().equals(ClientInformation.class);
                                  }

                                  @Override public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                      NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
                                      HttpServletRequest req = (HttpServletRequest) request.getNativeRequest();
                                      ClientInformation clientInformation = new com.sparrow.protocol.ClientInformation();
                                      clientInformation.setIp(servletUtility.getClientIp(req));
                                      String appId = request.getHeader(ClientInfoConstant.APP_ID);
                                      if (!StringUtility.isNullOrEmpty(appId)) {
                                          clientInformation.setAppId(Integer.parseInt(appId));
                                      }

                                      String appVersion = request.getHeader(ClientInfoConstant.APP_VERSION);
                                      if (!StringUtility.isNullOrEmpty(appVersion)) {
                                          clientInformation.setAppVersion(Float.parseFloat(appVersion));
                                      }

                                      clientInformation.setBssid(request.getHeader(ClientInfoConstant.BSSID));
                                      clientInformation.setChannel(request.getHeader(ClientInfoConstant.CHANNEL));
                                      clientInformation.setClientVersion(request.getHeader(ClientInfoConstant.CLIENT_VERSION));

                                      clientInformation.setDevice(request.getHeader(ClientInfoConstant.DEVICE));
                                      clientInformation.setDeviceId(request.getHeader(ClientInfoConstant.DEVICE_ID));
                                      clientInformation.setDeviceModel(request.getHeader(ClientInfoConstant.DEVICE_MODEL));

                                      clientInformation.setIdfa(request.getHeader(ClientInfoConstant.IDFA));
                                      clientInformation.setImei(request.getHeader(ClientInfoConstant.IMEI));
                                      String latitude = request.getHeader(ClientInfoConstant.LATITUDE);
                                      if (!StringUtility.isNullOrEmpty(latitude)) {
                                          clientInformation.setLatitude(Double.parseDouble(request.getHeader(ClientInfoConstant.LATITUDE)));
                                      }

                                      String longitude = request.getHeader(ClientInfoConstant.LONGITUDE);
                                      if (!StringUtility.isNullOrEmpty(longitude)) {
                                          clientInformation.setLongitude(Double.parseDouble(request.getHeader(ClientInfoConstant.LONGITUDE)));
                                      }

                                      clientInformation.setOs(request.getHeader(ClientInfoConstant.OS));
                                      clientInformation.setNetwork(request.getHeader(ClientInfoConstant.NETWORK));
                                      String startTime = request.getHeader(ClientInfoConstant.START_TIME);
                                      if (!StringUtility.isNullOrEmpty(startTime)) {
                                          clientInformation.setStartTime(Long.parseLong(startTime));
                                      }
                                      String resumeTime = request.getHeader(ClientInfoConstant.RESUME_TIME);

                                      if (!StringUtility.isNullOrEmpty(resumeTime)) {
                                          clientInformation.setResumeTime(Long.parseLong(resumeTime));
                                      }
                                      //clientInformation.setWebsite(rootPath);
                                      clientInformation.setUserAgent(request.getHeader(ClientInfoConstant.USER_AGENT));
                                      UserAgent userAgent = UserAgent.parseUserAgentString(clientInformation.getUserAgent());
                                      OperatingSystem os = userAgent.getOperatingSystem();
                                      Browser browser = userAgent.getBrowser();
                                      logger.info("device type {},browser type {}", os.getDeviceType(), browser.getBrowserType());
                                      if (os.getDeviceType().equals(DeviceType.COMPUTER) || BrowserType.MOBILE_BROWSER.equals(browser.getBrowserType())) {
                                          clientInformation.setOs(os.getGroup().getName());
                                          clientInformation.setPlatform(Platform.PC);
                                          clientInformation.setDevice(browser.getName());
                                          clientInformation.setDeviceId(clientInformation.getIp());
                                      }

                                      String simulate = request.getHeader(ClientInfoConstant.SIMULATE);
                                      if (!StringUtility.isNullOrEmpty(simulate)) {
                                          clientInformation.setSimulate(Boolean.valueOf(simulate));
                                      }
                                      return clientInformation;
                                  }
                              }
        );
    }
}
