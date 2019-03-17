package www.androidcitizen.com.preferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        tv1.setText("CheckBox Value");
        tv2.setText("Switch Value");
        tv3.setText("COLOR");
        tv4.setText("Text Size");

        setupSharedPreferences();
    }

    private void setupSharedPreferences(){

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        // register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        if(sharedPreferences.getBoolean(getString(R.string.checkboxkey), true)){
            tv1.setText("Checkbox set to True;");
        } else if(!sharedPreferences.getBoolean(getString(R.string.checkboxkey), true)){
            tv1.setText("Checkbox set to False;");
        }
        if(sharedPreferences.getBoolean(getString(R.string.switchkey), true)){
            tv2.setText("Switch set to True;");
        } else if(!sharedPreferences.getBoolean(getString(R.string.switchkey), true)){
            tv2.setText("Switch set to False;");
        }

        String zColor = sharedPreferences.getString(getString(R.string.color_list_key), "red");
        setColor(zColor);

        tv4.setTextSize(Float.parseFloat(sharedPreferences.getString(getString(R.string.edittext_key), "12")));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //un-register the listener
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.actions_settings:
                Intent intentStartActivity = new Intent(this, SettingsActivity.class);
                startActivity(intentStartActivity);
                break;
        }
        return true;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        // after new value has been saved to preference file.

        if(key.equals(getString(R.string.checkboxkey)))
        {
            if (sharedPreferences.getBoolean(key, getResources().getBoolean(R.bool.toggle_default_value))) {
                tv1.setText("Checkbox set to True;");
            } else if (!sharedPreferences.getBoolean(key, getResources().getBoolean(R.bool.toggle_default_value))) {
                tv1.setText("Checkbox set to False;");
            }
        }

        if(key.equals(getString(R.string.switchkey)))
        {
            if (sharedPreferences.getBoolean(key, getResources().getBoolean(R.bool.toggle_default_value))) {
                tv2.setText("Switch set to True;");
            } else if (!sharedPreferences.getBoolean(key, getResources().getBoolean(R.bool.toggle_default_value))) {
                tv2.setText("Switch set to False;");
            }
        }

        if(key.equals(getString(R.string.color_list_key))) {

            String zColor = sharedPreferences.getString(getString(R.string.color_list_key), "red");
            setColor(zColor);
        }

        if(key.equals(getString(R.string.edittext_key))){
            tv4.setTextSize(Float.parseFloat(sharedPreferences.getString(key, "12")));
        }

    }

    private void setColor(String zColor){

        if (zColor.equals("red"))
            tv3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
        else if (zColor.equals("green"))
            tv3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
        else if (zColor.equals("blue"))
            tv3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));


    }

}
