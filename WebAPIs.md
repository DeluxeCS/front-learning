[TOC]

# Web APIs

页面交互功能

DOM+BOM

## DOM 接口

1. 获取元素
2. 事件基础
3. 操作元素
4. 操作节点

文档对象、元素(标签element)、节点(内容Node)

### 元素获取

  获取<body>标签内容==document.**body**

  获取<html>标签内容==document.**documentElement**

### 事件基础

三要素：

- 获取事件源

- 注册事件类型

- 追加事件处理程序

### 操作元素

1. 修改元素内容

   innerText  不识别html标签

   innerHTML 识别html标签
   
2. 样式属性操作

   element.style 行内样式操作  权重较高

   element.className 类名样式操作， 当涉及变化的style较多，修改className更改元素样式。

   ```js
   this.className = 'first change'; // 当该元素已存在类时，多类名选择器
   ```

3. 自定义属性操作

   element.属性 **获取元素本身自带属性**

   element.getAttribute('属性')；**可以获取自定义属性**

   H5新增自定义属性方法=》 **data-index='2';**

   获取：**div.dataset.index**  

   **dataset **是一个自定义以data开头的属性的集合。

### 节点操作

   父子级节点、**element.children**

子节点：

element.children[index] 获取所有子元素节点

firstChild，firstElementChild，lastElementChild(**IE9**以上支持)

**节点的追加**

document.wirte('<div>html</div>'); 页面重绘

element.innerHTML(<div>html</div>); 页面追加

**多个元素的场合**

*innerHTML()*  (在不使用拼接字符串场合、使用数组拼接) 效率高

*createElement()* (创建躲过元素，结构清晰) 

克隆(复制)

### 事件高级

传统注册事件 **唯一性**

**监听事件注册**

`EventTarget.addEventListener()` 

IE9以前的版本：

`EventTarget.attachEvent()`

**删除事件**

`EventTarget.removeEventListener()`

IE9以前的版本：

`EventTarget.detachEvent()`

#### DOM事件流

1. 捕获阶段
2. 目标阶段
3. 冒泡阶段

 **addEventListener(type， listener[ ，useCapture])** 

第三个参数

TRUE，即事件捕获阶段调用处理程序。

FALSE，表示事件冒泡阶段调用事件处理程序

#### 事件对象

```javascript
div.addEventLinstener('click', function(e){
 e = e||window.event // 兼容IE6、7、8
 console.log(e)
})
```

常见属性

`event.target`返回**触发**事件对象（元素）

`this.target`返回**绑定**事件对象（元素）

`event.type`返回用户操作

`event.preventDefault()`阻止默认行为

同理：return false 但后续代码默认不执行

**阻止冒泡事件**

`event.stopPropagation()` 

`window.event.cancelBubble = true` 兼容IE6、7、8

#### 事件委托

目的：元素避免多次注册监听事件，只操作一次DOM，提高程序性能

行为：将监听器设置在其父元素，通过事件对象target属性，获取子元素，事件冒泡至父节点，触发事件监听器。

#### 鼠标键盘事件

keypress 

区分键盘大小写 返回不同ASCII码 不识别功能按键

keyup & keydown 不区分大小写

三者触发事件顺序: keydown --- keypress --- keyup

## BOM(Brower Object Model)

页面加载:

```javascript
// 等待页面内容全部加载完,再执行(包括图片,dom元素,css等)
document.addEventLinstener('load', funciton(){});
// 在DOM加载完,直接执行,(图片,dom元素,css等之后再执行)
document.addEventLinstener('DOMContentLoaded', funciton(){});
```

定时器

`setTimeout('回调函数', times);` 调用一次 

`setInterval('回调函数', time)` 循环调用

`clearTimeou(timeID) clearInterval(timeID)`

## 画面交互

### 元素偏移量offset 位置

父元素要有**定位**，否则以body为准(**只读属性**)

`offsetTop || offsetLeft ` 元素相对带定位的父级的偏移值

`offsetWidth || offsetHeight` 元素大小，高宽(padding+border+width);

`offsetParent` 返回带定位的父级元素 

**style**<u>只能获取行内样式表中的样式值</u>

### 元素可视区client 大小

`clientTop || clientLeft` 边框大小

`clientWidth || clentHeight` 元素大小，高宽(padding+**~~border~~**+width);

### 立即执行函数

作用：创建独立作用域，避免命名冲突

```javascript
// 第一种写法 (fun(){})()
(function (params) {
      console.log(params);
    })(param);
// 第二种写法 (fun(){}())
(function (params) {
      console.log(params);
    }(param));
```

**Flexible解析**

### 元素滚动scroll 滚动距离

`scrollTop || scrollLeft` 文字移动、隐藏部分的长度

`scrollWidth || scrollHeight` 元素大小，高宽(padding+**~~border~~**+width);

### 动画函数封装

## 数据存储

生命周期：浏览器窗口的关闭

`sessionStorage.setItem(key, value)`

`sessionStorage.getIemt(key)`

`sessionStorage.removeIemt(key)`

`sessionStorage.clear()`

生命周期永久有效，关闭页面也有效

`localStorage.setItem(key, value)`

`localStorage.getIemt(key)`

`localStorage.removeIemt(key)`

`localStorage.clear()`