package com.base.jsonusers;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey
    @NonNull
    private String name;
    private String city;
    private String latitude;
    private String longitude;
    private String companyName;

    public UserEntity(@NonNull String name, String city, String latitude, String longitude, String companyName) {
        this.name = name;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.companyName = companyName;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCompanyName() {
        return companyName;
    }
}
