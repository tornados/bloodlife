package com.example.bloodlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {
	final static String REGISTER_SUCCESS_MESSAGE = "Thanks for registering!";
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_register_message, container, false);
	}
	
	public void onStart(){
		super.onStart();
		
		Bundle args = getArguments();
		TextView tv = (TextView) getActivity().findViewById(R.id.display_message);
		String name = args.getString(REGISTER_SUCCESS_MESSAGE);
		tv.setText(name);
	}
}