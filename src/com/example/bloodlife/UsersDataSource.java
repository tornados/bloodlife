package com.example.bloodlife;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UsersDataSource {
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_BLOOD_GROUP,
				MySQLiteHelper.COLUMN_FULL_NAME, MySQLiteHelper.COLUMN_PHONE_NUMBER, 
				MySQLiteHelper.COLUMN_EMAIL_ID, MySQLiteHelper.COLUMN_CITY,
				MySQLiteHelper.COLUMN_LAST_DONATED_DATE
			};
	
	public UsersDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public Users createUser(String name, String bg, String phone, String email_id, String city, String last_donated_date) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_FULL_NAME, name);
		values.put(MySQLiteHelper.COLUMN_BLOOD_GROUP, bg);
		values.put(MySQLiteHelper.COLUMN_PHONE_NUMBER, phone);
		values.put(MySQLiteHelper.COLUMN_EMAIL_ID, email_id);
		values.put(MySQLiteHelper.COLUMN_CITY, city);
		values.put(MySQLiteHelper.COLUMN_LAST_DONATED_DATE, last_donated_date);
		long insertId = database.insert(MySQLiteHelper.TABLE_USERS, null, values);
		
		Cursor cursor = database.query(MySQLiteHelper.TABLE_USERS, allColumns, 
				MySQLiteHelper.COLUMN_ID + " = "+ insertId, null, null, null, null);
		cursor.moveToFirst();
		Users newUser = cursorToUser(cursor);
		return newUser;
	}
	
	public List<Users> getAllUsers(String conditions) {
		List<Users> users = new ArrayList<Users>();
		//Cursor cursor = database.query(MySQLiteHelper.TABLE_USERS, allColumns, null, null, null, null, null);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_USERS, allColumns, conditions, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			Users user = cursorToUser(cursor);
			users.add(user);
			cursor.moveToNext();
		}
		cursor.close();
		return users;
	}
	
	public Users cursorToUser(Cursor cursor) {
		Users user = new Users();
		user.setId(cursor.getLong(0));
		user.setBloodGroup(cursor.getString(1));
		user.setUser(cursor.getString(2));
		user.setPhone(cursor.getString(3));
		user.setEmailId(cursor.getString(4));
		user.setCity(cursor.getString(5));
		user.setLastDonatedDate(cursor.getString(6));
		return user;
	}
}