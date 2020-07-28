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

1. **指令** （v-cloak 页面刷新，隐藏画面*{{msg}}*元素 => 插值表达式闪动问题）

   ```css
   [v-cloak] {
     display: none;
   }
   ```

   自定义属性以**v-指令**

   v-text v-html(不荐用户提交时使用) v-pre

   **数据响应式** 

   数据驱动画面变化、数据绑定

   v-once 只编译一次，不具备数据响应。

   

2. **双向数据绑定 v-model** 

   **MVVM设计思想** model - view - (View-Model)

   视图-模型 （DOM监听） 模型-视图（事件绑定）

   v-on   v-bind 可实现双向数据绑定。

   `v-on:input='msg=$event.target.value'`

<img src="mvvm.png" style="zoom:75%;" />

3. **事件绑定**

   `v-on:click`   `@click`

4. 事件修饰符

   阻止冒泡 ：

   标签内 ：`@click.stop='fun()'` 

   方法内 ： `event.stopPropagation();`

   阻止默认行为

   标签内 ：`@click.prevent='fun()'` 

   方法内 ： `event.preventDefault();`

5. **按键修饰符**

   标签内 ：`@click.keyup.enter='fun()'` 

6. **自定义按键修饰符**

   `Vue.config.keyCodes.aaa = 65`
   
7. 属性绑定

   标签内 ：`<a v-bind:href='url'></a>`

   简写    ：`<a :href='url'></a>`

8. **样式绑定**

   - class样式处理

     默认class保留

     对象语法：`<div v-bind:class='{active:isActive}'></div>`

     数组语法：`<div v-bind:class='[activeClass, errorClass]'></div>`

   - style样式处理

     对象语法：`<div v-bind:style='{color:isActiveColor, fontSize:isActiveFontSize}'></div>`

     数组语法：`<div v-bind:class='[colorStyle, fontSizeStyle]'></div>`

9. **分支循环标签**

   v-if、v-else、v-else-if **控制元素是否渲染到页面**

   v-show:渲染页面、控制其是否显示`style：{dispaly:none}`

   v-for遍历数组 `<li v-for='(item,index) in list'>{{item}}</li>`

   - key：帮助Vue区分不同元素提高性能

     `<li :key='itme.id' v-for='(item, index) in list'>{{item}}</li>`

## Vue常用特性

1. **表单操作**

   - 单选 =>多选**multiple**

   - 表单域修饰符

     `v-model.number='age'`

     `v-text.trim=' 12 2 '`

     **lazy** input事件转change事件

     `v-model.lazy='text'` 

     **input事件**：输入内容一旦发生变化，立即触发事件。

     **change事件**：当表单失去鼠标焦点时，触发事件。

2. **自定义指令**

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

   

3. **计算属性 computed**

   计算属性：基于依赖（即v-model数据的变化）产生缓存

   方法：不产生缓存，每次都会执行。

4. **过滤器 filter**

   作用：格式化数据 upper/lower/日期格式化等

   标签内：`<div>{{msg | upper | lower}}</div>`

   `<div v-bind:id="id | upper | lower"></div>`

5. **侦听器 watch**

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

6. **生命周期**

   挂载、更新、销毁

   1. **beforeCreate** 实例初始化后，数据观测和（event/watcher ）事件配置之前被调用
   2. **created** 实例创建完成后被调用
   3. **beforeMount** 在挂载之前被调用
   4. **mounted** el被新创建的`vm.$el`替换、并挂载到实力上后调用该钩子
   5. **beforeUpdate** 数据更新时调用、发生在虚拟DOM打出补丁之前
   6. **updated** 由于数据更改导致虚拟DOM重新渲染画面/打补丁、之后调用该钩子
   7. **beforeDestroy** 实例销毁之前调用
   8. **destroyed** 实例销毁后调用

   总结：

   beforecreated：el 和 data 并未初始化
   created:完成了 data 数据的初始化，el没有，画面**{{message}}**，这是 Virtual DOM（虚拟Dom）技术，先把坑占了。到mounted挂载、再将值渲染进去。
   beforeMount：完成了 el 和 data 初始化
   mounted ：完成挂载

7. **数组相关API**

   **响应式变化**修改相应是数据

   `Vue.set(vm.items, indexOfItem, newValue)`

   `vm.$set(vm.items, indexOfItem, newValue)`

   数组更新检测

   ```swift
   push() 接收任意数量的参数，把它们逐个添加到数组末尾，并返回修改后数组的长度
   pop() 从数组末尾移除最后一项，减少数组的length值，然后返回移除的项
   shift() 移除数组中的第一个项并返回该项，同时数组的长度减1
   unshift() 在数组前端添加任意个项并返回新数组长度
   splice() 删除原数组的一部分成员，并可以在被删除的位置添加入新的数组成员
   sort() 调用每个数组项的toString()方法，然后比较得到的字符串排序，返回经过排序之后的数组
   reverse() 用于反转数组的顺序，返回经过排序之后的数组
   ```

   替换数组

   `filter()`、`concat()` 和 `slice()`它们不会变更原始数组，而**总是返回一个新数组**。

   由于 JavaScript 的限制，Vue **不能检测**数组和对象的变化

## Vue组件化开发

1. **全局组件注册**

```js
// 组件注册
Vue.component("btn-count", {
  // data是函数，保证组件内部数据相互独立
  data: function () {
    return {
      count: 0,
    };
  },
  // 必须具备单个根元素，支持ES6模板字符串
  template: `
  <div>
      <button @click="handle" v-text='count'></button>
      </div>
  `,
  methods: {
    // 方法调用
    handle: function () {
      this.count += 2;
    },
  },
});
```

2. **命名规则**

   驼峰式命名组件、全局作用域下转分隔符**-**连接、在ES6模板字符串中直接使用.

3. **局部组件注册**

   app下只能在其标签下使用

4. Vue调试工具

5. 组件间交互

   - 父---子

     

