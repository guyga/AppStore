package com.example.appstore.networking;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ServerApi
{
	private static final String         BASE_URL = "https://jsonblob.com/";
	private final        AppsApiService _apiService;

	public ServerApi()
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		_apiService = retrofit.create(AppsApiService.class);
	}

	public AppsApiService getApiService()
	{
		return _apiService;
	}

	public interface AppsApiService
	{
		@GET("api/jsonBlob/3656a2ce-37a9-11eb-9cc1-b51d3145a984")
		Call<AppsResponse> getNewFreeAndroidApps();
	}
}
