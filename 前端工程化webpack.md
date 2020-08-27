[TOC]

# 前端工程化1

## ES6模块化

浏览器、服务器端通用。

每个js文件是独立的模块、导入import、暴露模块成员exports

Nodejs通过**babel**优化ES6模块化

`npm install --save-dev @babel/core @babel/cli @babel/preset-env @babel/node`

`npm install --save @babel/polyfill`

```js
const presets = [
  ["@babel/env",
    { targets: {
        edge: "17",
        firefox: "60",
        chrome: "67",
        safari: "11.1",
      },},],];
module.exports = { presets };

```

`npx babel-node index.js`

### 基本语法

export   import .. from ..

按需导出

`export let s1 = "aaa"`

按需导入

`import {s1 as s2} from "./m1.js"`

直接导入并执行JS代码

`import './min.js'`

## webpack打包工具

优点：

- 友好的模块化支持
- 代码压缩混淆
- js兼容问题处理
- 性能优化

安装

`npm install webpack-cli -D`

### webpack.config.js

```js
module.exports = {
  mode: "development", // "production"
};

```

### package.json

```json
"scripts": {
  "dev": "webpack"
},
```

### `webpack.config.js`的入口和出口

```js
module.exports = {
  mode: "development",
  // 打包入口路径文件
  entry: path.join(__dirname, "./src/index.js"),
  output: {
    // 输出文件路径
    path: path.join(__dirname, "./dist"),
    // 输出文件名称
    filename: "bundle.js",
  },
};
```

### webpack自动打包功能

- `npm install webpack-dev-server -D`

- package.json => script/dev:

  `"dev"："webpack-dev-server"`  //通过npm run 执行

- 修改html中JS的引用路径

ps：

- wepack-dev-server 启动一个实时打包的http服务器
- 打包生成的输出文件、位于根目录下、在内存中、不显示

自动打包相关参数

--open --host --port

`"dev": "webpack-dev-server --open --host 127.0.0.1 --port 8888"`

### webpack 生成预览页面

- `npm i html-webpack-plugin -D`

- 配置文件webpack.config.js

  ```js
  // 导入生成预览页面的插件，得到构造函数
  const HtmlWebpackPlugin = require("html-webpack-plugin");
  // 实力插件对象
  const htmlPlugin = new HtmlWebpackPlugin({
    template: "./src/index.html", // 获取模板
    filename: "index.html", // 指定文件名,但该文件存于内存,不显示
  });
  
  module.exports = {
    // plugins数组是webpackage打包期间用到的插件列表
    plugins: [htmlPlugin],
        };
  ```

### loader协助打包非JS文件

- css

  `npm i style-loader css-loader -D`

  webpack.config.js:

  ```js
  module.exports = { 
  // 所有第三方文件模块的匹配规则,顺序固定,多个loader,从后往前调用
    module: {
      rules: [{ test: /\.css$/, use: ["style-loader", "css-loader"] }],
    },
  };
  ```

- js中高级语法

  `npm i babel-loader @babel/core @babel/runtime -D`

  `npm i @babel/preset-env @babel/plugin-transform-runtime @babel/plugin-proposal-class-properties -D`

  babel.config.js

  ```js
  module.exports = {
    presets: ["@babel/preset-env"],
    plugins: [
      "@babel/plugin-transform-runtime",
      "@babel/plugin-proposal-class-properties",
    ],
  };
  ```

  webpack.config.js

  `{test:/\.js$/,use:'babel-loader',exclude:/node_modules/}`

## Vue单文件组件

传统组件存在问题

- 全局组件命名唯一性
- 字符串模板不能高亮显示
- 不支持CSS
- 没有构建步骤限制，只能使用HEMLandESS javascript 不能使用处理器babel

### 代码示例

```vue
<template>
  <div></div>
</template>
<script>
export default {};
</script>
<style scoped >
</style>
```

### Vue打包需要的loader

`npm i vue-loader vue-template-compiler -D`

webpack.config.js

```js
// 配置VUE加载器
const VueLoaderPlugin = require("vue-loader/lib/plugin");
// plugins数组是webpackage打包期间用到的插件列表
plugins: [htmlPlugin, new VueLoaderPlugin()],
  module: {
    rules: [{ test: /\.vue$/, use: "vue-loader" },],},
```

### webpack项目中使用Vue

`npm i vue -S`

src -> index.js 

```js
import App from "./components/App.vue";
// 导入Vue构造函数
import Vue from "vue"; 
// 创建Vue实例，并指定控制el区域
const vm = new Vue({
  el: "#app",
  // render函数渲染app根组件到指定区域
  render: (h) => h(App),
});
```

### webpack打包发布

package.json->scripts

` "build":"webpack -p"`

### HMR

