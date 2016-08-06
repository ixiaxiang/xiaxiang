package org.xiaxiang.xiaxiang.fragment;

import org.xiaxiang.xiaxiang.activity.MainActivity;
import org.xiaxiang.xiaxiang.base.Constant;

import org.xiaxiang.xiaxiang.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactsFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contactsLayout = inflater.inflate(R.layout.contacts_layout,
				container, false);
		return contactsLayout;
	}

	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
		//MainActivity.currFragTag = Constant.FRAGMENT_FLAG_CONTACTS;
	}
	
	
	
}
