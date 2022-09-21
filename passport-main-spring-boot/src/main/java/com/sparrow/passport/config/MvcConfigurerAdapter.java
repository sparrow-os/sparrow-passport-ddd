package com.sparrow.passport.config;

import com.sparrow.protocol.ClientInformation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
                ClientInformation client = new ClientInformation();
                //todo 解析 client 自定义参数
                client.setIp("127.0.0.1");
                return client;
            }
        });
    }
}
