package com.example.appstore.ui.apps;

import com.example.appstore.database.App;
import com.example.appstore.repository.ApiStatus;
import com.example.appstore.repository.AppsRepository;
import com.example.appstore.repository.Result;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class AppsViewModel extends ViewModel
{
	private final AppsRepository _appsRepository;

	private LiveData<List<App>>        _apps;
	private MutableLiveData<ApiStatus> _apiStatus;
	private MutableLiveData<App>       _displayAppDetails;

	public AppsViewModel(AppsRepository appsRepository)
	{
		_appsRepository = appsRepository;

		_apiStatus = new MutableLiveData<>();
		_displayAppDetails = new MutableLiveData<>();
		_apiStatus.postValue(ApiStatus.LOADING);
		_apps = Transformations.map(_appsRepository.getNewFreeAndroidApps(), response ->
		{
			if (response instanceof Result.Success)
			{
				_apiStatus.postValue(ApiStatus.DONE);
				return ((Result.Success<List<App>>) response)._data;
			}
			else
			{
				_apiStatus.postValue(ApiStatus.ERROR);
				return new ArrayList<App>();
			}
		});
	}

	public LiveData<List<App>> getApps()
	{
		return _apps;
	}

	public MutableLiveData<ApiStatus> getApiStatus()
	{
		return _apiStatus;
	}

	public LiveData<App> getDisplayAppDetails()
	{
		return _displayAppDetails;
	}

	public void displayDetails(App app)
	{
		_displayAppDetails.postValue(app);
	}

	public void displayDetailsComplete()
	{
		_displayAppDetails.postValue(null);
	}
}
