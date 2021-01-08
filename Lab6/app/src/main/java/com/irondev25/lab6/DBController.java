package com.irondev25.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DBController extends SQLiteOpenHelper {
    private final String DBNAME = "STUDENT";

    public DBController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE STUDENT(FNAME TEXT,LNAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
    }

    public void insert(String a,String b) {
        ContentValues cv = new ContentValues();
        cv.put("FNAME",a);
        cv.put("LNAME",b);
        this.getWritableDatabase().insertOrThrow(DBNAME,"",cv);
    }

    public void delete(String a) {
        this.getWritableDatabase().delete(DBNAME,"FNAME='"+a+"'",null);
    }

    public void update(String a,String b) {
        this.getWritableDatabase().execSQL("UPDATE STUDENT SET FNAME='"+b+"' WHERE FNAME='"+a+"';");
    }

    public void list(TextView tv) {
        tv.setText("");
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STUDENT",null);

        while(c.moveToNext()) {
            tv.append(c.getString(0)+" "+c.getString(1)+"\n");
        }
    }
}
