package com.java_javafx_tutorial.event_handle;

public class LamdaExpressionMain {
    static MathOperator add = (int a, int b) -> a + b;
    static MathOperator sub = (int a, int b) -> a - b;
    MathOperator mul = (int a, int b) -> a * b;
    MathOperator div = (int a, int b) -> a / b;

    public static void main(String[] args) {
        System.out.println(add.calculate(3,5));
        System.out.println(sub.calculate(9,1));
    }

}
