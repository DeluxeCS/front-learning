[TOC]

# Javascript

## Object静态方法

Object.prototype.toString() \ \  返回数据的字符串
Object.prototype.toString.**call**(value)方法，判断数据类型

## 对象属性的描述

### 元属性

configurable : false => 用于控制value除外的所有属性的可写性
get()属性定义后，writable=>false,value属性不得定义
enumerable : false 以下三种方式遍历不到:

- for..in 循环
- Object.keys
- JSON.stringify

### 对象拷贝

```javascript
var extend = function (to, from) {
  for (var property in from) {
    if (!from.hasOwnProperty(property)) continue;
    Object.defineProperty(
      to,
      property,
      Object.getOwnPropertyDescriptor(from, property)
    );
  }
  return to;
}
extend({}, { get a(){ return 1 } })
// { get a(){ return 1 } })
```

过滤继承属性

### Array对象

map 方法将数组的所有成员依次传入函数，每次执行的返回结果放到新数组中

```javascript
var arry = [1,2,3,4,5,6,7,8,9];
[1,2,3,4,5].map(function (e){
return this[e];
}, arry)
```

forEach 方法之操作数据

这两种方法都会略过空位

### 包装对象

## 面向对象编程

constarctor and prototype 
构造函数名：首字母大写

### new

use strict 严格模式

### this

**实质探究**：函数体内部，指代函数当前的运行环境
**使用场合**：

- 全局环境下：this === window(顶层对象)

- 构造函数中：this === 实例对象

- 对象方法中：方法运行时所在对象

- 绑定事件中：this === 绑定事件对象

  **ps**
  避免多层 this，指定不一
  避免数组（map.foreach）const vm = this   或  `map(function(){},this)`

### this 切换与绑定

**call()**
`call(target_obj , parameter)`

**apply()**
`apply(target_obj, [array]) `

作用：实现数学内置对象最大小值等

`Math.max.apply(Math, [1, 55, 11, 23])`

**bind()**
bind()每次产生新函数，监听事件，不立即调用原函数
结合回调函数使用

## JavaScript 的原型链继承

*思想* ：原型对象prototype的所有属性和方法，被所实例的对象共享

### 构造函数的继承

#### call()方法

```javascript
function A(x,y){
    consol.log(this); //指向的window
};
var obj1 = {name:'text'};
// 1、调用函数
A.call(this, 1 ,2);
// 2、改变函数的this指向,这是的指向为obj1
A.call(obj1, 1 ,2);
```

#### 子类继承父类的实例及属性

```js
// 父构造函数
function Father(name, age){ 
    this.name = name;  // this指向夫构造函数对象实例
    this.age = age; 
}
function Son(name, age){ 
    // this指向子构造函数对象实例，利用call方法修改this的指向
    Father.call(this, name, age)  
}
```



#### 子类继承父类的原型

```javascript
Son.prototype = Object.create(Father.prototype);
Son.prototype.constructor = Son;
```



### 多重继承 Mixin（混入）

```js
A.call(this);
B.call(this);
C.prototype = Object.create(A.prototype);
// 继承链追加第二个父类
Object.assign(C.prototype, B.prototype)
C.prototype.constructor = C;
```

### Object 对象

- 原型(**prototype**)

  定义：构造函数有prototype属性，指向prototype对象，共通方法定义在其中。

  意义：减少内存空间的调用。

- 对象的原型(__proto__)

  实例对象存在proto方法，指向**prototype**原型对象

- 构造函数(**constructor**)

  实例成员 =>> 通过实例化对象访问

  静态成员 =>> 通过构造函数访问
  
  构造函数**重写**prototype属性：
  
  ```javascript
  demo.prototype = {
      constructor : demo, // construct重新指向原构造函数demo
      test1 : function{},
      test2 : function{}
  }
  ```

#### 拓展内置对象的方法

Array()、List()、String()、Integer()



### 对象的拷贝

```javascript
function copyObject(orig) {
  return Object.create(
    Object.getPrototypeOf(orig),
    Object.getOwnPropertyDescriptors(orig)
  );
}
```

### 闭包

定义：一定作用域可以访问其他作用域的内部变量，变量所在函数就是闭包。

作用：延伸作用域范围。

## 异步操作

### 概述

1. 单线程

2. 同步任务||异步任务

3. 任务队列和事件循环**Event Loop**

4. 异步操作模式

   1. 回调函数 **代码顺序 、简易、高耦合、混乱、单一绑定**
   2. 事件监听 **事件驱动、流程不明、去耦合、多事件绑定**
   3. 发布、订阅(观察者模式) **易于监控**

5. 异步操作流程

   1. 串行执行

      1. ```javascript
         var items = [ 1, 2, 3, 4, 5, 6 ]; // 声明一个数组，程序执行参数
         var results = []; // 每次进行异步操作的执行结果
         
         function async(arg, callback) { //异步操作主函数
           console.log('参数为 ' + arg +' , 1秒后返回结果'); // 打印结果
           setTimeout(function () { callback(arg * 2); }, 1000);
         }
         
         function final(value) { // 最终执行
           console.log('完成: ', value);
         }
         
         function series(item) { // 程序执行顺
           if(item) {
             async( item, function(result) { 
               results.push(result);
               return series(items.shift()); // 执行异步主函数
             });
           } else {
             return final(results[results.length - 1]); // 最终结果执行
           }
         }		
         series(items.shift());
         ```

         

   2. 并行执行

      1.  ```javascript
         items.forEach(function(item) {
           async(item, function(result){
             results.push(result);
             if(results.length === items.length) {
               final(results[results.length - 1]);
             }
           })
         });
         ```

   3. 串并结合

      1. ```javascript
         var items = [ 1, 2, 3, 4, 5, 6 ];
         var results = [];
         var running = 0;
         var limit = 2;
         
         function async(arg, callback) {
           console.log('参数为 ' + arg +' , 1秒后返回结果');
           setTimeout(function () { callback(arg * 2); }, 1000);
         }
         
         function final(value) {
           console.log('完成: ', value);
         }
         
         function launcher() {
           while(running < limit && items.length > 0) {
             var item = items.shift();
             async(item, function(result) {
               results.push(result);
               running--;
               if(items.length > 0) {
                 launcher();
               } else if(running == 0) {
                 final(results);
               }
             });
             running++;
           }
         }
         
         launcher();
         ```

### 定时器

1. setTimeout()
   1. var asyId(定时器编号) = setTimeout(**func**,**delay**)  // 程序在**delay**秒后执行
      clearTimeout(asyId) // 删除定时器
2. setInterval()
   1. var asyId(定时器编号) = setInterval(**func**,**delay**) 
      // 每隔**delay**秒后执行一次，无限次
      clearInterval(asyId) // 删除定时器

**防抖动** debounce函数

#### 应用

1. 整事件的发生顺序
2. 用户自定义的回调函数，通常在浏览器的默认动作之前触发
3. 代码高亮的处理

### Promise对象

Promise  对象、构造函数
设计思想： 所有异步任务都返回一个 Promise 实例。Promise 实例有一个`then`方法，用来指定下一步的回调函数

#### then() 用法辨析

#### 微任务

执行时间 ： **then** >>> **setTImeout(fn, 0)**  then本轮循环结束执行 setTImeout(fn, 0)下轮事件循环开始执行
















