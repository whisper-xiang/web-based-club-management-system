#!/bin/bash

echo "======================================"
echo "修复Java文件编码问题"
echo "======================================"

# 查找所有Java文件并修复编码
find src -name "*.java" -type f | while read file; do
    # 检测文件编码
    encoding=$(file -b --mime-encoding "$file")
    
    if [ "$encoding" != "utf-8" ] && [ "$encoding" != "us-ascii" ]; then
        echo "修复: $file (当前编码: $encoding)"
        # 转换为UTF-8并移除BOM
        iconv -f GBK -t UTF-8 "$file" > "$file.tmp" 2>/dev/null && mv "$file.tmp" "$file"
    fi
    
    # 移除BOM字符
    if [ -f "$file" ]; then
        sed -i '' '1s/^\xEF\xBB\xBF//' "$file" 2>/dev/null
    fi
done

echo ""
echo "✅ 编码修复完成！"
echo "======================================"
