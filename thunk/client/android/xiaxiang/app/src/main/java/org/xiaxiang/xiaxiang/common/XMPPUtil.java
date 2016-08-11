package org.xiaxiang.xiaxiang.common;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;


public class XMPPUtil
{
    public static XMPPConnection getXMPPConnection(String server, int port)
    {
        try
        {
            ConnectionConfiguration config = new ConnectionConfiguration(
                    server, port);
            config.setReconnectionAllowed(true);
            config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            config.setSendPresence(true); // 状态设为离线，目的为了取离线消息
            SASLAuthentication.supportSASLMechanism("PLAIN", 0);
            XMPPConnection connection = new XMPPTCPConnection(config,
                    null);

            connection.connect();
            return connection;
        }
        catch (Exception e)
        {

        }
        return null;
    }
    public static XMPPConnection getXMPPConnection(String server)
    {
        return getXMPPConnection(server, 5222);
    }

}
