package com.example.skullcrush.butterknife;

import android.arch.persistence.room.Insert;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    public void addUser(User user);


}
