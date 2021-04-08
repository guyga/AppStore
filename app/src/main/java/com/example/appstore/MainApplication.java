package com.example.appstore;

import android.app.Application;

import com.example.appstore.database.AppsDatabase;
import com.example.appstore.networking.ServerApi;
import com.example.appstore.repository.AppsRepository;
import com.example.appstore.ui.apps.AppsViewModelFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication extends Application
{
	private ExecutorService _executorService;
	private ServerApi       _serverApi;
	private AppsRepository  _appsRepository;
	private AppsDatabase    _appsDatabase;
	private AppSettings _appSettings;

	private AppsViewModelFactory _appsViewModelFactory;

	@Override
	public void onCreate()
	{
		super.onCreate();

		_executorService = Executors.newSingleThreadExecutor();
		_serverApi = new ServerApi();
		_appsDatabase = AppsDatabase.getInstance(this);
		_appSettings = new AppSettings(this, "settings");
		_appsRepository = new AppsRepository(_executorService, _serverApi.getApiService(), _appsDatabase._appsDao(), _appSettings);

		_appsViewModelFactory = new AppsViewModelFactory(_appsRepository);
	}

	public AppsViewModelFactory getAppsViewModelFactory()
	{
		return _appsViewModelFactory;
	}
}
