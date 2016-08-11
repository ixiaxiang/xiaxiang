package org.xiaxiang.xiaxiang.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Storage
{

	private final static String STORAGE_FILE_NAME = "aspark.config";

	public static void putString(Context ctx, String key, String value)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		sharedPreferences.edit().putString(key, value).commit();
	}
	public static void putInt(Context ctx, String key, int value)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		sharedPreferences.edit().putInt(key, value).commit();
	}
	public static void putBoolean(Context ctx, String key, boolean value)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		sharedPreferences.edit().putBoolean(key, value).commit();
	}
	
	public static String getString(Context ctx, String key, String... defaultValue)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		String dv = "";
		for(String v: defaultValue)
		{
			dv = v;
			break;
		}
		return sharedPreferences.getString(key, dv);
	}
	public static int getInt(Context ctx, String name, int... defaultValue)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		int dv = 0;
		for(int v: defaultValue)
		{
			dv = v;
			break;
		}
		return sharedPreferences.getInt(name, dv);
	}
	public static boolean getBoolean(Context ctx, String name, boolean... defaultValue)
	{
		SharedPreferences sharedPreferences = getSharedPreferences(ctx);
		boolean dv = false;
		for(boolean v: defaultValue)
		{
			dv = v;
			break;
		}
		return sharedPreferences.getBoolean(name, dv);
	}
	
	private static SharedPreferences getSharedPreferences(Context ctx)
	{
		return ctx
				.getSharedPreferences(STORAGE_FILE_NAME, Context.MODE_PRIVATE);
	}
}
