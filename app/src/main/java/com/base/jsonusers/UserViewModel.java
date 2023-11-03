package com.base.jsonusers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<UserEntity>> allUsers;
    public UserRepository getUserRepository() {
        return userRepository;
    }
    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = UserDatabase.getDatabase(application);
        UserDao userDao = database.userDao();
        UserApiService userApiService = UserApiService.create();
        userRepository = new UserRepository(userDao, userApiService, application.getApplicationContext());
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return allUsers;
    }
}
