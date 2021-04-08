package com.example.appstore.ui.apps;

import com.example.appstore.repository.AppsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AppsViewModelFactory implements ViewModelProvider.Factory
{
	private final AppsRepository _appsRepository;

	public AppsViewModelFactory(AppsRepository appsRepository)
	{
		_appsRepository = appsRepository;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
	{
		if (modelClass.isAssignableFrom(AppsViewModel.class))
		{
			return (T) new AppsViewModel(_appsRepository);
		}
		throw new IllegalArgumentException("Unknown ViewModel Class");
	}
}
