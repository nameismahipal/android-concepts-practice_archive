package www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import www.androidcitizen.com.complexrecyclerview.repository.AppRepository;

/**
 * Created by Mahi on 08/10/18.
 * www.androidcitizen.com
 */

public class AddUserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    AppRepository appRepository;
    int userId;

    public AddUserViewModelFactory(AppRepository appRepository, int userId) {
        this.appRepository = appRepository;
        this.userId = userId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddUserViewModel(appRepository, userId);
    }
}
