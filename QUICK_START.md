# 快速开始指南

## ⚡ 5分钟快速启动

### 前提条件
- ✅ JDK 17已安装
- ✅ Maven已安装
- ✅ MySQL已安装并运行

### 步骤1：初始化数据库（1分钟）

```bash
# 创建数据库
mysql -u root -p -e "CREATE DATABASE ssmdxsstglxthsg4341AWCG DEFAULT CHARACTER SET utf8;"

# 导入数据
mysql -u root -p ssmdxsstglxthsg4341AWCG < database/ssmdxsstglxthsg4341awcg.sql
```

### 步骤2：配置密码（30秒）

如果MySQL密码不是 `123456`，修改这3个文件：

```bash
# 1. src/applicationContext.xml (第21行)
<property name="password" value="您的密码"></property>

# 2. src/com/util/db.java (第33行)
public String nmm="您的密码";

# 3. config/configuration.properties (第4行)
jdbc.password=您的密码
```

### 步骤3：启动项目（30秒）

```bash
chmod +x run.sh
./run.sh
```

### 步骤4：访问系统（立即）

打开浏览器：**http://localhost:8080/ssmd/login.jsp**

登录账号：`hsg` / `hsg`

---

## 📝 常用命令

### 启动项目
```bash
./run.sh                    # 推荐方式
mvn jetty:run              # 或使用Maven
```

### 停止项目
```bash
Ctrl + C                   # 在运行窗口按
pkill -f "jetty:run"      # 或强制停止
```

### 清理项目
```bash
./clean.sh                 # 清理所有临时文件
mvn clean                  # 仅清理Maven构建
```

### 重新编译
```bash
mvn clean compile          # 清理并编译
mvn clean package          # 打包WAR文件
```

---

## 🔧 故障排查

### 问题1：端口被占用
```bash
lsof -i :8080              # 查看占用进程
kill -9 <PID>              # 杀死进程
```

### 问题2：数据库连接失败
```bash
# 检查MySQL是否运行
mysql -u root -p

# 检查数据库是否存在
SHOW DATABASES LIKE 'ssmdxsstglxthsg4341AWCG';
```

### 问题3：编译失败
```bash
# 清理后重新编译
mvn clean compile
```

---

## 📂 重要文件位置

| 文件 | 路径 | 用途 |
|------|------|------|
| 数据库配置 | `src/applicationContext.xml` | Spring数据源 |
| 数据库配置 | `src/com/util/db.java` | 工具类配置 |
| 数据库脚本 | `database/ssmdxsstglxthsg4341awcg.sql` | 初始化数据 |
| Maven配置 | `pom.xml` | 依赖管理 |
| Web配置 | `WebRoot/WEB-INF/web.xml` | Servlet配置 |

---

## 🎯 默认账号

| 角色 | 用户名 | 密码 | 说明 |
|------|--------|------|------|
| 管理员 | hsg | hsg | 完整权限 |

---

## 📊 系统信息

- **访问地址**：http://localhost:8080/ssmd
- **端口**：8080
- **上下文路径**：/ssmd
- **数据库**：ssmdxsstglxthsg4341AWCG
- **字符编码**：UTF-8

---

## 🚀 生产部署

### 打包项目
```bash
mvn clean package
```

### 部署到Tomcat
```bash
# 复制WAR文件到Tomcat
cp target/ssmdxsstglxthsg4341awcg.war /path/to/tomcat/webapps/

# 启动Tomcat
/path/to/tomcat/bin/startup.sh
```

### 访问
```
http://服务器IP:8080/ssmdxsstglxthsg4341awcg
```

---

## 📚 更多文档

- **完整文档**：`README.md`
- **升级记录**：`UPGRADE_SUMMARY.md`
- **文件清单**：`PROJECT_FILES.md`

---

**需要帮助？** 查看 `README.md` 的"常见问题"部分！



## 🔑 登录账号

### 前台用户登录
- 地址：http://localhost:8080/ssmd/userlog.jsp
- 测试账号：`006` / `001` 或 `123` / `123`
- 权限：注册用户（查看、报名、评论）

### 后台管理登录
- 地址：http://localhost:8080/ssmd/login.jsp
- 管理员账号：`hsg` / `hsg`
- 权限：完整管理权限

## ⚠️ 新注册用户说明

**新注册的用户需要管理员审核后才能登录！**

### 审核方法1：通过后台管理
1. 使用 `hsg/hsg` 登录后台
2. 进入"用户管理" → "注册用户管理"
3. 找到新用户，点击"审核"

### 审核方法2：使用脚本（快速）
```bash
# 查看待审核用户
./approve_user.sh

# 审核指定用户
./approve_user.sh <用户名>
```
