package www.androidcitizen.com.preferencesexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

public class SettingsFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceChangeListener{

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();

        //Setting Summary for List, EditText
        PreferenceScreen ps = getPreferenceScreen();
        int count = ps.getPreferenceCount();
        for(int i = 0; i<count; i++){
            Preference p = ps.getPreference(i);
            if(p instanceof ListPreference){
                String value = sharedPreferences.getString(p.getKey(), "");
                setListPreferenceSummary(p, value);
            } else if(p instanceof EditTextPreference){
                String value = sharedPreferences.getString(p.getKey(), "");
                p.setSummary(value);
            }

        }

    }

    private void setListPreferenceSummary(Preference preference, String value){
        if(preference instanceof ListPreference){
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(value);
            listPreference.setSummary(listPreference.getEntries()[prefIndex]);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        // call back function after new value has been saved to file.
        Preference preference = findPreference(key);
        if(null != preference) {
            if (preference instanceof ListPreference) {
                String value = sharedPreferences.getString(key, "");
                setListPreferenceSummary(preference, value);
            } else if(preference instanceof EditTextPreference){
                String value = sharedPreferences.getString(key, "");
                preference.setSummary(value);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // register the listener
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //un-register the listener
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        // Call back function when value changes on input field

        // Check if the user input is valid.
        if(preference.getKey().equals(getString(R.string.edittext_key))){
            String zString = (String) newValue;

            try {
                float size = Float.parseFloat(zString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                //Toast Message
                return false;
            }

        }
        return true;
    }

}
