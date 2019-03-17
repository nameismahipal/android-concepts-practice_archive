package www.androidcitizen.com.complexrecyclerview.archcomponents.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.dao.UserDao;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.Task;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.TaskDate;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;


/**
 * Created by Mahi on 06/10/18.
 * www.androidcitizen.com
 */

@Database(entities = {User.class, TaskDate.class, Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "user_list";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract UserDao userDao();
}
