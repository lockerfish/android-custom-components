package com.lockerfish.exercises.sidewayslayout;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.lockerfish.exercises.sidewayslayout.MainActivityTest \
 * com.lockerfish.exercises.sidewayslayout.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("com.lockerfish.exercises.sidewayslayout", MainActivity.class);
    }

}
