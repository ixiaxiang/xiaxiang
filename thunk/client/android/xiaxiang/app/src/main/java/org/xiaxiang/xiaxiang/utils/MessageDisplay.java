package org.xiaxiang.xiaxiang.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MessageDisplay
{
	private static final int MESSAGE_TYPE_TOAST = 1;
	
	private static Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
				case MESSAGE_TYPE_TOAST:
					Context ctx = (Context)msg.obj;
					String text = msg.getData().getString("text");
					Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
					break;
			}
		}
		
	};
    public static void showToast(Context ctx, String text)
    {
        Message msg = new Message();
        msg.what = MESSAGE_TYPE_TOAST;
        msg.obj = ctx;
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        msg.setData(bundle);
    	    mHandler.sendMessage(msg);
    }
}
