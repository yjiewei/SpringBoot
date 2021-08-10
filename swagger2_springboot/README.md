自己启动一下查看这两个链接就完事了。

实在不行你就粘贴下面的json格式化一下再去对比controller类的接口。

http://localhost:8001/swagger-ui.html#/

http://localhost:8001/v2/api-docs
```{
"swagger": "2.0",
"info": {
"description": "杨杰炜学习SpringBoot的笔记",
"version": "1.0",
"title": "Spring Boot集成Swagger2接口总览",
"contact": {
"name": "杨杰炜GitHub地址：https://github.com/yjiewei/SpringBoot"
}
},
"host": "localhost:8001",
"basePath": "/",
"tags": [{
"name": "swagger-2-controller",
"description": "Swagger 2 Controller"
}],
"paths": {
"/swagger/get/{id}": {
"get": {
"tags": [
"swagger-2-controller"
],
"summary": "根据用户唯一标识获取用户信息",
"operationId": "getUserInfoUsingGET",
"produces": [
"*/*"
],
"parameters": [{
"name": "id",
"in": "path",
"description": "用户唯一标识",
"required": false,
"type": "integer",
"format": "int64"
}],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/JsonResult«用户实体类»",
"originalRef": "JsonResult«用户实体类»"
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
},
"deprecated": false
}
},
"/swagger/insert": {
"post": {
"tags": [
"swagger-2-controller"
],
"summary": "添加用户信息",
"operationId": "insertUserUsingPOST",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"parameters": [{
"in": "body",
"name": "user",
"description": "用户信息",
"required": false,
"schema": {
"$ref": "#/definitions/用户实体类",
"originalRef": "用户实体类"
}
}],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/JsonResult«Void»",
"originalRef": "JsonResult«Void»"
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
},
"deprecated": false
}
}
},
"definitions": {
"JsonResult«Void»": {
"type": "object",
"properties": {
"code": {
"type": "string"
},
"msg": {
"type": "string"
}
},
"title": "JsonResult«Void»"
},
"JsonResult«用户实体类»": {
"type": "object",
"properties": {
"code": {
"type": "string"
},
"data": {
"$ref": "#/definitions/用户实体类",
"originalRef": "用户实体类"
},
"msg": {
"type": "string"
}
},
"title": "JsonResult«用户实体类»"
},
"用户实体类": {
"type": "object",
"properties": {
"id": {
"type": "integer",
"format": "int64",
"description": "用户唯一标识"
},
"password": {
"type": "string",
"description": "用户密码"
},
"username": {
"type": "string",
"description": "用户姓名"
}
},
"title": "用户实体类"
}
}
}```