package com.example.appstore.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface AppsDao
{
	@Query("SELECT * FROM new_free_android_apps_table")
	List<App> getNewFreeAndroidApps();

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void update(List<App> apps);
}
