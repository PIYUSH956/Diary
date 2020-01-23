package com.piyushjaiswal121.diary;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient mInstace;

    private AppDataBase appDataBase;

    public DatabaseClient(Context context) {
        this.context = context;
        appDataBase = Room.databaseBuilder(context,AppDataBase.class,"MyDailyTask").build();
    }
    public static synchronized DatabaseClient getInstance(Context context)
    {
        if(mInstace == null)
        {
            mInstace = new DatabaseClient(context);
        }
        return mInstace;
    }
    public AppDataBase getAppDataBase()
    {
        return appDataBase;
    }
}
