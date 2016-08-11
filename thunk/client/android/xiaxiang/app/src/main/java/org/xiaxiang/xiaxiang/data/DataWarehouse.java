package org.xiaxiang.xiaxiang.data;

import android.content.Context;

import org.jivesoftware.smack.XMPPConnection;

public class DataWarehouse
{
    private static GlobalData mGlobalData;
    
    public static GlobalData getGlobalData(Context ctx)
    {
    	    if(mGlobalData == null)
    	        mGlobalData = (GlobalData) ctx.getApplicationContext();	
    	    	return mGlobalData;    	    
    }
    public static String getServiceName(Context ctx)
    {
        return getGlobalData(ctx).serviceName;
    }
    public static void setServiceName(Context ctx, String serviceName)
    {

        getGlobalData(ctx).serviceName = serviceName;
    }
    public static XMPPConnection getXMPPConnection(Context ctx)
    {
    	
    	    return getGlobalData(ctx).xmppConnection;
    }
    public static void setXMPPConnection(Context ctx,XMPPConnection conn)
    {

    	    getGlobalData(ctx).xmppConnection = conn;
    }
    
    public static boolean isConnected(Context ctx)
    {
    	    return getXMPPConnection(ctx).isConnected();
    }
}
