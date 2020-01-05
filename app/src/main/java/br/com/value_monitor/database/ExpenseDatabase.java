package br.com.value_monitor.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExpenseDatabase extends SQLiteOpenHelper {
    private static String DATABASE = "database";
    public static String TABLE_MONTH = "month";
    public static String TABLE_VALUES = "valuess";
    private static int VERSION = 1;



    private  static ExpenseDatabase instance;

    public static ExpenseDatabase getInstance(){
        if (instance == null) instance = new ExpenseDatabase();
        return instance;
    }

    public ExpenseDatabase() {
        super(MyApp.getContext(), DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public synchronized void close() {
        super.close();

        instance = null;

    }
}
