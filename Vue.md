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
   
   v-on   v-bind 可实现双向数据绑定。
   
   `v-on:input='msg=$event.target.value'`

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
   
7. 属性绑定

   标签内 ：`<a v-bind:href='url'></a>`

   简写    ：`<a :href='url'></a>`

8. 样式绑定

   - class样式处理

     默认class保留

     对象语法：`<div v-bind:class='{active:isActive}'></div>`

     数组语法：`<div v-bind:class='[activeClass, errorClass]'></div>`

   - style样式处理

     对象语法：`<div v-bind:style='{color:isActiveColor, fontSize:isActiveFontSize}'></div>`

     数组语法：`<div v-bind:class='[colorStyle, fontSizeStyle]'></div>`

9. 分支循环标签

   v-if、v-else、v-else-if **控制元素是否渲染到页面**

   v-show:渲染页面、控制其是否显示`style：{dispaly:none}`

   v-for遍历数组 `<li v-for='(item,index) in list'>{{item}}</li>`

   - key：帮助Vue区分不同元素提高性能

     `<li :key='itme.id' v-for='(item, index) in list'>{{item}}</li>`

## Vue常用特性

1. 表单操作

   - 单选 =>多选**multiple**

   - 表单域修饰符

     `v-model.number='age'`

     `v-text.trim=' 12 2 '`

     **lazy** input事件转change事件

     `v-model.lazy='text'` 

     **input事件**：输入内容一旦发生变化，立即触发事件。

     **change事件**：当表单失去鼠标焦点时，触发事件。

2. 自定义指令

   ```js
   // 以下内容声明在new Vue()之前
   // v-focus 
      Vue.directive("focus", {
         // 当被绑定的元素插入到 DOM 中时……
         inserted: function (el) {
           // 聚焦元素
           el.focus();
         },
   ```

   ```js
   // 带参数指令
   // v-color='{color:"orange"}' 
   
     Vue.directive("color", {
         // 当被绑定的元素插入到 DOM 中时……
         bind: function (el, binding) {
           el.style.backgroundColor = binding.value.color;
         },
       });
   ```

   

3. 计算属性 computed

   计算属性：基于依赖（即v-model数据的变化）产生缓存

   方法：不产生缓存，每次都会执行。

4. 过滤器 filter

   作用：格式化数据 upper/lower/日期格式化等

   标签内：`<div>{{msg | upper | lower}}</div>`

   `<div v-bind:id="id | upper | lower"></div>`

5. 侦听器 watch

   场景：当数据变化执行异步或开销较大的操作

   注意：watch内方法名要与**监听对象**一致。

   ```js
        filters: {
           foramt: function (date, format) {
             var ret = "";
             ret += date.getFullYear() + "_" + (date.getMonth() + 1);
             return ret;  // 过滤器要有返回值
           },
         },
   ```

   

1. 生命周期

