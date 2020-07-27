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
3. 省市区联动

## FormData

### 对象作用

1. 自动将表单中的数据拼接成请求参数的格式。
2. 异步上传二级制文件

### 对象使用

```js
<form id="form">
    <input type="text" name="uname" id="" />
    <input type="password" name="pwd" id="" />
    <input type="button" value="提交" id="btn" />
  </form>
  <script>
    // 获取提交按钮元素
    var btn = document.getElementById("btn");
    //   获取表单dom元素
    var form = document.getElementById("form");
    //   触发事件
    btn.addEventListener("click", function () {
      //   html表单转换表单对象
      let formData = new FormData(form);
      // ajax异步交互
      let ajx = new XMLHttpRequest();
      ajx.open("post", "http://localhost:3000/formData");
      ajx.send(formData);
      ajx.onload = function () {
        if (ajx.status == 200) {
          console.log(ajx.responseText);
        }
      };
    });
  </script>
```

`formData.get("key")`

`formData.set("name","zs")` 覆盖同名参数值

`formData.delete("key")`

`formData.append("key","value")` 保留两个参数值

### 二进制文件上传

1. 

2. 进度条

   ```js
   ajx.load.onprogress = function(ev){
       // ev.loaded 文件已上传多少
       // ev.total  上传文件总大小
       var result = (ev.loaded / ev.total) * 100 + '%';
   }
   ```

## Ajax限制

ajax只能向自己的服务器发送请求、跨域访问违反了**同源策略**

### 同源

定义：协议(http/https)、域名(www/v2)、端口(80/81)，三者一致

### 同源访问限制

解决方案：JSONP，模拟ajax的**Get**请求

核心：script标签可以向非同源服务器发送请求、服务器端返回函数调用的**字符串**，即在客户端作为JS代码执行。客户端提前定义函数。

```js
// 服务器
app.get("/test", (req, res) => {
  const rs = "fn({uname: 'zs'})";
  res.send(rs);
});
app.listen(3001); // 监听3000端口

// 客户端
<script>
  function fn(info) {   // 全局函数
    console.log(info);
  }
</script>
<!-- 1.将非同源服务器请求地址放在script：src标签中 -->
<script src="http://localhost:3001/test"></script>
```

### 优化：

### 客户端传递给服务器端的**函数名**

`<script src="http://localhost:3001/better?callback=fn1"></script>  //客户端`

```js
// 服务器端
app.get("/better", (req, res) => {
  const fname = req.query.callback;  // 通过请求参数确认函数名称
  const data = JSON.stringify('{uname: 'zs'}');
  const rs = fname + '(' + data + ')';
  res.send(rs);
  // 简化代码
  res.jsonp({uname: 'zs', age: 11});
});
```

### JSONP函数封装

```js
// jsonp函数封装
function jsonp(options) {
  // 1、定义全局函数
  let fnName = "jsonp" + Math.random().toString().replace(".", "");
  window[fnName] = options.success;
  // 2、将非同源服务器请求地址放在script：src标签中
  let script = document.createElement("script");
  // 3、拼接字符串变量
  let parms = "";
  for (atter in options.data) {
    parms += "&" + atter + ":" + options.data[atter];
  }
  script.src = options.url + "?callback=" + fnName + parms;
  //  4、画面追加script元素
  console.log(script);
  document.body.appendChild(script);
  //  5、为script追加onload事件，并及时清除script
  script.onload = function () {
    document.body.removeChild(script);
  };
}
```

#### 调用

```js
//   添加监听事件
btn.addEventListener("click", function () {
  jsonp({
    url: "http://localhost:3001/best",
    data: {
      uname: "zs",
      age: 15,
    },
    success: function () {
      console.log(123);
    },
  });
});
```

