//TestNG using the parameter
package com.test.scenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Scenario_07 {

    @Test
    @Parameters({"test1", "test2"}) //name = value
    public void parameterTest(String myName, String myName1) {
        System.out.println("Parameterized value is " + myName + " - " + myName1);
    }

    @Test
    @Parameters({"test3", "test4"})
    public void parameterTest1(String myName, String myName1) {
        System.out.println("Parameterized value is " + myName + " - " + myName1);
    }
}
