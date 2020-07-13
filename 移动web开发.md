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

**方法**：实际大小是画面尺寸的两倍

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
补充说明：
max-width意思是，当前画面宽度最大是这个数，展示函数体内的CSS效果，如果超出即另作操作
min-width意思是，当前画面最小宽度是这个数，展示------
a <= x <=b CSS覆盖重写原则*媒体查询+rem*：元素大小动态变化

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

- 内部划分为**10**等分
- 设置html的font-size即可

工具：cssrem 

1. 修改默认值(fontsize：16px)为设计稿值

2. 当前画面过大，@media修改画面值为设计稿值

   ```css
   @media screen and (min-width:750px){
       html{
           font-size: 75px!important;
       }
   }
   ```

   

### 响应式布局

原理：

通过媒体查询进行布局

| 设备划分         | 尺寸区间           | 相应布局尺寸  |
| ---------------- | ------------------ | ------------- |
| 超小屏(手机端)   | <768px             | width：100%   |
| 小屏(平板)       | >=768px    <992px  | width：750px  |
| 中屏(显示器)     | >=992px    <1200px | width：970px  |
| 宽屏(大屏显示器) | >=1200px           | width：1170px |

父级的布局容器，控制子级显示效果

父级container变化，影响画面布局

```css
 /*媒体查询*/
        @media screen and (max-width: 767px) {
            .contaier {
                width: 100%;
            }
            .contaier ul li {
                width: 33.33%;
            }
        }
```

### Bootstrap前端开发框架

实装：Bootstrap是通过class属性控制画面样式

```css
<button type="button" class="btn btn-danger">（危险）Danger</button>
<div class="btn btn-danger">（危险）Danger</div>
```

可以覆盖重新原样式，注意权重问题。

#### 布局容器

1. 预定义container类，将媒体查询的尺寸设置好

   | container类                       | container-fluid类      |
   | --------------------------------- | ---------------------- |
   | 响应式布局，固定**宽度**          | 流式布局容器  宽度100% |
   | 大屏(>=1200px) \|\|\| 宽度 1170px | 占据全部视口的容器     |
   | 中屏(>=992px) \|\|\| 宽度 970px   | 单独做移动端开发       |
   | 小屏(>=768px) \|\|\| 宽度 750px   |                        |
   | 超小屏(100%)                      |                        |

#### 栅格系统

**定义**

页面内容均分若干等列(container=>>最多12列)

**参数**

1. 通过“行（row）”在水平方向创建一组“列（column）”。

2. |                           | **超小屏幕** 手机 (<768px) | **小屏幕** 平板 (≥768px) | **中等屏幕** 桌面显示器 (≥992px) | **大屏幕** 大桌面显示器 (≥1200px) |
   | :------------------------ | :------------------------- | :----------------------- | :------------------------------- | --------------------------------- |
   | **栅格系统行为**          | 总是水平排列               | 开始是堆叠在一起的       | 当大于这些阈值时将变为水平排列C  | ...                               |
   | **`.container` 最大宽度** | None （自动）              | 750px                    | 970px                            | 1170px                            |
   | **类前缀**                | `.col-xs-`                 | `.col-sm-`               | `.col-md-`                       | `.col-lg-`                        |

3. **槽（gutter）宽** :30px （每列左右均有 15px）

4. 为同一个元素设置不同的设备类

**列嵌套**

已分配的列,划分为12等列.为子元素分配时,添加行**row**类

- 取消父元素的padding值
- 将高度设置与父级一致

**列偏移**

`.col-md-offset-*` 类可以将列向右侧偏移

`.col-md-offset-4` 类将 `.col-md-4` 元素向右侧偏移了4个列（column）的宽度。

**列排序**

`.col-md-push-*` 和 `.col-md-pull-*` 类 改变列（column）的顺序。

**响应式工具**

以针对不同屏幕尺寸隐藏或显示页面内容

|                 | 超小屏幕手机 (<768px) | 小屏幕平板 (≥768px) | 中等屏幕桌面 (≥992px) | 大屏幕桌面 (≥1200px) |
| :-------------- | :-------------------- | :------------------ | :-------------------- | -------------------- |
| `.visible-xs-*` | **可见**              | 隐藏                | 隐藏                  | 隐藏                 |
| `.visible-sm-*` | 隐藏                  | **可见**            | 隐藏                  | 隐藏                 |
| `.visible-md-*` | 隐藏                  | 隐藏                | **可见**              | 隐藏                 |
| `.visible-lg-*` | 隐藏                  | 隐藏                | 隐藏                  | **可见**             |
| `.hidden-xs`    | **隐藏**              | 可见                | 可见                  | 可见                 |
| `.hidden-sm`    | 可见                  | **隐藏**            | 可见                  | 可见                 |
| `.hidden-md`    | 可见                  | 可见                | **隐藏**              | 可见                 |
| `.hidden-lg`    | 可见                  | 可见                | 可见                  | **隐藏**             |

清除浮动：clearfix