package com.example.bloodlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserDetailsFragment extends Fragment {
	public static String FULL_NAME = "fullname";
	public static String BLOOD_GROUP = "blood_group";
	public static String CITY = "city";
	public static String PHONE_NUMBER = "phone_number";
	public static String EMAIL_ID = "email_id";
	public static String LAST_DONATED_DATE = "last_donated_date";
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstanceState) {
		Log.d("MSG", "Inside onCreateView");
		return inflater.inflate(R.layout.test_layout, container, false);
	}
	
	public void onStart() {
		super.onStart();
		
		
		Bundle args = getArguments();
		
		Log.d("MSG", "Inside onStart"+ args.getString(FULL_NAME));
		
		TextView t;
		t =  (TextView) getActivity().findViewById(R.id.detail_full_name);
		t.setText(args.getString(FULL_NAME));
		
		t = (TextView) getActivity().findViewById(R.id.detail_blood_group);
		t.setText(args.getString(BLOOD_GROUP));
		
		t = (TextView) getActivity().findViewById(R.id.detail_city);
		t.setText(args.getString(CITY));
		
		t = (TextView) getActivity().findViewById(R.id.detail_phone_number);
		t.setText(args.getString(PHONE_NUMBER));
		
		t = (TextView) getActivity().findViewById(R.id.detail_last_donated_date);
		t.setText(args.getString(LAST_DONATED_DATE));
		
		t = (TextView) getActivity().findViewById(R.id.detail_email_id);
		t.setText(args.getString(EMAIL_ID));
		
	}
}