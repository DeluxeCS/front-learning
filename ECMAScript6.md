[TOC]

# ECMAScript6

## <第一章> 块级作用于绑定

### 变量提升机制 **Hoisting**

var 声明变量，提升至作用域顶部
let const 声明变量，不提升

### TDZ临时死区

JS 预编译代码，变量（var提升至作用于顶部）（let，const）放到TDZ中，访问TDZ中的变量即报错。
只有let，const声明后，变量从TDZ移除

### 全局块作用域绑定

let const  全局作用域下,重声明已存在变量,**不覆盖全局变量**
var 会发生覆盖

### 循环中的块级作用域

let ,const 在 for-in 和 for-of循环中,每次迭代创建新的绑定.

const 声明变量所在内存地址不可变。基本数据类型不可变，复杂类型内部常量可变。

## <第二章>字符串和正则表达式

### codePointAt()方法

**定义**:支持UTF-16,接受编码单元的位置(非字符位置)作为参数,返回与字符串中给定位置对应的码位,即**整数值**
**目的**:测一个字符占用的编码单元数量

### String.fromCodePoint()方法

定义:指定码位,生成一个字符

### normalize()方法

### 字符串中的子串识别

1. `includes() `

2. `startsWith()`

3. `endsWith()`

4. `repeat() `字符串重复拼接

5. 模板字符串  **`let a = `这是一个模板字符串 ${function(param)}**

   可解析变量

## <第三章>函数

### 函数形参得默认值

```javascript
function(url, name='AJ', age=11, callback = function(){}){
 // 函数体
}
```

ES6.argument对象值与用户传入参数保持一致,不会被改变.

默认参数得临时死区

### 不定参数（剩余参数）

```javascript
// 函数最多声明一个不定参,必须在末尾
function pick(param, ...args[arry]){}
```

### 增强Function函数

```javascript
var add = new Function('first', 'second = first','return first + second');
```

### 扩展运算符

大多数使用apply()方法 ==> 扩展运算符方案

```javascript
let values = [-10, -20, -100, -55];
// ...values => -10, -20, -100, -55
Math.max(...values, 0); // 输出结果为0
// 数组合并
let arry3 = [...arry1, ...arry2];
let arry2.push(...arry1);
// 将伪数组转换为真正的数组
var oDivs = document.getElementByTagName('div');
oDivs = [...oDivs];
```

### name属性

通过函数名称进行调试评估

### 明确函数的多重用途

**[Call]**普通函数调用
**[Construct]**通过new调用函数

新增原属性new.target检测函数调用方式.

### 块级函数提升机制

| *严格模式* | 块级函数          | let函数表达式     |
| ---------- | ----------------- | ----------------- |
| 同         | 执行结束,函数移除 | 执行结束,函数移除 |
| 异         | 提升至顶部        | 不会提升          |

非严格模式,块级函数提升至**外围函数**或**全局作用域顶部**

### 箭头函数

1. 没有this,super,arguments,new.target绑定

   如果使用this，则指向其定义的对象

   **对象不能产生作用域**

2. 不能通过new关键字调用

3. 没有原型,无prototype

4. 不可改变this绑定

5. 不支持argument对象

6. 不支持重复得命名参数

### 尾调用优化

阶乘为例:

```javascript
function factorial(n, p = 1){
    if(n <= 1){
        return 1 * p;
    } else {
     let result = n * p;
    }
    return factorial(n - 1, result);
}
```

## <第四章>扩展对象的功能性

### 对象字面量语法扩展

1. 属性初始值简写
2. 对象方法简写
3. 可计算属性名

### 新增方法

Object.is()方法

Object.assign()方法

### 重复的对象字面量属性

### 自有属性枚举顺序

### 增强对象原型

1. 改变对象原型

   Object.create()创建对象
   Object.getPrototypeOf()   获取指定对象的原型
   Object.setPototypeOf()   修改任意指定对象的原型
   
2. 简化原型访问Super的引用

3. 调用 super.getGreeting()方法相当于在当前上下文中调用 
   Object.getPrototype-Of(this).getGreeting.call(this)

   ### 正式的方法定义

## <第五章>解构

### 对象的解构

避免，单独的值的一一对应

```javascript
let node = {
    type: "Identifie",
    name :"foo"
let { type , name } = node ; 
```

## <第六章>私有变量Symbol 及 属性

定义：每个从`Symbol()`返回的symbol值都是**唯一的**。一个symbol值能作为对象属性的**标识符**；这是该数据类型仅有的目的

创建：不支持`new Symbol()`

```js
let symbol = Symbol(”test symbol"); 
console.log(typeof symbol);  // symbol
```

**Symbol 共享体系**

```js
// 1.全局Symbol注册表检索键：uid Symbol是否存在
// 2.不存在、则创建一个新的Symbol
let uid = Symbol.for("uid");
let obj = {
  [uid]: "123456",
};
// 3.检索存在、直接返回已存在的Symbol
let uid2 = Symbol.for("uid");
console.log(obj[uid2]); // '123456'
```

`Object.getOwnPropertySymbols()`方法的返回值

是一个包含所有 Symbol自有属性的数组

## <第七章>Set && Map

### Set && Weak Set

具有成员唯一性、且为有序列表。

初始化：通过添加数组的形式

数组去重

```js
const set1 = new Set(['a', 'a', 'b', 'b', 'c', 'd']);
const arry = [...set1]; // ['a', 'b', 'c', 'd']
```

取值 

`set1.foreach((value)) => { console.log(value); })`

```js
let set = new Set();  // 不会进行强制类型转换
set.add(5);  // 独立存在
set.add('5'); 
set.has(5);  // true
set.delete(5);
set.clear();
```

**Weak Set 集合**

**强引用Set集合的弊端**：将对象存储-->Set(同存储至变量中)，Set示例中的引用存在，垃圾回收机制无法释放该对象的内存空间。即为**内存泄漏**的情景

WeakSet 构造函数不接受任何原始值，如果数组中包含其他非对象值 程序会抛出错误。

不支持：for-of循环、不暴露任何迭代器、不支持Size属性、不支持forEach()方法。

```js
let set = new WeakSet();  // WeakSet构造函数创建Weak Set集合
key = {}; 
set.add(key);   // 集合 set 中添加对象 
console.log(set.has(key));  //true
set.delete(key); 
console.log(set.has(key)) ; // false
```

### Map && Weak Map

定义：储存着许多键值对的有序列表，key接受任意数据类型，独立存在，不强制转换。

初始化：通过添加数组的形式，内部元素为一个子数组(key，value)形式。

**Weak Map集合**

**键名**必须是一个对象、如果使用非对象键名会报错。

作用：Weak 集合最大的用途是保存 Web 页面中 DOM 元素

```JS
let map = new WeakMap(),
　　element = document.querySelector(".element");
map.set(element, "Original");
let value = map.get(element);
console.log(value); // "Original"
element.parentNode.removeChild(element); // 移除元素
element = null;
// WeakMap集合中的数据也会被同步清除,避免内存泄漏
```

