#!/bin/bash

echo "======================================"
echo "用户审核脚本"
echo "======================================"
echo ""

if [ -z "$1" ]; then
    echo "用法: ./approve_user.sh <用户名>"
    echo ""
    echo "示例: ./approve_user.sh test001"
    echo ""
    echo "查看待审核用户:"
    mysql -u root -p123456 ssmdxsstglxthsg4341AWCG -e "SELECT id, yonghuming, xingming, issh FROM yonghuzhuce WHERE issh='否';" 2>/dev/null
    exit 1
fi

USERNAME=$1

echo "正在审核用户: $USERNAME"
echo ""

mysql -u root -p123456 ssmdxsstglxthsg4341AWCG -e "UPDATE yonghuzhuce SET issh='是' WHERE yonghuming='$USERNAME';" 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✅ 用户 $USERNAME 审核成功！"
    echo ""
    echo "该用户现在可以登录了。"
else
    echo "❌ 审核失败，请检查用户名是否正确"
fi

echo ""
echo "======================================"
