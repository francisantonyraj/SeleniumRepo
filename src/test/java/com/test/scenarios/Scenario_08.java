package com.test.scenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario_08 {

    @DataProvider(name = "testData")
    public Object[][] dpMethod() {
        return new Object[][]{{"Ram", 30}, {"Sam", 28}};
    }

    @Test(dataProvider = "testData")
    public void testCase01(String name, int age) {
        System.out.println(name + "=====" + age);
    }
}
