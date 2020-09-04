# Enterprise_authority_management_SSM
IDEA工具编码，基于SSM框架（黑马）的企业权限管理系统（前端页面使用了AdminLTE）

# 写在前面
该项目基于SSM框架的后台数据管理系统，实现了：
- 管理员的登陆登出功能
- 基于Spring Security的权限管理功能
- 用户添加功能
- 用户关联角色功能
- 用户信息修改功能
- 用户删除
- 角色添加功能
- 角色信息修改
- 角色删除（受限，若关联有用户）
- 权限添加功能
- 权限修改功能
- 权限删除（受限，若关联有角色）
- 订单管理功能
- 订单详情功能
- 订单修改功能
- 产品管理功能
- 产品修改功能

---

# 项目相关表结构
![tables](https://s1.ax1x.com/2020/09/04/wkn8N8.png)
- Member: 订单会员表
- Orders: 订单表
- order_traveller: 订单线路表
- permission： 权限表
- product: 产品表
- role: 角色表
- role_permission：角色用户关联表
- users: 用户表
- users_role: 用户角色表
- traveller: 线路表


# 项目结构图
## 1. 工程目录结构
![project-stru](https://s1.ax1x.com/2020/09/04/wkC4KO.png)

--- 
## 2. 实体类目录结构
![domain-stru](https://s1.ax1x.com/2020/09/04/wkCADe.png)
---

## 3. dao层目录结构
![dao-stru](https://s1.ax1x.com/2020/09/04/wkCkuD.png)
---

## 4. service层目录结构
![service-stru](https://s1.ax1x.com/2020/09/04/wkCTVH.png)
---

## 5. util层目录结构
![util-stru](https://s1.ax1x.com/2020/09/04/wkCLGt.png)
---

## 6. web层目录结构
![web-stru](https://s1.ax1x.com/2020/09/04/wkPiin.png)
---

# 部署效果图
## 1. 登录界面
![login](https://s1.ax1x.com/2020/09/04/wkCm4I.png)
---

## 2. 登录失败界面
![login-fail](https://s1.ax1x.com/2020/09/04/wkCK8P.png)
---

## 3. 主页面
![main](https://s1.ax1x.com/2020/09/04/wkC1KS.png)
---

## 4. 用户管理界面
![user-manage](https://s1.ax1x.com/2020/09/04/wkCORP.png)
---

## 5. 用户添加角色
![user-add-role](https://s1.ax1x.com/2020/09/04/wkC7ad.png)
---

## 6. 角色管理界面
![role-manage](https://s1.ax1x.com/2020/09/04/wkC5rD.png)
---

## 7. 权限管理界面
![permission-manage](https://s1.ax1x.com/2020/09/04/wkCR8x.png)
---

## 8. 添加用户界面
![new-user](https://s1.ax1x.com/2020/09/04/wkCa80.png)
---

## 9. 添加角色
![new-role](https://s1.ax1x.com/2020/09/04/wkCUCq.png)
---

## 10. 添加权限
![new-permission](https://s1.ax1x.com/2020/09/04/wkCQv8.png)
---

## 11. 产品管理界面 
![product-manage](https://s1.ax1x.com/2020/09/04/wkCW26.png)
---

## 12. 订单管理界面
![order-manage](https://s1.ax1x.com/2020/09/04/wkCwvT.png)
---

## 13. 订单详情界面
![order-detail](https://s1.ax1x.com/2020/09/04/wkCd2V.png)
---
