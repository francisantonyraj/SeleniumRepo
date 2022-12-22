package com.test.scenarios;

import org.testng.annotations.Test;

public class Scenario_04 {
    @Test(priority = 2)
    public void testCase01() {
        System.out.println("Test Case 1");
    }
    @Test(priority = 3)
    public void testCase02() {
        System.out.println("Test Case 2");
    }
    @Test(priority = 1)
    public void testCase03() {
        System.out.println("Test Case 3");
    }
}
