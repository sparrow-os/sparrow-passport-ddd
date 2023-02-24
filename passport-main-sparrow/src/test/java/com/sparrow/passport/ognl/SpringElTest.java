//package com.sparrow.passport.ognl;
//
//import java.util.Date;
//import org.springframework.expression.EvaluationContext;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.SpelCompilerMode;
//import org.springframework.expression.spel.SpelParserConfiguration;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.StandardEvaluationContext;
//
//public class SpringElTest {
//    /**
//     * <dependency>
//     * <groupId>org.springframework</groupId>
//     * <artifactId>spring-expression</artifactId>
//     * <version>5.2.8.RELEASE</version>
//     * <scope>test</scope>
//     * </dependency>
//     *
//     * @param args
//     * @throws NoSuchMethodException
//     */
//    public static void main(String[] args) throws NoSuchMethodException {
//        //解析器配置
//        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, SpelTest.class.getClassLoader());
//
//        //表达式，相当于代码
//        String expressionStr = "{1,2,3,4,5,6,7,8,9,10}.![#root.isEven(#this)]";
//
//        //通过配置，创建解析器
//        ExpressionParser parser = new SpelExpressionParser(configuration);
//
//        //访问类型，在java.lang下不用全限定名
//        Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
//        //访问类型，不在java.lang下要全限定名
////        Class<String> result2 = parser.parseExpression("T(cn.javass.spring.chapter5.SpELTest)").getValue(Class.class);
//
////类静态字段访问
//        parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
////类静态方法调用
//        parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
//
////实例化String对象，在java.lang下不用全限定名
//        parser.parseExpression("new String('haha')").getValue(String.class);
////实例化Date对象，不在java.lang下要用全限定名
//        parser.parseExpression("new java.util.Date()").getValue(Date.class);
//
//// instanceof表达式
//        parser.parseExpression("'haha' instanceof T(String)").getValue(boolean.class);
//
//        //变量对象定义
//        EvaluationContext context = new StandardEvaluationContext();
//        context.setVariable("variable", "haha");
//
////变量引用
//        parser.parseExpression("#variable").getValue(context, String.class);
//
////root变量引用
//        parser.parseExpression("#root").getValue(context, String.class);
//
////当前运行对象引用，和java this相似
////当前表达式只在root对象中运行 此时 #this=#root
//        parser.parseExpression("#this").getValue(context, String.class);
//
////@”符号来引用spring Bean, 需要使用BeanResolver查找bean
////        parser.parseExpression("@systemProperties").getValue(context, Properties.class);
//
////对象属性的安全访问，防止car为null.
////用来避免“?.”前边的表达式为null时抛出空指针异常，而是返回null
//        parser.parseExpression("#car?.year").getValue(context, Object.class);
//
////给变量赋值
//        parser.parseExpression("#car='aaaaa'").getValue(context, String.class);
//
//        //自定义函数的2种注册方式
////        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
////        context.setVariable("parseInt2", parseInt);
////        parser.parseExpression("#parseInt('3') == #parseInt2('3')").getValue(boolean.class);
//
////会调用 root对象下的getYear方法
////        parser.parseExpression("getYear()").getValue(context, int.class);
//
////会调用 car对象下的getYear方法
////        parser.parseExpression("#car.getYear()").getValue(context, int.class);
//
//    }
//}
