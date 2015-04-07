package com.wiley.wrox.chapter6.simplenotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReplyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("wrox","got data");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_phone);

        Bundle remoteInput = RemoteInput.getResultsFromIntent(getIntent());
        if(null != remoteInput) {
            TextView text = (TextView) findViewById(R.id.reply_text);
            text.setText(String.format("You replied: %s", remoteInput.getCharSequence(MyActivityPhone.EXTRA_VOICE_REPLY)));
            Log.v("wrox", "User reply from wearable: " + remoteInput.getCharSequence(MyActivityPhone.EXTRA_VOICE_REPLY));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.reply_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}