#javadoc
#-d java-doc-directory \output directory
#-subpackages java-package \ package
#-sourcepath java-src-path \java source path must be full path
#-encoding utf-8
#-charset utf-8
#-private

javadoc -classpath ~/.m2/repository/com/sparrow/sparrow-protocol/1.0-SNAPSHOT/sparrow-protocol-1.0-SNAPSHOT.jar \
-subpackages com.sparrow.user com.sparrow.protocol \
-d ../java-document \
-sourcepath ../src/main/java:\
../../user-protocol/src/main/java:\
/Users/harry/sparrow/sparrow-shell/sparrow-protocol/src/main/java: \
-encoding utf-8 \
-charset utf-8 \
-private
