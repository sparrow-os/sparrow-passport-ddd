AuthenticatorService 用作认证,可用于认证服务内部的使用,网关通过webclient 访问，参见 sparrow-gateway

MonolithicLoginUserFilter 作为单体应用时的统一认证过滤

其他的认证过滤器，可参考 sparrow 项目中的认证过滤器,业务微服务可以依赖sparrow web 包下的过滤器，及sparrow-starter 下的解析器，不需要依赖 passport-authenticator

