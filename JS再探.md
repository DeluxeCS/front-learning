[TOC]

# JS再探

JS函数执行：

函数包括变量及对变量的操作。

- 初始化：当函数执行，创建一个新的数组,保存变量和参数(当变量或参数是一个对象时，数组保存对象在堆中的地址)

- 执行时：变量数组的执行前具有相同内容、对数据操作时，只需要告知使用第几个（参数）变量即可。

对象在内存中如何保存

1. 使用JSON格式保存
   - 名称（名称的hash值）
   - 值（内存地址）
2. 似C语言的结构体保存
   - 使用偏移量调用
   - 缺点：由于对象属性可随时修改变更，存在不确定性。

function的三种子类型

1. 作为对象

   ```js
   function book();
   book.price = 123;  // 使用 . 操作
   ```

2. 处理业务

3. 创建对象

   ```js
   function Car(color,type){
       this.colort = color;
       this.type = type;
   }
   Car.prototype.newFunction = function(){
       console.log("msg");
   }
   var car = new Car("red","solo");
   ```

   对象的创建

   `Object obj = {};`

   `var obj = Object.create(prototype, propertitesObject)`

   对象的属性

   - 命名数据属性
   - 命名访问器属性（getter/setter）
   - 命名属性（内部属性）

逆向调用apply()&call()

定义：通过方法调用对象

- apply调用参数=>传递数组
- call 调用参数=>按顺序传入

this注解

**谁直接调用方法==this就指向谁**

内存泄漏

# ES6简讲

1. Default Parameters

   `var link = function(a=1,b=2,c='123'){}`

2. Template Literals

   var name = `your name is ${name}`;

3. Multi-line Strings

   ```js
   let roadPoem = `I have just heard
       wonderful things about you.`;
   ```

4. Destructuring Assignment

   ```js
   var body = {
       name:'lee',
       age:23
   };
   var {name:mode1, age:mode2} = body; 
   ```

5. Enhanced Object Literals

   - `Object.create()`继承原型的方法
   - 通过`_proto_`设置属性

6. Arrow Functions

   this指向问题

7. Promise

   ```js
   var waitlOOO = new Promise ((resolve, reject) => {
       setTimeout(resolve , 1000);
   }).then (() => {
       console.log (’ Yay !’);
   }); 
   ```

8. Let & Const

9. Classes

   ```js
   class baseModel { 
       constructor(options,data){
           options={};
           data=[];
           this.name = 'base';
           this.options = options;
           this.data = data;
       }
       getName(){}; // 类方法
   }
   ```

10. Modules