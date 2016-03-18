# itimes 开发计划与进度记录

## [todo]

- 加入针对资源级别的认证
- 在虚拟机linux上部署环境和项目
- 聚合报表展示
- 报表下载
- group团队功能

- linux
    + 终端运行 rm -f /var/run/yum.pid 将该文件删除
    + yum install mariadb-server mariadb 
    + systemctl start mariadb
    + mysql -u root -p
    + 方法2：安装mysql：
    + # wget http://dev.mysql.com/get/mysql-community-release-el7-5.noarch.rpm
        # rpm -ivh mysql-community-release-el7-5.noarch.rpm
        # yum install mysql-community-server
    安装成功后重启mysql服务。
    # service mysqld restart
    初次安装mysql，root账户没有密码。
    [root@yl-web yl]# mysql -u root
    设置密码
    mysql> set password for 'root'@'localhost' =password('password');

    配置mysql
    mysql配置文件为/etc/my.cnf
    最后加上编码配置

    远程连接设置
    把在所有数据库的所有表的所有权限赋值给位于所有IP地址的root用户。
    mysql> grant all privileges on *.* to root@'%'identified by 'password';
    如果是新用户而不是root，则要先新建用户

    mysql>create user 'username'@'%' identified by 'password';  
    此时就可以进行远程连接了。

    grant all privileges on *.* to 'root'@'%'identified by 'root';
    flush privileges;

    [mysql]
    default-character-set =utf8


systemctl stop firewalld
systemctl mask firewalld
Then, install the iptables-services package:

yum install iptables-services
Enable the service at boot-time:

systemctl enable iptables
Managing the service

systemctl [stop|start|restart] iptables
Saving your firewall rules can be done as follows:

service iptables save
or

/usr/libexec/iptables/iptables.init save


----
#/sbin/iptables -I INPUT -p tcp --dport 80 -j ACCEPT
#/sbin/iptables -I INPUT -p tcp --dport 22 -j ACCEPT
#/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
#/sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
然后保存：
#/etc/init.d/iptables save


----


最近新装好的mysql在进入mysql工具时，总是有错误提示:
# mysql -u root -p
Enter password:
ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: NO)
或者
# mysql -u root -p password 'newpassword'
Enter password:
mysqladmin: connect to server at 'localhost' failed
error: 'Access denied for user 'root'@'localhost' (using password: YES)' 

现在终于找到解决方法了。本来准备重装的，现在不必了。
方法操作很简单，如下：
# /etc/init.d/mysql stop
# mysqld_safe --user=mysql --skip-grant-tables --skip-networking &
# mysql -u root mysql
mysql> UPDATE user SET Password=PASSWORD('newpassword') where USER='root' and host='root' or host='localhost';//把空的用户密码都修改成非空的密码就行了。
mysql> FLUSH PRIVILEGES;
mysql> quit
# /etc/init.d/mysqld restart
# mysql -uroot -p
Enter password: <输入新设的密码newpassword> 

-------
MySQL服务在启动的时候，不能创建pid文件。

在终端看一下该目录是否存在，果然，不存在。

于是，创建了/var/run/mysqld/目录，重启MySQL服务

[root@spark01 ~]# mkdir -p /var/run/mysqld/

[root@spark01 ~]# /etc/init.d/mysqld start

Starting mysqld (via systemctl):  Job for mysqld.service failed because the control process exited with error code. See "systemctl status mysqld.service" and "journalctl -xe" for details.
                                                           [FAILED]
依旧报错，重新查看告警日志，有以下输出

2016-01-20T10:28:37.183387Z 0 [ERROR] /usr/sbin/mysqld: Can't create/write to file '/var/run/mysqld/mysqld.pid' (Errcode: 13 - Permission denied)
2016-01-20T10:28:37.183431Z 0 [ERROR] Can't start server: can't create PID file: Permission denied
160120 18:28:37 mysqld_safe mysqld from pid file /var/run/mysqld/mysqld.pid ended
160120 18:32:06 mysqld_safe Starting mysqld daemon with databases from /var/lib/mysql
原来，/var/run/mysqld/的属主和属组还是root，mysql并不能在其中创建文件，后修改该目录的属主和属组，启动OK。

[root@spark01 ~]# ls -ld /var/run/mysqld/
drwxr-xr-x 2 root root 40 Jan 20 18:28 /var/run/mysqld/
[root@spark01 ~]# chown mysql.mysql /var/run/mysqld/
[root@spark01 ~]# /etc/init.d/mysqld start
Starting mysqld (via systemctl):    

-------


在迁移vdi文件（拷贝时间较长，耐心等待）时，也需要修改Ubuntu.vbox里的内容，指定vdi的新路径（修改HardDisk一项）。具体操作可以按照 http://www.howtogeek.com/howto/36870/how-to-backup-and-move-virtualbox-machines/ 进行。


----


## [done]
【2016.03.17】- 优化item列表内容
【2016.03.17】- 分开dev和pro环境代码，包括代码和打包编译等
【2016.03.17】- nginx 实现负载均衡、反向代理和静态文件缓存
【2016.03.17】- add nginx
【2016.03.16】- 界面上添加时间字段
【2016.03.16】- 全站细节完善
【2016.03.14】- item页，编辑功能实现
【2016.03.11】- #fff8e7（cosmic Latte）
【2016.03.04】- 邮件激活功能
【2016.03.03】- 添加发送邮件模块，mq模块
【2016.03.02】- 使用redis消息队列作为mq模块
【2016.02.28】巨幕首页
【2016.02.28】- 注册后台功能，并接入前台界面，完成注册功能
【2016.02.26】更换密码加密算法，强化安全
【2016.02.26】跨域session共享实现
【2016.02.24】- redis集成，分布式session共享
    https://github.com/alexxiyang/shiro-redis.git
【2016.02.23】- 密码加密
【2016.02.23】- 配置页面，完善
【2016.02.22】- item页，下一页从加载下一页，改为读取下一页再粘贴再上一页下面
【2016.02.22】- item页，删除功能修复
【2016.02.21】- 注册页，开发 - ok
【2016.02.20】- 使用aop或注解的方式实现清空或重载缓存
【2016.02.20】- Item列表首页的展示和实现
【2016.02.20】- http://www.htmleaf.com/jQuery/Menu-Navigation/201601082998.html
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

