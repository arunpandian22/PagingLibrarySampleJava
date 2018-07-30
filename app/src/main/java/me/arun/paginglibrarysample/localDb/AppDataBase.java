package me.arun.paginglibrarysample.localDb;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import me.arun.paginglibrarysample.dao.PlayerDao;
import me.arun.paginglibrarysample.model.Player;


@Database(entities = {Player.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase
{
    private static AppDataBase instance;
    public abstract PlayerDao bookDao();

    public static AppDataBase getAppDatabase(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "playerDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    //        .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
}