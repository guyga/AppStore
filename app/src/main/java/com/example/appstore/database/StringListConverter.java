package com.example.appstore.database;

import com.google.gson.Gson;

import java.util.List;

import androidx.room.TypeConverter;

public class StringListConverter
{
	@TypeConverter
	public List<String> fromString(String value)
	{
		return new Gson().fromJson(value, List.class);
	}

	@TypeConverter
	public String fromList(List<String> list)
	{
		return new Gson().toJson(list);
	}
}