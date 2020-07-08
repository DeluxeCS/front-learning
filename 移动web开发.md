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

**em**：根据父元素字体大小控制画面布局
**rem**：根据html元素字体大小控制画面布局
*Rem 通过修改html文字大小改变页面元素大小*