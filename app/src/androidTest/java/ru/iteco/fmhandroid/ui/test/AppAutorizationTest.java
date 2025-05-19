package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.LoginPage;
import ru.iteco.fmhandroid.ui.page.MainPage;

public class AppAutorizationTest {

    LoginPage loginPage;
    MainPage mainPage;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    void setup {
        var loginPage = open("ru.iteco.fmhandroid", LoginPage.class);
    }


    @Test
    public void validLoginValidPasswordTest() {
        MainPage mainPage = loginPage.validLoginPassword();
        //        mainPage = mainPage.labelVisible();
    }
}
