[TOC]

# Node.js

why：网站业务逻辑前置。

定义：基于Chrome V8引擎的代码运行环境

组成：ECMAScript + Node模块API

基础语法

## Node.js 模块化开发

js开发弊端：**文件依赖**和**命名冲突**

- node.js规定一个js文件就是一个模块，外部无法访问其内部变量

- 内部对象**export**导出、**require**导入其他模块对象

  ```javascript
  //  已存在js模块a.js
  let version = 1.0;
  const sayHi = name => `hello',${name}`;
  //  向模块外导出数据
  exports.version = version;
  exports.sayHi = sayHi;
  ```

  ```javascript
  // 向b.js模块导入模块a
  let a = require(./a.js);
  // 输出a模块
  console.log(a.version)
  console.log(a.sayHi('test'));
  ```

  **module.exports**为基准

## Node.js 系统模块

### fs：文件操作

```javascript
const fs = require('fs');
// 写入
// 读取
```

### path：系统模块路径

路径拼接

```javascript
const path = require('path');
path.join(' ',' ');
```

相对路径、绝对路径

- 相对路径，相对于当前工作目录
- 读取或设置文件路径，选择绝对路径
- 使用_dirname获取当前文件所在绝对路径

## 第三方模块

定义：多个文件组成

- 以js文件封装API接口
- 以命令行工具的形式存在，辅助项目开发(**npmjs.com**)

下载：npm install 模块名 ==》》》node_modules

卸载：npm uninstall 模块名

### nodemon

定义：辅助开发工具，每次修改不必重新运行网站。

npm install -g(全局) nodemon 

执行：nodemon [your node app]

### nrm

操作：切换下载地址

npm install nrm -g

```shell
$ nrm ls
* npm -----  https://registry.npmjs.org/
  yarn ----- https://registry.yarnpkg.com
  cnpm ----  http://r.cnpmjs.org/
  taobao --  https://registry.npm.taobao.org/
  nj ------  https://registry.nodejitsu.com/
  skimdb -- https://skimdb.npmjs.com/registry
  $ nrm use taobao
```

### Gulp

理解：基于node的前端构建工具，以命令执行以下操作

- HTML、CSS、JS文件压缩
- 语法转换(es6、Less语法识别)
- 公共文件抽离（抽取头部文件，做修改）
- 修改源文件浏览器自动刷新

操作：根目录建立gulpfile.js、dist和src文件

方法：

- gulp.src() 获取任务处理文件

- gulp.dest() 输出文件

- gulp.task() 建立gulp任务

- gulp.watch() 监控文件变化

  ```javascript
  const { src, dest, task } = require('gulp');
  // 建立任务 任务名：first 回调函数：
  task('first', async() => {
      src('./src/css/index.css')
          .pipe(dest('dist/css'));
  })
  // 执行 gulp命令
  gulp 'first'
  ```
  

同名的命令行工具：npm install gulp-cli -g

| gulp部分插件      | 说明                         |
| ----------------- | ---------------------------- |
| gulp-htmlmin      | html文件压缩                 |
| gulp-csso         | css文件压缩                  |
| gulp-babel        | js语法转换**es6=>es5**       |
| gulp-less         | less语法转换                 |
| gulp-uglify       | 压缩混淆js                   |
| gulp-file-include | 从公共文件抽取并插入目标文件 |
| browsersync       | 浏览器实时同步               |

插件下载、导入、应用

```javascript
// 公共代码抽取
// 目标文件压缩
task("third", async () => {
  src("./src/*.html")
    .pipe(fileinclude())
    .pipe(htmlmin({ collapseWhitespace: true }))
    .pipe(dest("dist"));
});
// 目标文件的header位置添加
 @@include('./common/header.html')
// 公共文件
<header><h1>t1</h1></header>
```

**构建任务，依次执行任务列**

```javascript
// 任务名：default时，直接执行gulp =>>> gulp default;
gulp task('default', ['first', 'second', 'third']);
```

### package.json

定义：描述项目名称、作者、版本、git地址等相关信息，管理项目依赖第三方模块。

初始化生成：npm init -y

**项目依赖**：项目运行依赖的第三方模块(**npm install 包名**)

npm install --production (服务器运行环境)

**开发依赖**：类似gulp模块，运行阶段不需要，使用**npm install 包名 --save-dev**命令，将包添加到package.json的devDependencies字段中。

npm install 安装全部依赖

**别名**--程序运行

```json
  "scripts": {
    "test": "jest --coverage",
    "lint": "eslint --fix --ext .ts,.js,.vue --ignore-path .gitignore .",
    "dev": "nuxt",
    "build": "npm-run-all build:*"
    }
npm run dev
npm run build
```

### Node.js模块加载机制

require('./find.js')  由目录查询同名JS文件

require('./find') 

1. 查找同名find文件夹，查询index.js文件
2. 当前文件夹下package.json中main选项的模块入口文件
3. 否则，报错！

require('find') 

1. 假设find为系统模块
2. node_modules文件夹文件夹中
   - 查找同名JS
   - 查找同名JS文件夹
     - 查找index.js文件
     - 查找package.json中main选项的模块入口文件
3. 否则，报错！

## Node.js服务器

### 创建Web Server

```javascript
const http = require("http");  // 模块引用
const app = http.createServer();  // app对象创建网站
app.on("request", (req, res) => {  // 当客户发送请求
  res.end("<h1>hi, user</h1>");
});
app.listen(3000);  // 监听3000端口
console.log("网站服务器创建成功");
```

使用nodemo app.js 实时监听代码

### Http协议

- Request 请求服务器

  1. req.method    **get、post**  请求方式
  2. req.url  请求地址
  3. req.headers  请求报文

- Response 服务器响应

  1. http状态码(200,404,500,400)

  2. 内容类型(text/html、text/css、application/javascript、text/plain):pig::pig::pig:

     ```js
       res.writeHead(200, {"content-type": "text/html;charset=utf-8"});
     ```

### http请求与响应处理

#### GET

  请求路径/请求参数，请参数作为**url**的一部分提交到服务器

  ```js
  const url = require('url'); // 内置模块,处理请求地址
  // query:查询参数对象 pathname：url
  let {query, pathname} =url.parse(req.url, true) // 1.查询参数2.参数解析为对象形式
  console.log(query.name);
  console.log(query.age);
  ```

#### Post

将数据通过表单进行提交，并获取数据

```js
const { parse } = require("querystring"); //将字符串解析为对象
app.on("request", (req, res) => {
  //post 以事件驱动
  let postParams = "";
  // data 请求参数传递，触发data事件
  req.on("data", (param) => {
    postParams += param;
  });
  // end 参数传递结束，触发end事件
  req.on("end", () => {
    console.log(parse(postParams));
  });
  res.end("数据传输结束");
});
```

#### 路由

#### 静态资源 与 动态资源

user请求路径=》》》服务器绝对路径

```javascript
const path = require('path');
// _dirname 当前文件目录的绝对路径
let realPath = path.join(__dirname, url.parse(req.url).pathname);
```

:blue_car::car::carousel_horse:

mime：解析url，获取访问资源类型

```js
const mime = require('mime')  // 第三方模块
let resType = mime.getType(realPath);
res.writeHead(200, {
  "content-type": resType,
});
```

#### 同步API 与 异步API

use **回调函数**，获取return值

Node.js执行顺序：同步代码===》》》异步代码

**Promise**

定义：解决按顺序多次进行异步操作 



