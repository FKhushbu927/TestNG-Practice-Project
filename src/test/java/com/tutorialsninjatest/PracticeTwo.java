package com.tutorialsninjatest;

import org.testng.annotations.Test;

public class PracticeTwo {

    @Test(priority = 1)
    public void methodOne(){
        System.out.println("Method one of PracticeTwo class");
    }

    @Test(priority = 2)
    public void methodTwo(){
        System.out.println("Method two PracticeTwo class");
    }

    @Test(priority = 3)
    public void methodThree(){
        System.out.println("Method three PracticeTwo class");
    }

    @Test(priority = 4)
    public void methodFour(){
        System.out.println("Method Four PracticeTwo class");
    }
}
