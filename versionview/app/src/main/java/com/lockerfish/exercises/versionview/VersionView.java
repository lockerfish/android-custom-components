package com.lockerfish.exercises.versionview;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.widget.TextView;
import android.content.Context;


class VersionView extends TextView {
	public VersionView(Context context) {
		super(context);
		setVersion();
	}

	public VersionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setVersion();
	}

	public VersionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setVersion();
	}

	public void setVersion() {
        try {
        	PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(
        		getContext().getPackageName(), 0);
        	setText(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e){
        	/* do nothing */
        }
	}
}