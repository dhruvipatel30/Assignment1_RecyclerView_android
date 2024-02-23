
package com.example.myfirstcollegeapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbBasic extends SQLiteOpenHelper {
	private static final String DATABASE_NAME="Ass1_login";
	public static final String TITLE="title";
	public static final String VALUE="value";
	
	public DbBasic(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS constants (_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password REAL);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS constants");
		onCreate(db);
	}
}


//                //Show Value from Table
//				db =(new DbBasic(this)).getReadableDatabase();
//                        Cursor CurstudentDetail =  db.rawQuery("Select * from test",null);
//                        startManagingCursor(CurstudentDetail);
//                        CurstudentDetail.moveToFirst();
//
//                        if (CurstudentDetail.moveToFirst()){
//                        do {
//                        // Passing values
//                        String column1 = CurstudentDetail.getString(0);
//                        String column2 = CurstudentDetail.getString(1);
//                        String column3 = CurstudentDetail.getString(2);
//                        Log.v("#Value","Column 1: " + column1 + "  Column 2: " + column2 + " Colimn 3: " + column3);
//                        // Do something Here with values
//                        } while(CurstudentDetail.moveToNext());
//                        }