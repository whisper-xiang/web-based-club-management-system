#!/bin/bash

echo "======================================"
echo "数据库初始化脚本"
echo "======================================"
echo ""
echo "请输入MySQL root密码，然后按回车："
echo ""

# 读取密码
read -s MYSQL_PASSWORD

echo ""
echo "正在创建数据库..."

# 创建数据库
mysql -u root -p"$MYSQL_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS ssmdxsstglxthsg4341AWCG DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;" 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✅ 数据库创建成功"
    
    echo ""
    echo "正在导入数据..."
    
    # 导入SQL文件
    mysql -u root -p"$MYSQL_PASSWORD" ssmdxsstglxthsg4341AWCG < database/ssmdxsstglxthsg4341awcg.sql 2>/dev/null
    
    if [ $? -eq 0 ]; then
        echo "✅ 数据导入成功"
        echo ""
        echo "======================================"
        echo "数据库初始化完成！"
        echo "======================================"
        echo ""
        echo "数据库信息："
        echo "  数据库名: ssmdxsstglxthsg4341AWCG"
        echo "  用户名: root"
        echo "  密码: (您刚才输入的密码)"
        echo ""
        echo "如果项目中的数据库密码不是您输入的密码，"
        echo "请修改以下文件中的数据库配置："
        echo "  - src/applicationContext.xml (第21行)"
        echo "  - src/com/util/db.java (第34行)"
        echo ""
    else
        echo "❌ 数据导入失败，请检查SQL文件是否存在"
    fi
else
    echo "❌ 数据库创建失败，请检查MySQL密码是否正确"
fi
