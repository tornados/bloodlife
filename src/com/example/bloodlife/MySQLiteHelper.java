package com.example.bloodlife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_USERS = "users";
	public static final String COLUMN_ID = "_ID";
	public static final String COLUMN_FULL_NAME = "full_name";
	public static final String COLUMN_BLOOD_GROUP = "blood_group";
	public static final String COLUMN_PHONE_NUMBER = "phone_number";
	public static final String COLUMN_CITY = "city";
	public static final String COLUMN_EMAIL_ID = "email_id";
	public static final String COLUMN_LAST_DONATED_DATE = "last_donated_date";
	
	public static final String DATABASE_NAME = "bloodlife.db";
	public static final int DATABASE_VERSION = 3;
	
	//Database create statement
	public static final String DATABASE_CREATE = "create table "+TABLE_USERS+" ("+ COLUMN_ID
			+ " integer primary key autoincrement, "+ COLUMN_FULL_NAME
			+ " text not null, "+ COLUMN_BLOOD_GROUP+" text not null, "+ 
			COLUMN_PHONE_NUMBER+" text not null, "+ COLUMN_CITY+" text not null, "+ 
			COLUMN_EMAIL_ID+" text not null, "+ COLUMN_LAST_DONATED_DATE+" text not null);";
	
	public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+ TABLE_USERS;
	
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}
}