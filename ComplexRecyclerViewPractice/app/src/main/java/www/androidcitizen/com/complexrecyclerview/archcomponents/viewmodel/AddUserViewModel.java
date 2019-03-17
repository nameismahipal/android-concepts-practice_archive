package www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;
import www.androidcitizen.com.complexrecyclerview.repository.AppRepository;


/**
 * Created by Mahi on 08/10/18.
 * www.androidcitizen.com
 */

public class AddUserViewModel extends ViewModel {

    private LiveData<User> user;


    public AddUserViewModel(AppRepository appRepository, int userId) {

        user = appRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }


}
