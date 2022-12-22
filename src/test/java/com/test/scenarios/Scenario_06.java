package com.test.scenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario_06 {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{1,5,6}, {2,5,7}, {3,8,9}};
    }

    @Test(dataProvider = "data-provider")
    public void testCase01(int data,int data1,int data2) {
        System.out.println("Data is : " + data);
    }
}
