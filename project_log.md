# itimes 开发计划与进度记录

## [todo]
使用aop或注解的方式实现清空或重载缓存
- Item列表首页的展示和实现
- 密码加密
- redis集成，分布式session共享
- 加入针对资源级别的认证

## [done]
【2016.01.24】bower install --save angular-ui-utils
【2016.01.20】- 登录后保存用户id到session
【2016.01.20】- 使用mysql jdbcRealm替换原来的propertiesRealm
    + http://www.iyujian.me/java/shiro-custom-realm-of-authorizing-realm.html
【2016.01.19】- 页面模块：Location、Tags
【2016.01.19】project模块完成
【2016.01.13】- 引入登录认证框架
    + git clone https://github.com/boyazuo/shiro-spring-boot.git
    + http://www.cnblogs.com/LZYY/p/4678749.html
    + http://blog.csdn.net/jadyer/article/details/12208847
    + http://blog.csdn.net/qiuqiupeng/article/details/38984779
    + http://www.infoq.com/cn/articles/apache-shiro
    + http://stackoverflow.com/questions/25241801/how-to-configure-shiro-with-spring-boot
    + http://shiro.apache.org/spring.html
    + https://github.com/qiuqiupeng/wf/blob/master/src/main/java/me/leep/wf/services/system/impl/ShiroRealmImpl.java
    + https://www.ibm.com/developerworks/cn/java/j-lo-shiro/
【2016.01.13】加入精美登录页面
【2016.01.12】加入shiro实现简单页面登录
【2016.01.11】- 定时mvc接口，引入angularjs作为前端应用框架，并实现Item和Category模块的雏形
【2016.01.11】- 使用mybatis配置文件映射实现复杂查询
【2016.01.10】- 定义模型和服务接口，并实现service层业务逻辑
【2016.01.09】- 引入dubbo实现分布式服务和服务的垂直拆分
【2016.01.08】- 使用maven构建项目模块组织
【2016.01.07】- 引入Spring Data jpa和mybatis
【2016.01.06】- 初始项目搭建，使用spring boot搭建初始项目

