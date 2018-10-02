package com.example.skullcrush.butterknife;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    public void addUser(User user);

    @Query("select *  from users")
    public List<User> getUser();


}
