package org.xiaxiang.xiaxiang.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.xiaxiang.xiaxiang.R;
import org.xiaxiang.xiaxiang.data.ChatMessage;
import org.xiaxiang.xiaxiang.common.Util;
import org.xiaxiang.xiaxiang.utils.TimeString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import java.util.Iterator;
import java.util.List;

/**
 * Created by gz on 2016/8/8.
 */
public class MessageFragment extends ParentFragment implements PacketListener {

    private View view;
    private ListView messageList;
    private List<ChatMessage> chatMessageList;
    private MessageAdapter messageAdapter;
    private PacketFilter mFilter = new MessageTypeFilter(Message.Type.chat);

    // 测试按钮
    private int testnum = 0;
    private Button testButton1;
    private Button testButton2;
    //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        initMessageList();

        test1button();   //测试按钮
        test2button();

        mXMPPConnection.addPacketListener(this, mFilter);

        Log.d("debug:", "create view");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.d("debug:", "resume");

        refreshList();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("debug:", "stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mXMPPConnection.removePacketListener(this);
    }

    private void initMessageList() {
        messageList = (ListView)view.findViewById(R.id.message_list);

        if ( chatMessageList == null ) {
            chatMessageList = getData();
        }

        if ( messageAdapter == null ) {
            messageAdapter = new MessageAdapter(getActivity());
        }

        sortTimeStamp();
        messageList.setAdapter(messageAdapter);
    }

    private void setListListener() {
        messageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private List<ChatMessage> getData() {
        List<ChatMessage> list = new ArrayList<>();

        // 先填入假数据，后续对接

        ChatMessage m1 = new ChatMessage();
        m1.setUserID("000001");
        m1.setNickname("晚饭没吃饱");
        m1.setMessage("试验品...");
        m1.setTime(TimeString.getCurrentHourMinute());
        m1.setTimeStamp(System.currentTimeMillis());
        m1.setUnreadCount(12);
        list.add(m1);

        ChatMessage m2 = new ChatMessage();
        m2.setUserID("000002");
        m2.setNickname("邪王真眼");
        m2.setMessage("Dark flame master....");
        m2.setTime(TimeString.getCurrentHourMinute());
        m2.setTimeStamp(System.currentTimeMillis());
        m2.setUnreadCount(3);
        list.add(m2);

        return list;
    }

    private void sortTimeStamp() {
        Comparator<ChatMessage> itemComparator = new Comparator<ChatMessage>() {
            @Override
            public int compare(ChatMessage c1, ChatMessage c2) {
                return  c1.getTimeStamp() > c2.getTimeStamp() ? -1 : (c1.getTimeStamp() == c2.getTimeStamp() ? 0 : 1 );
            }
        };

        Collections.sort(chatMessageList, itemComparator);
    }

    public void refreshList() {
        sortTimeStamp();
        messageAdapter.notifyDataSetChanged();
    }

    // 静态类UI缓存
    static class ViewHolder {
        public ImageView head;
        public TextView nickname;
        public TextView message;
        public TextView time;
        public TextView count;
    }

    // 内部类MessageAdapter
    private class MessageAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater = null;

        public MessageAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return chatMessageList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if ( converView == null ) {
                converView = layoutInflater.inflate(R.layout.message_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.nickname = (TextView)converView.findViewById(R.id.message_nickname);
                viewHolder.message = (TextView)converView.findViewById(R.id.message_last_content);
                viewHolder.time = (TextView)converView.findViewById(R.id.message_time);
                viewHolder.count = (TextView)converView.findViewById(R.id.message_unread_count);
                converView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)converView.getTag();
            }

            viewHolder.nickname.setText(chatMessageList.get(position).getNickname());
            viewHolder.message.setText(chatMessageList.get(position).getMessage());
            viewHolder.time.setText(chatMessageList.get(position).getTime());
            viewHolder.count.setText(String.valueOf(chatMessageList.get(position).getUnreadCount()));

            return converView;
        }
    }

    // test button 正式接入后会删除
    private void test1button() {
        testButton1 = (Button)view.findViewById(R.id.test_bt1);
        testButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatMessage m = new ChatMessage();
                m.setNickname("测试");
                m.setMessage("测试");
                m.setTime(TimeString.getCurrentHourMinute());
                m.setTimeStamp(System.currentTimeMillis());
                m.setUnreadCount(1);
                chatMessageList.add(0, m);
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    private void test2button() {
        testButton2 = (Button)view.findViewById(R.id.test_bt2);
        testButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "000001";
                for (ChatMessage m : chatMessageList) {
                    if ( m.getUserID() == id ) {
                        int i = m.getUnreadCount();
                        testnum++;
                        m.setMessage("测试："+ testnum + "条");
                        m.setUnreadCount(i + 1);
                        m.setTime(TimeString.getCurrentHourMinute());
                        m.setTimeStamp(System.currentTimeMillis());
                        break;
                    }
                }
                sortTimeStamp();
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            Message message = (Message) msg.obj;
            String user = Util.extractUserFromChat(message.getFrom());
            String body = message.getBody();

            if ( body == null ) {
                return;
            }

            boolean bFounded = false;

            for(Iterator i = chatMessageList.iterator(); i.hasNext();  ){
                ChatMessage chatMsg = (ChatMessage) i.next();

                if (true == chatMsg.getNickname().equals(user)){
                    bFounded = true;

                    if (body.length() > 10){
                        chatMsg.setMessage(body.substring(0, 9));
                    }else{
                        chatMsg.setMessage(body);
                    }

                    chatMsg.setUnreadCount(chatMsg.getUnreadCount() + 1);
                    chatMsg.setTime(TimeString.getCurrentHourMinute());
                    chatMsg.setTimeStamp(System.currentTimeMillis());
                    chatMsg.AddMessageToList(body);
                }
            }

            if (false == bFounded){
                ChatMessage newChatMsg = new ChatMessage();
                newChatMsg.setNickname(user);
                if (body.length() > 10){
                    newChatMsg.setMessage(body.substring(0, 9));
                }else{
                    newChatMsg.setMessage(body);
                }
                newChatMsg.setTime(TimeString.getCurrentHourMinute());
                newChatMsg.setTimeStamp(System.currentTimeMillis());
                newChatMsg.setUnreadCount(1);
                newChatMsg.AddMessageToList(body);
                chatMessageList.add(newChatMsg);
            }

            refreshList();
        }
    };

    @Override
    public void processPacket(Packet packet) throws SmackException.NotConnectedException {
        android.os.Message msg = new android.os.Message();
        msg.obj = packet;

        mHandler.sendMessage(msg);
    }
}
