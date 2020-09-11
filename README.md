Pipeline: Timelimit Plugin

Extend the Jenkins Pipeline, add the ability to time limit a Stage execution and support
Groovy Closure syntax.

# Quick Start

## 构建Pipeline Timelimit Plugin

```bash
mvn clean package -Dmaven.test.skip=true -Dmaven.javadoc.skip=true
```

## 安装Timelimit Plugin

以管理员账户登陆Jenkins, 进入下面页面进行安装：

```
Manage Jenkins -> Advanced -> Upload Plugin
同时勾选下面选项，让插件安装成功后Jenkins自动重启。
Restart Jenkins when installation is complete and no jobs are running
```

## 更新workflow-lib目录

将新开发的Global
Variables：Timelimit.groovy更新到当前Jenkins主目录下的workflow-libs/vars目录下。
