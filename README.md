# SpongeTime

## 描述

一个集事件管理，团队看板于一身的小程序

## 框架

目前使用了Struts2，这个项目本来就是以边学习SSH和JSP边写的项目，每学到了新东西就会重构_(:з」∠)_。

## 模块

### 用户模块

#### 基础用户模块

基础用户模块实现日常用户功能（包括普通用户和管理员操作），如下：

 × 用户注册
 × 登陆模块
 × 信息修改
 × 用户管理

#### 用户权限模块

用户权限模块实现用户的权限分级，其中，所有用户分为管理员和普通用户。因此用户权限分为：
 
 × 用户权限
  + 超级管理员
  + 用户

因为涉及到团队看板，允许普通用户创建/管理团队，所以，普通用户可以具有团队内权限分级：

 × 团队权限
  + 团队创建者
  + 团队管理员
  + 团队成员

### 团队模块
 
 #### 超级管理员管理模块
 
 × 团队管理

 #### 团队管理模块

 团队管理模块为使用用户对团队的操作，包括：

 × 创建/解散团队（团队创建者）
 × 团队管理员管理 （团队创建者）
 × 团队信息修改 （管理员及其以上）
 × 团队成员管理 （管理员及其以上）
 × 团队任务管理 （所有人）
 × 团队成员邀请 （所有人）

### 事件模块

 #### 个人事件管理

  × 添加事件
  × 修改事件
  × 完成事件
  × 添加到事件组

 #### 团队事件管理
 
  × 添加事件到事件组
  × 事件组事件任务分配

 团队模块的基础单位是事件组，其他见团队事件组模块。
 
### 事件组

 #### 个人事件组
  
  × 添加事件组
  × 添加事件到事件组
  × 从事件组移除
  × 事件组管理

 #### 团队事件组
  
  × 添加事件组
  × 添加事件到事件组
  × 从事件组移除
  × 事件组管理

### 进度管理模块

 进度管理是统计事件完成情况并给出建议todo顺序列表。

  #### 权重计算模块
   
   根据事件权重（紧急重要，紧急不重要，不紧急重要，不紧急不重要），和事件组完成进度、预期完成时间，重新计算事件权重。
   
  #### 建议todo模块

   根据计算出来的权重，为用户和团队推荐todo顺序列表

## 数据库设计

