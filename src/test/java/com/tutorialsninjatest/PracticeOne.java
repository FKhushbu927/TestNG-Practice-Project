package com.tutorialsninjatest;

import org.testng.annotations.Test;

public class PracticeOne {


    @Test(priority = 1)
    public void methodOne(){
        System.out.println("Method one of PracticeOne class");
    }

    @Test(priority = 2)
    public void methodTwo(){
        System.out.println("Method two PracticeOne class");
    }

    @Test(priority = 3)
    public void methodThree(){
        System.out.println("Method three PracticeOne class");
    }
}
