package com.piyushjaiswal121.diary;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.piyushjaiswal121.diary.Task;

@Database(entities = {Task.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();


}
