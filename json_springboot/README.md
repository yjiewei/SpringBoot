1. 接口和接口间，前后端之间交互都是通过json来传输数据的，springboot web中自带jackson
2. 传输的数据结构主要由类对象、list对象、map对象
3. 传输的null值如何处理，对jackson多做一个配置
4. jackson和fastjson有什么区别
    - fastjson更加容易上手，但没那么灵活
    - 处理null值的方法也不一样
   
   使用fastjson步骤
      - 引入依赖
      - 配置类FastjsonConfig
      - 与jackson并用会采用fastjson
   
5. 封装统一返回的数据结构json