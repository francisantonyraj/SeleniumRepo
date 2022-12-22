package com.test.scenarios;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Scenario_02 {

    @Test(groups = {"SmokeTest"})
    public void execution01() {
        System.out.println("Execution 01");
    }

    @Test
    public void execution02() {
        System.out.println("Execution 02");
    }
}
