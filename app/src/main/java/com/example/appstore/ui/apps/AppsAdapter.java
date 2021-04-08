package com.example.appstore.ui.apps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.appstore.databinding.ItemAppBinding;
import com.example.appstore.database.App;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class AppsAdapter extends ListAdapter<App, AppsAdapter.ViewHolder>
{
	private final OnAppClicked _onAppClicked;

	protected AppsAdapter(OnAppClicked onAppClicked)
	{
		super(new DiffCallback());
		_onAppClicked = onAppClicked;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		ItemAppBinding binding = ItemAppBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
		return new ViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position)
	{
		App app = getItem(position);
		holder.bind(app);
	}

	class ViewHolder extends RecyclerView.ViewHolder
	{
		private final ItemAppBinding _binding;

		public ViewHolder(@NonNull ItemAppBinding binding)
		{
			super(binding.getRoot());
			_binding = binding;
		}

		public void bind(App app)
		{
			_binding.getRoot().setOnClickListener((v) -> _onAppClicked.onAppClicked(app));
			_binding.setApp(app);
			_binding.executePendingBindings();
		}
	}

	public interface OnAppClicked
	{
		void onAppClicked(App app);
	}

	static class DiffCallback extends DiffUtil.ItemCallback<App>
	{
		@Override
		public boolean areItemsTheSame(@NonNull App oldItem, @NonNull App newItem)
		{
			return oldItem == newItem;
		}

		@Override
		public boolean areContentsTheSame(@NonNull App oldItem, @NonNull App newItem)
		{
			return oldItem.getPackage_name().equals(newItem.getPackage_name());
		}
	}
}
