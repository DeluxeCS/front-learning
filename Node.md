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
- 以命令行工具的形式存在，辅助项目开发(npmjs.com)

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
      console.log('233');
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

