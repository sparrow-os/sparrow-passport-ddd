#!/bin/sh

source /etc/profile

[ -z "$SPARROW_CODER_HOME" ] && echo "please config environment variable SPARROW_CODER_HOME" && exit 0

# 生成ddl
# sh coder.sh -ct com.sparrow.passport.po.User
#


class_path=$(cd ../target/classes;pwd)
sparrow_coder_name=sparrow-coder-all.jar

[ -n "$SPARROW_CODER" ] && sparrow_coder_name=$SPARROW_CODER

java -classpath $SPARROW_CODER_HOME/$sparrow_coder_name:$class_path  com.sparrow.coding.Main $@



