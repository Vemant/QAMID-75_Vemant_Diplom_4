package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class MainPage {
    private final ViewInteraction hospiceLabel = onView(withId(R.id.trademark_image_view));

public MainPage labelVisible() {
    ViewInteraction imageView = hospiceLabel;
    imageView.check(matches(isDisplayed()));
    return new MainPage();
}

//
//    ViewInteraction imageView = onView(
//            allOf(withId(R.id.trademark_image_view),
//                    withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
//                    isDisplayed()));
//        imageView.check(matches(isDisplayed()));
}
