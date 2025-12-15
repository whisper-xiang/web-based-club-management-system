#!/bin/bash

echo "======================================"
echo "大学生社团管理系统 - 启动脚本"
echo "======================================"
echo ""

# 检查MySQL是否运行
echo "1. 检查MySQL服务..."
if ! pgrep -x "mysqld" > /dev/null; then
    echo "   ⚠️  MySQL服务未运行，正在尝试启动..."
    brew services start mysql
    sleep 3
else
    echo "   ✅ MySQL服务正在运行"
fi

# 检查数据库是否存在
echo ""
echo "2. 检查数据库..."
DB_EXISTS=$(mysql -u root -proot -e "SHOW DATABASES LIKE 'ssmdxsstglxthsg4341AWCG';" 2>/dev/null | grep -c "ssmdxsstglxthsg4341AWCG")

if [ "$DB_EXISTS" -eq 0 ]; then
    echo "   ⚠️  数据库不存在，正在创建并导入数据..."
    mysql -u root -proot -e "CREATE DATABASE IF NOT EXISTS ssmdxsstglxthsg4341AWCG DEFAULT CHARACTER SET utf8;" 2>/dev/null
    mysql -u root -proot ssmdxsstglxthsg4341AWCG < database/ssmdxsstglxthsg4341awcg.sql 2>/dev/null
    echo "   ✅ 数据库创建完成"
else
    echo "   ✅ 数据库已存在"
fi

# 编译项目
echo ""
echo "3. 编译项目..."
mvn clean compile -DskipTests

if [ $? -ne 0 ]; then
    echo "   ❌ 编译失败，请检查错误信息"
    exit 1
fi
echo "   ✅ 编译成功"

# 启动服务器
echo ""
echo "4. 启动Web服务器..."
echo "   服务器将在 http://localhost:8080/ssmd 启动"
echo "   默认管理员账号: hsg / hsg"
echo ""
echo "   按 Ctrl+C 停止服务器"
echo "======================================"
echo ""

# 使用Jetty插件启动（兼容Java 17）
mvn jetty:run
