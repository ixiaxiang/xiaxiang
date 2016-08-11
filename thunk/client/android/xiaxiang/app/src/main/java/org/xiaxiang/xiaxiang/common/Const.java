package org.xiaxiang.xiaxiang.common;

public interface Const
{
    String KEY_USERNAME = "username";
    String KEY_PASSWORD = "password";
    String KEY_LOGIN_SERVER= "login_server";
    String KEY_SAVE_PASSWORD = "save_password";
    String KEY_AUTO_LOGIN = "auto_login";
    String KEY_FACE_ID = "face_id";

    String JID = "jid";                         // 聊天服务ID
    String CHAT_ROOM_NAME = "chat_room_name";   // 聊天室名称

    String FACE_PREFIX = "face";  //  表情图像文件名的前缀
    /***
     * 插在EditText或TextView中的文本的前缀
     */
    String FACE_TEXT_PREFIX = "<:";  //  不要使用正则表达式中使用的符号
    /***
     * 插在EditText或TextView中的文本的后缀，和前缀以及face id一起使用
     * e.g.  (:4)
     */
    String FACE_TEXT_SUFFIX = ":>";
}
