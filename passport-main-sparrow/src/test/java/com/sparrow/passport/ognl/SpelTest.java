//package com.sparrow.passport.ognl;
//
//import org.springframework.expression.Expression;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.SpelCompilerMode;
//import org.springframework.expression.spel.SpelParserConfiguration;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//
//public class SpelTest {
//
//    public char isEven(int num) {
//        return num % 2 == 0 ? 'Y' : 'N';
//    }
//
//    /**
//     * <dependency>
//     *             <groupId>org.springframework</groupId>
//     *             <artifactId>spring-expression</artifactId>
//     *             <version>5.2.8.RELEASE</version>
//     *             <scope>test</scope>
//     *         </dependency>
//     * @param args
//     */
//    public static void main(String[] args) {
//        //解析器配置
//        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, SpelTest.class.getClassLoader());
//
//        //表达式，相当于代码
//        String expressionStr = "{1,2,3,4,5,6,7,8,9,10}.![#root.isEven(#this)]";
//
//        //通过配置，创建解析器
//        ExpressionParser expressionParser = new SpelExpressionParser(configuration);
//
//        //解析器,解析表达式（词法-语法)形成语法树
//        Expression expression = expressionParser.parseExpression(expressionStr);
//
//        //把spelTest做为当前运行环境，第一个运行环境，即root。
//        //根据语法树+运行环境，进行语义分析
//        SpelTest spelTest = new SpelTest();
//        Object value = expression.getValue(spelTest);
//        System.out.println(value);
//    }
//}
