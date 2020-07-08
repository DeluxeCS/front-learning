[TOC]

# 移动web开发

## Flex流式布局

视口：布局视口、视觉视口、理想视口

layout viewport ：PC端页面尺寸，在移动端显示分辨率不一致
visual viewport ：显示内容
idea viewport ：满足用户的舒适度<mate>视口标签

### 二倍图

物理像素：屏幕上真实存在的最小像素颗粒

物理像素比：1px与其能够显示物理像素个数的比例

**目的**：解决图片放大模糊

**方法**：画面展示的图片，是实际需要的两倍

## 移动端常见布局

### 流式布局（百分比布局）

### Flex布局

*布局原理*
移动端应用广泛、PC端浏览器支持性差、任何一个容器均可使flex、为父容器添加flex控制子元素属性

| 父项常见属性                                | 默认值                                                       |
| ------------------------------------------- | ------------------------------------------------------------ |
| flex-direction(定义**主轴**方向)            | row \| row-reverse \| column \| column-reverse               |
| justify-content(主轴**子元素**排列方式)     | flex-start \| flex-end \| center \| space-around \| space-between(先两边在中间均分) |
| flex-wrap(子元素是否换行)                   | nowrap(默认) \| wrap                                         |
| align-items(侧轴子元素排列方式)**单行**     | flex-start \| flex-end \| center \| stretch(拉伸)            |
| align-content(侧轴子元素排列方式)**多行**   | flex-start \| flex-end \| center \| stretch(拉伸) \| space-around \| space-between |
| flex-flow**复合**(flex-direction,flex-wrap) | flex-flow: column wrap;                                      |

**子项目flex属性**
flex属性子项目分配剩余空间，占用多少份数。

align-侧轴上下移动给

order 画面行级排序 默认0

### Rem 适配布局

定义：

**em**：根据父元素字体大小控制画面布局

**rem**：根据html元素字体大小控制画面布局

*Rem 通过修改html文字大小改变页面元素大小*

#### 媒体查询(Media Query)

@media查询，媒体类型，设备决定画面样式布局

```css
@media all|screen and|not|only (width|max-width(<=)|min-width(>=): 900px) {
    body{
        background-color:green;
    }
}
```

*媒体查询+rem*：元素大小动态变化

*引入资源*：link

```css
 <link rel="stylesheet" href="#.css" media="screen and (max-width: 320px)">
 <link rel="stylesheet" href="#.css" media="screen and (min-width: 540px)">
```

#### less基础

Less 是一门 CSS 预处理语言，它扩展了 CSS 语言，增加了变量、Mixin(混入)、函数等特性，使 CSS 更易维护和扩展。
Less 可以运行在 Node 或浏览器端。
编译：使用easy less等插件儿

*less嵌套*

子元素样式直接在父元素**内部**编写

交集|伪类选择器(:hover)|伪元素(::before|::after) 需要添加特殊字符**&**

*less运算*

参数运算，单位不同，以第一个值的单位为准

#### Rem适配方案

1. html根标签的font-size的大小(媒体查询)
2. CSS中宽，高相对位置，按同等比例换算rem为单位的值
3. 做成(*1-2*)套即可默认750px

*less+媒体查询+rem*

方案：

- 设计稿750px
- 屏幕分为**15**等份(淘宝是*10*等份)
- html的**font-size**就是**50px**(淘宝：75px)
- 100px * 100px像素下，100/50 rem 即  2rem * 2rem 
- 大小等比例缩放
- 页面元素rem值：页面元素 **/** 750像素下px值 **/** html的font-size值

*flexible.js+rem*



