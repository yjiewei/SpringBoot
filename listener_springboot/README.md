web 监听器是一种 Servlet 中特殊的类，它们能帮助开发者监听 web 中特定的事件，比如 **ServletContext, HttpSession, ServletRequest** 的创建和销毁；变量的创建、销毁和修改等。
可以在某些动作前后增加处理，实现监控。细看代码示例。

- **ServletContext 监听上下文对象**
  
  **监听 servlet 上下文对象可以用来初始化数据，用于缓存**
    
    把上下文中经常用但是大部分时间都不变的，放到缓存中，减轻数据库的压力，用户体验也更好。
    

- **监听HTTP会话 Session对象 HttpSession**

  监听 session 来**获取当前在线用户数量**是个很常见的使用场景


- **监听客户端请求Servlet Request对象**

  使用监听器获取用户的访问信息比较简单


- **Spring Boot中自定义事件监听**
  - 比如服务A处理完需要通知服务B去处理
  - 自定义事件
  - 自定义监听器