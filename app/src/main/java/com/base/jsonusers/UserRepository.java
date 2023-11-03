package com.base.jsonusers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserDao userDao;
    private UserApiService userApiService;
    Context context;

    public UserRepository(UserDao userDao, UserApiService userApiService, Context context) {
        this.userDao = userDao;
        this.userApiService = userApiService;
        this.context = context;
    }

    public LiveData<List<UserEntity>> getAllUsers() {
      return userDao.getAllUsers();
    }

    public void refreshUsers() {
        Call<List<UserInfo>> call = userApiService.getUsers();
        Log.d("UserRepository", "Requesting users from the API");

        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                if (response.isSuccessful()) {
                    List<UserInfo> userInfos = response.body();
                    if (userInfos != null && !userInfos.isEmpty()) {
                        List<UserEntity> userEntities = new ArrayList<>();
                        for (UserInfo info : userInfos) {
                            if (info.getName() != null && info.getAddress() != null && info.getCompany() != null) {
                                userEntities.add(new UserEntity(info.getName(), info.getAddress().getCity(), info.getAddress().getGeo().getLat(), info.getAddress().getGeo().getLng(), info.getCompany().getName()));
                            } else {
                                Log.e("UserRepository", "Invalid data. Skipping");
                            }
                        }
                        insertUsers(userEntities);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                Toast.makeText(context, "Network request failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("UserRepository", "Network request failed: " + t.getMessage());
            }
        });
    }

    private void insertUsers(List<UserEntity> userEntities) {
        Log.d("UserRepository", "Inserting " + userEntities.size() + " users into the database");
        Toast.makeText(context, "Inserting " + userEntities.size() + " users into the database", Toast.LENGTH_SHORT).show();
        new Thread(() -> userDao.insertUser(userEntities)).start();
    }


}
