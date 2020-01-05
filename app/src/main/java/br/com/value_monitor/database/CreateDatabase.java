package br.com.value_monitor.database;

import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {
    public boolean create() {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String column1 = "(ID INTEGER PRIMARY KEY AUTOINCREMENT, MONTH_ID INTEGER NOT NULL,MONTH_NAME VARCHAR,TOT_VALUE REAL)";
            String column2 = "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "VALUE REAL," +
                    "DAY_MONTH VARCHAR," +
                    "TIME_VALUE VARCHAR," +
                    "DT_VALUE VARCHAR," +
                    "MONTH_ID INTEGER NOT NULL)";

            String query1 = " CREATE TABLE IF NOT EXISTS " + ExpenseDatabase.TABLE_MONTH + column1;
            String query2 = " CREATE TABLE IF NOT EXISTS " + ExpenseDatabase.TABLE_VALUES + column2;
            db.execSQL(query1);
            db.execSQL(query2);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete() {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String query1 = " DROP TABLE IF EXISTS " + ExpenseDatabase.TABLE_MONTH;
            String query2 = " DROP TABLE IF EXISTS " + ExpenseDatabase.TABLE_VALUES;
            db.execSQL(query1);
            db.execSQL(query2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
