1. 导入依赖
2. 关掉默认开启的页面缓存
3. 页面引入标签依赖
4. 页面传参到后台通过name属性，后台接收到之后可以封装成对象，再转发到另外一个页面

th:object="${}" 来获取对象信息
使用 th:value="*{属性名}"
使用 th:value="${对象.属性名}" ，对象指的是上面使用 th:object 获取的对象
使用 th:value="${对象.get方法}" ，对象指的是上面使用 th:object 获取的对象

https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
