package stepdefinitions;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@regression")
    public void GUIs(){

        System.out.println("Before regressiontag");

    }
}
