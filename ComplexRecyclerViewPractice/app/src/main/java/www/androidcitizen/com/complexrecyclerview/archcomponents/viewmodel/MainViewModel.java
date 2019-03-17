package www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.DateWithTasks;
import www.androidcitizen.com.complexrecyclerview.repository.AppRepository;


/**
 * Created by Mahi on 08/10/18.
 * www.androidcitizen.com
 */

public class MainViewModel extends AndroidViewModel {

//    private LiveData<List<User>> users;

    private LiveData<List<DateWithTasks>> datesWithTasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository(this.getApplication());

//        users = appRepository.getAllUsers();

        datesWithTasks = appRepository.getAllTasksForAllDates();
    }

//    public LiveData<List<User>> getUsers() {
//        return users;
//    }

    public LiveData<List<DateWithTasks>> getDatesWithTasks() {
        return datesWithTasks;
    }

}
