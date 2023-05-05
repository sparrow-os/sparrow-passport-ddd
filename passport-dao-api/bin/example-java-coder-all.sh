config_path=$(pwd)/config.properties
echo $config_path
sh ./sparrow-java-coder.sh -ct com.sparrow.passport.po.User -config=$config_path
