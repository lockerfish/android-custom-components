package com.lockerfish.exercises.versionview;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        	Using custom view in Java
        */
        // VersionView view = new VersionView(this);
        // setContentView(view);

        /*
        	Using custom view in XML
        	Note: 
        	We can pass style parameters in XML
        	as we'd with TextView. 
        	VersionView extends TextView
        */
        setContentView(R.layout.activity_main);
    }
}
