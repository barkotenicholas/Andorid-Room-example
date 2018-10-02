package com.example.skullcrush.butterknife;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {User.class},version = 1)
public abstract class Database extends RoomDatabase
{
    public abstract Dao dao();
}
