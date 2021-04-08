package com.example.appstore.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.appstore.R;
import com.example.appstore.database.App;
import com.example.appstore.repository.ApiStatus;
import com.example.appstore.ui.apps.AppsAdapter;
import com.example.appstore.ui.apps.ScreenshotsAdapter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class UIBindingAdapter
{
	@androidx.databinding.BindingAdapter("appsList")
	public static void bindAppsList(RecyclerView recyclerView, List<App> apps)
	{
		((AppsAdapter) recyclerView.getAdapter()).submitList(apps);
	}

	@androidx.databinding.BindingAdapter("apiProgress")
	public static void bindApiProgress(View view, ApiStatus apiStatus)
	{
		if (apiStatus != null)
		{
			switch (apiStatus)
			{
				case LOADING:
				{
					view.setVisibility(View.VISIBLE);
				}
				default:
				{
					view.setVisibility(View.GONE);
				}
			}
		}
	}

	@androidx.databinding.BindingAdapter("imgContent")
	public static void bindImgContent(ImageView imageView, String path)
	{
		Glide.with(imageView.getContext())
				.load(path)
				.apply(new RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
				.into(imageView);
	}

	@androidx.databinding.BindingAdapter("textContent")
	public static void bindTextContent(TextView textView, String title)
	{
		textView.setText(title);
	}

	@androidx.databinding.BindingAdapter("containAds")
	public static void bindContainAds(TextView textView, boolean containsAds)
	{
		if (containsAds)
		{
			textView.setText(textView.getResources().getString(R.string.contains_ads));
			textView.setVisibility(View.VISIBLE);
		}
		else
		{
			textView.setVisibility(View.GONE);
		}
	}

	@androidx.databinding.BindingAdapter("screenshots")
	public static void bindScreenshots(RecyclerView recyclerView, List<String> screenshots)
	{
		((ScreenshotsAdapter) recyclerView.getAdapter()).submitList(screenshots);
	}
}
