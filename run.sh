#!/bin/bash

echo "======================================"
echo "大学生社团管理系统 - 快速启动"
echo "======================================"
echo ""
echo "正在启动服务器..."
echo "访问地址: http://localhost:8080/ssmd"
echo "管理员账号: hsg / hsg"
echo ""
echo "按 Ctrl+C 停止服务器"
echo "======================================"
echo ""

# 设置UTF-8编码
export JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"
export MAVEN_OPTS="-Dfile.encoding=UTF-8"

# 清理JSP编译缓存
rm -rf target/tmp 2>/dev/null

mvn jetty:run
