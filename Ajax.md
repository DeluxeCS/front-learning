[TOC]

# Ajax

## 概念

页面无刷新数据交互。

```js
  <script type="text/javascript">
    // ajax对象实例
    let ajx = new XMLHttpRequest();
    // 请求方式、请求地址
    ajx.open("get", "http://localhost:3000/new");
    // 发送请求、服务器端不能实时回复
    ajx.send();
    // 接受回复信息
    ajx.onload = function () {
      console.log(ajx.responseText);
    };
  </script>
```

## 请求方式

- GET请求方式

  `ajx.open("get", "http://localhost:3000/jsonfile?" + parms);`

- POST请求方式

  ```js
  ajx.open("post", "http://localhost:3000/jsonfile");
  let parms = "username=" + uname.value + "&pwd=" + pawd.value;
  // 设置post请求参数格式类型（post必须设置）
  ajx.setRequestHeader(
         "Content-Type", 
         "application/x-www-form-urlencoded"
       );
  ajx.send(parms); // 传递POST请求参数
  ```

  JSON格式参数传递

  `ajx.setRequestHeader("Content-Type", "application/json");`

  `app.user(bodyParse.json()) // 客户端解析`

## 错误处理

1、！200 网通，Server可接收、返回结果不是预想的

`ajx.status() // 获取http状态码`=服务器端返回的结果

2、404 网通、服务器接受请求、

3、500网络畅通，服务器端可接收请求

4、不触发onload()事件、触发onerror()事件

## 低版本IE缓存问题

问题：客户端向同一个url发送请求，第二次请求不被处理，直接返回第一次请求结果

解决方案：请求地址随即变更`ajx.open('get', 'http://localhost:3000?'+Math.random())`

## Ajax封装

```js
ajax({
  type: "get",
  url: "http://localhost:3000/fz",
  data: {     // 传递参数为对象结构，方便get/post格式的转换
    name: "user",
    age: 123,
  },
  header: {
    "Content-Type": "application/x-www-form-urlencoded", //json
  },
  success: function (data) {
    console.log(data);
  },
   error: function (data) {
    console.log(data);
  },
});
```

## 模板引擎 art-template

```javascript
  <!-- 1.引入模板引擎的库文件 -->
  <script src="./js/template-web.js"></script>
  <!-- 2.template模板引擎 -->
  <script id="tp1" type="text/html">
    <h1>{{username}}{{age}}</h1>
  </script>
  <!-- 3.模板引擎与模块的拼接 -->
  <script type="text/javascript">
    //   1、模板ID 2、数据||对象类型
    let obj = {
      username: "zs",
      age: 28,
    };
    // 返回模板对象拼接的字符串
    let htmlinfo = template("tp1", obj);
  </script>
```

## 案例

1. 邮箱唯一性验证
2. 搜索框自动提示





