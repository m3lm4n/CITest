package co.pilot.citest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;


public class MainActivity extends ActionBarActivity {
    Button mBtnToggle;
    TextView mTvTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkForCrashes();
        checkForUpdates();

        mBtnToggle = (Button) findViewById(R.id.btn_toggle);
        mTvTarget = (TextView) findViewById(R.id.textView);

        mBtnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTvTarget.getText().toString().equals("Start")){
                    mTvTarget.setText("End");
                } else {
                    mTvTarget.setText("Start");
                }
            }
        });
    }

    private void checkForCrashes() {
        CrashManager.register(this, "6c81de0302e140ef4afd0e1dc17e6490");
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this, "6c81de0302e140ef4afd0e1dc17e6490");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
