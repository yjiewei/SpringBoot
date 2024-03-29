使用拦截器的步骤
1. 定义拦截器 实现HandlerInterceptor接口
2. 配置拦截器 继承WebMvcConfigurationSupport类重写addInterceptors()
    - WebMvcConfigurationSupport类默认拦截静态资源 
        - 重写addResourceHandlers() com/yjiewei/config/MyInterceptorConfig.java:29
        - 可以不继承WebMvcConfigurationSupport类，直接实现WebMvcConfigurer接口，然后重写addInterceptors方法，它不会拦截静态资源
   
3. 如上面所写，两种拦截器的配置方式都是可行的，通常WebMvcConfigurationSupport会用在前后端分离的项目，这样可以不用开放静态资源，对于非前后端分离的项目就可以用WebMvcConfigurer接口来进行配置

使用场景
1. 用户登录判断
   - session中存放user
   - 登录成功之后每次访问都携带token，拦截器拦截到token就说明已经登录
   
2. 取消拦截操作
   - 如果当前某个被拦截的路径下我想放行某个访问请求，如何更加方便的实现可插拔式的配置
   - 定义注解（只是一个标识），当拦截器拦截到这个注解，直接放行