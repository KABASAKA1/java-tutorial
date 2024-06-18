package com.java_javafx_tutorial.functional_programing;

import java.util.function.BinaryOperator;

@FunctionalInterface
interface MathOperations{
    int calculate(int a, int b);
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };
        int result = mathOperations.calculate(10, 20);
        System.out.println(result);

        BinaryOperator<Integer> power = (a,b) -> {
            int sonuc= a;
            for(int x=0;x<b;x++){
                sonuc=sonuc*a;
            }
            return sonuc;
        };
        System.out.println(power.apply(2,4));

        System.out.println("----------------------------");

        MathOperations add = (a,b)->a+b;
        MathOperations subtract = (a,b)->a-b;
        MathOperations multiply = (a,b)->a*b;
        MathOperations divide = (a,b)->a/b;
        System.out.println(multiply.calculate(10,20));
        System.out.println(divide.calculate(10,20));




    }

}
