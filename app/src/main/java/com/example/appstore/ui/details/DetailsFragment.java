package com.example.appstore.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.database.App;
import com.example.appstore.databinding.FragmentDetailsBinding;
import com.example.appstore.ui.apps.ScreenshotsAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailsFragment extends Fragment
{
	private DetailsViewModel _viewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		FragmentDetailsBinding binding = FragmentDetailsBinding.inflate(inflater);
		_viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
		App app = DetailsFragmentArgs.fromBundle(getArguments()).getApp();

		binding.setLifecycleOwner(getViewLifecycleOwner());
		binding.setApp(app);
		binding.screenshots.setAdapter(new ScreenshotsAdapter());
		return binding.getRoot();
	}
}
