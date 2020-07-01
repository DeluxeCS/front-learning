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

## <第二章>字符串和正则表达式

### codePointAt()方法

**定义**:支持UTF-16,接受编码单元的位置(非字符位置)作为参数,返回与字符串中给定位置对应的码位,即**整数值**
**目的**:测一个字符占用的编码单元数量

### String.fromCodePoint()方法

定义:指定码位,生成一个字符

### normalize()方法

### 字符串中的子串识别

1. includes()
2. startsWith()
3. endsWith()
4. repeat() 字符串重复拼接

## <第三章>函数

### 函数形参得默认值

```javascript
function(url, name='AJ', age=11, callback = function(){}){
 // 函数体
}
```

ES6.argument对象值与用户传入参数保持一致,不会被改变.

默认参数得临时死区

### 不定参数

函数最多声明**一个**不定参,必须在**末尾**

```javascript
function pick(object, ...keys){}
```

### 增强Function函数

```javascript
var add = new Function('first', 'second = first','return first + second');
```

### 展开运算符

大多数使用apply()方法 ==> 展开运算符方案

```javascript
let values = [-10, -20, -100, -55];
Math.max(...values, 0);
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

### 对象的结构

避免，单独的值的一一对应

```javascript
let node = {
    type: "Identifie",
    name :”foo"
let { type , name } = node ; 
```

## Symbol 及 属性

