package com.example.bloodlife;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

public class SearchActivity extends FragmentActivity implements SearchResultsFragment.OnUserSelectedListener {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		SearchFragment sFrag = new SearchFragment();
		android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.activity_search, sFrag);
		transaction.addToBackStack(null);
		transaction.commit();
	}
	
	public void performSearch(View v)	{
		
		SearchResultsFragment frag = new SearchResultsFragment();
		
		Spinner spinner = new Spinner(this);
		spinner = (Spinner) findViewById(R.id.spinner_blood_group);
		String bloodGroup = spinner.getSelectedItem().toString(); 
		
		spinner = (Spinner) findViewById(R.id.spinner_city);
		String city = spinner.getSelectedItem().toString();
		
		Bundle bundle = new Bundle();
		bundle.putString(SearchResultsFragment.BLOOD_GROUP, bloodGroup);
		bundle.putString(SearchResultsFragment.CITY, city);
		
		frag.setArguments(bundle);
		
		android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		
		transaction.replace(R.id.activity_search, frag);
		transaction.addToBackStack(null);
		transaction.commit();
		
	}
	
	public void onUserSelected(Users user) {
		
		String full_name = user.getUser().toString();
		String blood_group = user.getBloodGroup().toString();
		String city = user.getCity().toString();
		String phone_number = user.getPhone().toString();
		String last_donated_date = user.getLastDonatedDate().toString();
		String email_id = user.getEmailId().toString();
		
		Log.d("MSG", "Inside onUserSelected - "+ full_name);
		
		Bundle args = new Bundle();
		args.putString(UserDetailsFragment.FULL_NAME, full_name);
		args.putString(UserDetailsFragment.BLOOD_GROUP, blood_group);
		args.putString(UserDetailsFragment.CITY, city);
		args.putString(UserDetailsFragment.EMAIL_ID, email_id);
		args.putString(UserDetailsFragment.PHONE_NUMBER, phone_number);
		args.putString(UserDetailsFragment.LAST_DONATED_DATE, last_donated_date);
		
		UserDetailsFragment userFrag = new UserDetailsFragment();
		userFrag.setArguments(args);
		
		android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.activity_search, userFrag);
		//transaction.addToBackStack(null);
		transaction.commit();
		
		
	}
}