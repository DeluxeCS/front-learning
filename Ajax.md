[TOC]

# Ajax

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

