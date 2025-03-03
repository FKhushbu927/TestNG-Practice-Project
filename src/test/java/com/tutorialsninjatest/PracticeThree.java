package com.tutorialsninjatest;

import org.testng.annotations.Test;

public class PracticeThree {

    @Test(priority = 1)
    public void methodOne(){
        System.out.println("Method one of PracticeThree class");
    }

    @Test(priority = 2)
    public void methodTwo(){
        System.out.println("Method two PracticeThree class");
    }
}
