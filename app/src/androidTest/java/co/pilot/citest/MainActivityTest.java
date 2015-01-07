package co.pilot.citest;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by adamlastowski on 07.01.15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    Activity mActivity;
    Button mButton;
    TextView mTextView;

    Instrumentation mInstrumentation;


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        mActivity = getActivity();

        mInstrumentation = getInstrumentation();

        mButton = (Button) mActivity.findViewById(R.id.btn_toggle);
        mTextView = (TextView) mActivity.findViewById(R.id.textView);

        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testIfViewsAreInitializedProperly() throws Exception {
        assertNotNull(mButton);
        assertNotNull(mTextView);
    }

    public void testTextViewDisplayingCorrectText() throws Exception {
        assertEquals("Start", mTextView.getText().toString());
    }

    public void testButtonToggleOneTime() throws Exception {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mButton.callOnClick();
            }
        });


        mInstrumentation.waitForIdleSync();

        assertEquals("End", mTextView.getText().toString());
    }
}
