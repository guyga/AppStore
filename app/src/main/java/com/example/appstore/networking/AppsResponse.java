package com.example.appstore.networking;

import com.example.appstore.database.App;

import java.util.List;

public class AppsResponse
{
	private List<App> most_popular_apps;

	public List<App> getMost_popular_apps()
	{
		return most_popular_apps;
	}

	public void setMost_popular_apps(List<App> most_popular_apps)
	{
		this.most_popular_apps = most_popular_apps;
	}
}
