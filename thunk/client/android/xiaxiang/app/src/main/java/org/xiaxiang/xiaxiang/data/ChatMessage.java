package org.xiaxiang.xiaxiang.data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gz on 2016/8/10.
 */
public class ChatMessage {

    private URL headPath;
    private String userID;
    private String nickname;
    private String message;
    private String time;
    private Long timeStamp;
    private int unreadCount;
    private List<String> messageList = new ArrayList();

    /*
    public ChatMessage(URL path, String name, String msg, String t, int count) {

    }
    */

    public URL getHeadPath() {
        return headPath;
    }

    public String getUserID() {
        return userID;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setHeadPath(URL path) {
        headPath = path;
    }

    public void setUserID(String ID) {
        userID = ID;
    }

    public void setNickname(String name) {
        nickname = name;
    }

    public void setMessage(String msg) {
        message = msg;
    }

    public void setTime(String t) {
        time = t;
    }

    public void setTimeStamp(Long stamp) {
        timeStamp = stamp;
    }

    public void setUnreadCount(int count) {
        unreadCount = count;
    }

    public void AddMessageToList(String msg){
        messageList.add(msg);
    }
}
