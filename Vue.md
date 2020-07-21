[TOC]

# Vue

## Vue概述

渐进式JavaScript框架

声明式渲染=>组件系统=>客户端路由=>集中式状态管理=>项目构建

helloworld！

```js
  <body>
    <div class="app">
      {{msg}}         // 插值表达式
    </div>
  </body>
  <script type="text/javascript">
    var vm = new Vue({
      el: ".app",    // el 元素的挂载位置(CSS选择器 || DOM元素)
      data: {        // data 模型数据(数据是一个对象)
        msg: "hello world!",
      },
    });
  </script>
```



## Vue模板语法

1. 指令 （v-cloak 页面刷新，隐藏画面*{{msg}}*元素 => 插值表达式闪动问题）

   自定义属性以**v-指令**

   v-text v-html(不荐用户提交时使用) v-pre

   **数据响应式** 

   数据驱动画面变化、数据绑定

   v-once 只编译一次，不具备数据响应。

   

2. 双向数据绑定 v-model 

   **MVVM设计思想** model - view - (View-Model)

   视图-模型 （DOM监听） 模型-视图（事件绑定）

<img src="mvvm.png" style="zoom:75%;" />

3. 事件绑定

   `v-on:click`   `@click`

4. 事件修饰符

   阻止冒泡 ：

   标签内 ：`@click.stop='fun()'` 

   方法内 ： `event.stopPropagation();`

   阻止默认行为

   标签内 ：`@click.prevent='fun()'` 

   方法内 ： `event.preventDefault();`

5. 按键修饰符

   标签内 ：`@click.keyup.enter='fun()'` 

6. 自定义按键修饰符

   `Vue.config.keyCodes.aaa = 65`