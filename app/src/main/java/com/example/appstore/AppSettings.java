package com.example.appstore;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings
{
	private SharedPreferences _prefs;

	private static final String APPS_UPDATED_TIME    = "APPS_UPDATED_TIME";
	private static final long   APPS_UPDATE_INTERVAL = 1000 * 60 * 60 * 12; // 12 hours

	public AppSettings(Context context, String settingsName)
	{
		_prefs = context.getSharedPreferences(settingsName, Context.MODE_PRIVATE);
	}

	public boolean shouldUpdateApps()
	{
		boolean shouldUpdate = true;
		long lastUpdated = _prefs.getLong(APPS_UPDATED_TIME, 0);
		if (lastUpdated > 0)
		{
			shouldUpdate = System.currentTimeMillis() > (lastUpdated + APPS_UPDATE_INTERVAL);
		}
		return shouldUpdate;
	}

	public void setAppsUpdatedTime(long timeMillis)
	{
		_prefs.edit().putLong(APPS_UPDATED_TIME, timeMillis).apply();
	}
}
