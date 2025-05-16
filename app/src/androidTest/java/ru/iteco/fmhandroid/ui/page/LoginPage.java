package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.ui.data.DataHelper.getValidLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.getValidPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoginPage {
    private final ViewInteraction loginField = onView(withHint("Login"));
    private final ViewInteraction passwordField = onView(withHint("Password"));
    private final ViewInteraction loginButton = onView(withId(R.id.enter_button));



//    String validLogin = "login2";
//    String validPassword = "password2";

//    public void test() {
//        onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 5000));
//        loginField.perform(typeText(getValidLogin()));
//        passwordField.perform(typeText(getValidPassword()));
//        loginButton.perform(click());
//    }

    public MainPage validLoginPassword() {
        onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 5000));
        loginField.perform(typeText(getValidLogin()));
        passwordField.perform(typeText(getValidPassword()));
        loginButton.perform(click());
        return new MainPage();
    }
}
