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

   dataset输一个自定义以data开头的属性的集合。

   

   
