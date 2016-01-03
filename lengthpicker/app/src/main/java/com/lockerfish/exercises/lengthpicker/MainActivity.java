package com.lockerfish.exercises.lengthpicker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
// import android.view.View;
// import android.widget.TextView;

public class MainActivity extends Activity {

	// private View mPlusButton;
	// private TextView mTextView;
	// private View mMinusButton;

	// private int mNumInches = 0;

	private LengthPicker mWidth;
	private LengthPicker mHeight;
	private TextView mArea;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWidth = (LengthPicker)findViewById(R.id.width);
        mHeight = (LengthPicker)findViewById(R.id.height);
        mArea = (TextView)findViewById(R.id.area);

        LengthPicker.OnChangeListener listener = new LengthPicker.OnChangeListener() {
        	@Override
        	public void onChange(int length) {
        		updateArea();
        	}
        };

        mWidth.setOnChangeListener(listener);
        mHeight.setOnChangeListener(listener);

    //     mPlusButton = findViewById(R.id.plus_button);
    //     mTextView = (TextView)findViewById(R.id.text);
    //     mMinusButton = findViewById(R.id.minus_button);

    //     updateControls();

    //     View.OnClickListener listener = new View.OnClickListener() {
    //     	public void onClick(View v) {
	   //      	switch (v.getId()) {
	   //      		case R.id.plus_button:
	   //      			mNumInches++;
	   //      			updateControls();
	   //      			break;
	   //      		case R.id.minus_button:
	   //      			if (mNumInches > 0) {
	   //      				mNumInches--;
	   //      				updateControls();
	   //      			}
	   //      			break;
	   //      	}
    //     	}
    //     };

    //     mPlusButton.setOnClickListener(listener);
    //     mMinusButton.setOnClickListener(listener);
    // }

    // private void updateControls() {
    // 	int feet = mNumInches / 12;
    // 	int inches = mNumInches % 12;

    // 	String text = String.format("%d' %d\"", feet, inches);
    // 	if (feet == 0) {
    // 		text.format("%d\"", inches); 
    // 	} else {
    // 		if (inches == 0) {
    // 			text.format("%d'", feet);
    // 		}
    // 	}
    // 	mTextView.setText(text);

    // 	mMinusButton.setEnabled(mNumInches > 0);
    }

    private void updateArea() {
    	int area = mWidth.getNumInches() * mHeight.getNumInches();
    	mArea.setText(area + " sq in");
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	updateArea();
    }

}
