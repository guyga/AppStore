package com.example.appstore.ui.apps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.appstore.databinding.ItemScreenshotBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ScreenshotsAdapter extends ListAdapter<String, ScreenshotsAdapter.ViewHolder>
{
	public ScreenshotsAdapter()
	{
		super(new DiffCallback());
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		ItemScreenshotBinding binding = ItemScreenshotBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
		return new ViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position)
	{
		holder.bind(getItem(position));
	}

	class ViewHolder extends RecyclerView.ViewHolder
	{
		private final ItemScreenshotBinding _binding;

		public ViewHolder(@NonNull ItemScreenshotBinding binding)
		{
			super(binding.getRoot());
			_binding = binding;
		}

		public void bind(String screenshotPath)
		{
			_binding.setScreenshot(screenshotPath);
			_binding.executePendingBindings();
		}
	}

	static class DiffCallback extends DiffUtil.ItemCallback<String>
	{
		@Override
		public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem)
		{
			return oldItem == newItem;
		}

		@Override
		public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem)
		{
			return oldItem.equals(newItem);
		}
	}
}
