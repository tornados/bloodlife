package com.example.bloodlife;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends FragmentActivity {
	
	private UsersDataSource datasource;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_main);
		
		if(findViewById(R.id.activity_register_main)!=null){
			if(savedInstanceState != null) {
				return;
			}
			
			RegisterFragment register = new RegisterFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.activity_register_main, register).commit();
			
		}
		
		datasource = new UsersDataSource(this);
		datasource.open();
	}
	
	
	public void onRegisterSubmit(View view){
		
    	Users user = null;
		
		EditText et = (EditText) findViewById(R.id.full_name);
    	String name = et.getText().toString();
    	
    	Spinner sp = (Spinner) findViewById(R.id.spinner_blood_group);
    	String bg = sp.getSelectedItem().toString();
    	
    	sp = (Spinner) findViewById(R.id.spinner_city);
    	String city = sp.getSelectedItem().toString();
    	
    	et = (EditText) findViewById(R.id.phone_number);
    	String phone = et.getText().toString();
    	
    	et = (EditText) findViewById(R.id.last_donated_date);
    	String last_donated_date = et.getText().toString();
    	
    	et = (EditText) findViewById(R.id.email_id);
    	String email_id = et.getText().toString();
    	
    	user = datasource.createUser(name, bg, phone, email_id, city, last_donated_date);
    	
    	MessageFragment msg = new MessageFragment();
    	Bundle args = new Bundle();
    	
    	args.putString(MessageFragment.REGISTER_SUCCESS_MESSAGE, "Thankyou "+user.getUser()+", for registering yourself as a donor. Your" +
    			" details are as below: \n\n\n ID: "+ user.getId()+" \n Full Name: "+ user.getUser() +" \n Blood Group: "+ user.getBloodGroup()
    			+" \n Phone Number: "+ user.getPhone()+" \n Email: "+ user.getEmailId()+" \n City: "+ user.getCity()
    			+" \n Last Donated Date: "+ user.getLastDonatedDate());
    	msg.setArguments(args);
    	
    	getSupportFragmentManager().beginTransaction().replace(R.id.activity_register_main, msg).addToBackStack(null).commit();
    	
    }
	
	public void onResume() {
		super.onResume();
		datasource.open();
	}
	
	public void onPause() {
		super.onPause();
		datasource.close();
	}
}