package org.xiaxiang.xiaxiang.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xiaxiang.xiaxiang.R;

/**
 * Created by gz on 2016/8/8.
 */
public class MessageFragment extends Fragment {

    private ListView messageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    private void initMessageList() {
        messageList = (ListView)getActivity().findViewById(R.id.message_list);
    }
}
