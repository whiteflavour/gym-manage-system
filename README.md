# This is a simple gym manage system.

It's based on [这位大佬的博客项目](https://github.com/Mitsuha666/blog) (using this code, and do some changes on it)

注：本项目借用上述大佬的代码，在其中做修改，将功能改成符合自身需求的功能，以此做成本科毕业设计代码。

# 使用技术：

前端：

- Senmatic UI
- Thymeleaf

后端：

- Spring Boot
- MyBatis

数据库：

- MySQL

# 系统结构介绍：

本系统分为用户端和管理员端，用户端可直接访问，而管理员端则需要登录账号才能使用。
具体使用方法见*使用教程*。

# 系统功能介绍：

用户端：

- 健身课程浏览
- 教练浏览
- 通知浏览
- 评论浏览
- 评论发布

管理员端：

- 课程管理
- 教练管理
- 通知管理
- 评论管理

更详细的功能请自行运行项目查看，由于希望将系统功能尽量保持简单，所以请不要抱太大希望。

# 使用教程：

1. 建好项目，创建好数据库
2. 运行项目
3. 浏览器输入网址：<localhost:8080> 访问用户端
4. 浏览器输入网址：<localhost:8080/admin> 访问管理员端