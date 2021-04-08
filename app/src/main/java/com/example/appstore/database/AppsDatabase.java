package com.example.appstore.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {App.class}, version = 1)
public abstract class AppsDatabase extends RoomDatabase
{
	public abstract AppsDao _appsDao();

	private static AppsDatabase INSTANCE;
	private static Object       _lockObject = new Object();

	public static AppsDatabase getInstance(Context context)
	{
		synchronized (_lockObject)
		{
			if (INSTANCE == null)
			{
				INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppsDatabase.class, "new_free_android_apps_database").fallbackToDestructiveMigration().build();
			}
			return INSTANCE;
		}
	}
}
