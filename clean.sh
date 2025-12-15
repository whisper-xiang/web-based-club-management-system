#!/bin/bash

echo "======================================"
echo "项目清理脚本"
echo "======================================"
echo ""

# 停止运行的服务器
echo "1. 停止Jetty服务器..."
pkill -f "jetty:run" 2>/dev/null
echo "   ✅ 完成"

# 清理Maven构建文件
echo ""
echo "2. 清理Maven构建文件..."
mvn clean -q
echo "   ✅ 完成"

# 清理编译的class文件
echo ""
echo "3. 清理编译文件..."
rm -rf WebRoot/WEB-INF/classes/*
find . -name "*.class" -delete
echo "   ✅ 完成"

# 清理系统文件
echo ""
echo "4. 清理系统文件..."
find . -name ".DS_Store" -delete
find . -name "Thumbs.db" -delete
find . -name "*~" -delete
echo "   ✅ 完成"

# 清理日志文件
echo ""
echo "5. 清理日志文件..."
rm -f *.log jetty.log
echo "   ✅ 完成"

# 清理临时文件
echo ""
echo "6. 清理临时文件..."
rm -rf target/tmp
rm -f *.tmp *.bak
echo "   ✅ 完成"

echo ""
echo "======================================"
echo "清理完成！"
echo "======================================"
echo ""
echo "项目已恢复到干净状态，可以重新编译运行。"
echo ""
