package com.test.scenarios;

import org.testng.annotations.Test;

public class Scenario_03 {
    @Test
    public void execution03() {
        System.out.println("Execution 01");
    }

    @Test(groups = {"SmokeTest"})
    public void execution04() {
        System.out.println("Execution 02");
    }
}
