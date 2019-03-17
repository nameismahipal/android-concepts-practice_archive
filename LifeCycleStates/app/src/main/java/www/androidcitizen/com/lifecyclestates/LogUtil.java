package www.androidcitizen.com.lifecyclestates;

import android.util.Log;

/**
 * Created by Mahi on 24/06/18.
 * www.androidcitizen.com
 */

public class LogUtil {

    public static void LogAndAppend(String tag, String data){
        tag = tag + " :    ";
        data = data + "\n\n";
        Log.i(tag, data);
    }
}
