package org.xiaxiang.xiaxiang.data;

import android.app.Application;

import org.jivesoftware.smack.XMPPConnection;

import java.util.Set;
import java.util.TreeSet;

public class GlobalData extends Application
{
    public XMPPConnection xmppConnection;
    public LoginData loginData = new LoginData();


    public String serviceName;   //  服务名称,聊天时用户名应该加服务名称，格式：user1@servername
    public Set<String> chatUsers = new TreeSet<>();  //  正在聊天的用户
}
