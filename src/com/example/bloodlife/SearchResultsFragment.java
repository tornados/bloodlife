package com.example.bloodlife;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi") 
public class SearchResultsFragment extends ListFragment {
	OnUserSelectedListener mCallBack;
	
	private UsersDataSource datasource;
	final static String BLOOD_GROUP = "bloodGroup";
	final static String CITY = "city";
	
	
	
	public interface OnUserSelectedListener {
		public void onUserSelected(Users position);
	}
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? 
				android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
		
		
		Bundle args = getArguments();
		
		String conditions = MySQLiteHelper.COLUMN_BLOOD_GROUP + " = '"+ args.getString(BLOOD_GROUP) +"' AND " +
				MySQLiteHelper.COLUMN_CITY+ "= '"+ args.getString(CITY) + "'";
		
		datasource = new UsersDataSource(getActivity());
		datasource.open();
		
		List<Users> users = datasource.getAllUsers(conditions);
		
		ArrayAdapter<Users> adapter = new ArrayAdapter<Users>(getActivity(), layout, users);
		setListAdapter(adapter);
		//setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines));
	}
	
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			mCallBack = (OnUserSelectedListener) activity;
		} catch(ClassCastException e) {
			throw new ClassCastException(activity.toString() +" must implement OnUserSelectedListener");
		}
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		Users user = (Users) getListAdapter().getItem(position);
		int userId = (int) user.getId();
		
		Log.d("msg", "userid = "+userId);
		
		mCallBack.onUserSelected(user);
	}
	
	 public void onStart() {
	        super.onStart();
	    }
}