package com.example.appstore.ui.apps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.MainApplication;
import com.example.appstore.databinding.FragmentAppsBinding;
import com.example.appstore.database.App;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearSnapHelper;

public class AppsFragment extends Fragment implements AppsAdapter.OnAppClicked
{
	private AppsViewModel _viewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		FragmentAppsBinding binding = FragmentAppsBinding.inflate(inflater);
		_viewModel = new ViewModelProvider(this, ((MainApplication) getActivity().getApplication()).getAppsViewModelFactory()).get(AppsViewModel.class);

		binding.setLifecycleOwner(getViewLifecycleOwner());
		binding.setViewModel(_viewModel);
		binding.appsList.setAdapter(new AppsAdapter(this));
		new LinearSnapHelper().attachToRecyclerView(binding.appsList);

		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		_viewModel.getDisplayAppDetails().observe(getViewLifecycleOwner(), app ->
		{
			if (app != null)
			{
				Navigation.findNavController(getView()).navigate(AppsFragmentDirections.actionAppsFragmentToDetailsFragment(app));
				_viewModel.displayDetailsComplete();
			}
		});
	}

	@Override
	public void onAppClicked(App app)
	{
		_viewModel.displayDetails(app);
	}
}
