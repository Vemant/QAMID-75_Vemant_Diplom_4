package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import java.util.concurrent.TimeoutException;

public class DataHelper {
    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public org.hamcrest.Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> has been displayed during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final org.hamcrest.Matcher<View> matchId = withId(viewId);
                final org.hamcrest.Matcher<View> matchDisplayed = isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

//   public static AuthInfo getValifAuthInfo() {
//        return new AuthInfo("login2", "password2")
//   }

    //    String validLogin = "login2";
//    String validPassword = "password2";


    public static String getValidLogin() {
        return "login2";
    }

    public static String getValidPassword() {
        return "password2";
    }

    public static class AuthInfo {
        String login;
        String password;
    }
}
