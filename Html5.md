[TOC]

# Html5

## 新增标签

### 语义化标签

header nav article section footer 

### 多媒体标签
audio =>wav ogg mpeg不同浏览器支持不同格式音频

```html
<audio controls='controls' autoplay='autoplay' loop='loop'>
    <source src='xx/xx.mp3' type='audio/mpeg'>
    <source src='xx/xx.ogg' type='audio/ogg'>
    </audio>
```

video => ogg mp4 webm

```html
    <video controls="controls" autoplay="autoplay" loop="loop" muted="muted" poster="../img/0po1en.jpg">
      <source src="../video/section3_bg.mp4" type="video/mp4" />
    </video>
```

### input表单及属性

input表单 type 自带验证功能

# CSS3

## 2D转换

- 移动 translate
- 旋转 rotate
- 缩放 scale

### 移动 translate

修改标签在平面的位置

| X,Y水平，垂直移动     | transform:translate(X,Y)   |
| --------------------- | -------------------------- |
| %相对于自身的像素移动 | transform:translate(X%,Y%) |

translate对**行内**元素无效，**块级**元素有效，不影响其他盒子

### 旋转 rotate

transform:rotate(90deg);
定点旋转：transform-origin: x,y;
动作延时：transition: all 1s;

### 缩放 scale

transform: scale(x,y);缩放X,Y倍
transform: scale(x) 等比例缩放
不影响其他盒子

### 综合性写法

*先写位移，在做其他属性操作*

```css
transform: translate(10px,10px) rotate(90deg) scale(1.5);
```



## 动画部分

定义动画及动画属性

```css
    /*定义关键帧动画,动画序列*/
    @keyframes move {
        0%{/*from*/
            transform: translate(0);
        }to
        100%{/*to*/
            transform: translate(800px,800px);
        }
    }
    /*调用*/
        animation-name: move;
        animation-duration: 3s;
	/*调用简单描述*/
	animation: name duration timing-function delay iteration-count direction fill-mode;

```

| 值                            | 描述                                       |
| :---------------------------- | :----------------------------------------- |
| *[animation-name]*            | 规定需要绑定到选择器的 keyframe 名称。。   |
| *[animation-duration]*        | 规定完成动画所花费的时间，以秒或毫秒计。   |
| *[animation-timing-function]* | 规定动画的速度曲线。**step()**画面展示步数 |
| *[animation-delay]*           | 规定在动画开始之前的延迟。                 |
| *[animation-iteration-count]* | 规定动画应该播放的次数。                   |
| *[animation-direction]*       | 规定是否应该轮流反向播放动画。             |

## 3D转换

### 位移 translate3d(x,y,z)

### 旋转 rotate(x,y,z)

### 透视 perspective

父元素style设置
展示在背景上的投影

### 呈现 transfrom-style

```css
transform-style: preserve-3d; /*代码写给父级影响子盒子*/
```



