package www.androidcitizen.com.lifecyclestates;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Mahi on 26/06/18.
 * www.androidcitizen.com
 */

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        LogUtil.LogAndAppend(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.LogAndAppend(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.LogAndAppend(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.LogAndAppend(TAG, "onSaveInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.LogAndAppend(TAG, "onSaveInstanceState , Bundle");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.LogAndAppend(TAG, "onRestoreInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        LogUtil.LogAndAppend(TAG, "onRestoreInstanceState, Bundle");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.LogAndAppend(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.LogAndAppend(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.LogAndAppend(TAG, "onDestroy");
    }


}
