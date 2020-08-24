Fire For Life

**v-if** : 条件渲染=》控制条件块内事件监听器和子组件销毁重建、惰性、 初始渲染false，不渲染，true，渲染
**v-show**：元素渲染、基于CSS的切换

切换开销VS初始渲染开销

**v-for key**

`Vue `: **响应式原理**

`Object.defineProperty() `的get、set实现响应式

new Vue() 初始化内容：

1. 生命周期、事件、传参props、methods、data、computed、watch等

2. `$mount`实现组件挂载，将vue编译后，画面挂载到指定的DOM节点或选择器上。

3. 调用complie()扫描html生成vdom，生成render、update function修改vdom中数据。

   3.1. 更新===依赖收集，收集前parse，获取与mode有关系的view元素

   3.2. 

   | 操作     | 含义                                       |
   | -------- | ------------------------------------------ |
   | parse    | 使用正则解析html中vue指令等、生成AST语法树 |
   | optimiza | 标记静态节点做性能优化，diff中直接略过     |
   | generate | 将AST语法树转换render function             |

   3.3. Dep 和watcher 发布订阅者模式

   - Dep管理watcher

4. Diff算法比较新旧值的不同，得出最小的更新，通过js计算减少页面渲染的次数和数量。

5. 通过patch方法 patchVnode||updateChildren DOM。  

