package www.androidcitizen.com.complexrecyclerview.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.AppDatabase;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.dao.UserDao;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.DateWithTasks;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.Task;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.TaskDate;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;
import www.androidcitizen.com.complexrecyclerview.executor.AppExecutors;

/**
 * Created by Mahi on 06/10/18.
 * www.androidcitizen.com
 */

public class AppRepository {

    private static final String TAG = AppRepository.class.getSimpleName();

    private UserDao userDao;

    public AppRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        userDao = db.userDao();
    }

    public void insertUsers(final List<User> users) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUsers(users);
            }
        });
    }

    public void insertUser(final User user) {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }

    public LiveData<User> getUser(int id) {
        return userDao.getUserById(id);
    }

    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(final User user) {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateUser(user);
            }
        });
    }

    public void insertDateWithTasks(final TaskDate date, final Task task) {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertTaskswithDate(date, task);
            }
        });
    }

    public LiveData<DateWithTasks> getTasksForADate(String zDate) {
        return userDao.getAllTasksforSpecificDate(zDate);
    }

    public LiveData<List<DateWithTasks>> getAllTasksForAllDates() {
        return userDao.getAllTasksForAllDates();
    }


}
