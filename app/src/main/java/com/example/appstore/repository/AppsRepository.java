package com.example.appstore.repository;

import com.example.appstore.AppSettings;
import com.example.appstore.database.App;
import com.example.appstore.database.AppsDao;
import com.example.appstore.networking.AppsResponse;
import com.example.appstore.networking.ServerApi;

import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppsRepository
{
	private final ExecutorService          _executorService;
	private final ServerApi.AppsApiService _serverApi;
	private final AppsDao                  _appsDao;
	private final AppSettings              _appSettings;

	public AppsRepository(ExecutorService executorService, ServerApi.AppsApiService serverApi, AppsDao appsDao, AppSettings appSettings)
	{
		_executorService = executorService;
		_serverApi = serverApi;
		_appsDao = appsDao;
		_appSettings = appSettings;
	}

	public LiveData<Result<List<App>>> getNewFreeAndroidApps()
	{
		MutableLiveData<Result<List<App>>> liveData = new MutableLiveData<>();

		_executorService.submit(() ->
		{
			List<App> cachedApps = _appsDao.getNewFreeAndroidApps();
			if (cachedApps != null && !cachedApps.isEmpty() && !_appSettings.shouldUpdateApps())
			{
				liveData.postValue(new Result.Success<List<App>>(cachedApps));
			}
			else
			{
				_serverApi.getNewFreeAndroidApps().enqueue(new Callback<AppsResponse>()
				{
					@Override
					public void onResponse(Call<AppsResponse> call, Response<AppsResponse> response)
					{
						if (response.isSuccessful() && response.body() != null)
						{
							List<App> apps = response.body().getMost_popular_apps();
							_executorService.submit(() -> _appsDao.update(apps));
							_appSettings.setAppsUpdatedTime(System.currentTimeMillis());
							liveData.postValue(new Result.Success<List<App>>(apps));
						}
						else
						{
							liveData.postValue(new Result.Error<List<App>>(new Exception(response.message())));
						}
					}

					@Override
					public void onFailure(Call<AppsResponse> call, Throwable t)
					{
						liveData.postValue(new Result.Error<List<App>>(t));
					}
				});
			}
		});

		return liveData;
	}
}
