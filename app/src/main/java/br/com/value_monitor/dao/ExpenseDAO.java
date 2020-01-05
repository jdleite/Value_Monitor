package br.com.value_monitor.dao;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import br.com.value_monitor.constants.ExpenseConstants;
import br.com.value_monitor.database.ExpenseDatabase;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.model.Values;

public class ExpenseDAO {

    public boolean insertMonth(Month month) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ExpenseConstants.MonthConstants.MONTH_ID, month.getMonth_id());
            cv.put(ExpenseConstants.MonthConstants.MONTH_NAME, month.getMonth_name());
            cv.put(ExpenseConstants.MonthConstants.TOT_VALUE,month.getTotValue());

            db.insert(ExpenseDatabase.TABLE_MONTH, null, cv);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return false;
    }

    public List<Month> listAllMonth() {
        List<Month> monthList = new ArrayList<>();
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getReadableDatabase();
            String query = " SELECT * FROM " + ExpenseDatabase.TABLE_MONTH + " ORDER BY ID DESC";
            Cursor c = db.rawQuery(query, null);

            if (c.moveToFirst()) {
                do {
                    Month month = new Month();

                    month.setId(c.getInt(0));
                    month.setMonth_id(c.getInt(1));
                    month.setMonth_name(c.getString(2));
                    month.setTotValue(c.getDouble(3));
                    monthList.add(month);

                } while (c.moveToNext());
            }
            c.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return monthList;
    }

    public boolean insertValue(Values values) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(ExpenseConstants.ValueConstants.VALUE, values.getValue());
            cv.put(ExpenseConstants.ValueConstants.DAY_MONTH, values.getDay_month());
            cv.put(ExpenseConstants.ValueConstants.TIME_VALUE, values.getTime_value());
            cv.put(ExpenseConstants.ValueConstants.DT_VALUE, values.getDt_value());
            cv.put(ExpenseConstants.ValueConstants.MONTH_ID, values.getMonth_id());

            db.insert(ExpenseDatabase.TABLE_VALUES, null, cv);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return false;
    }

    public List<Values> listAllValues(int monthId) {
        List<Values> valuesList = new ArrayList<>();
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getReadableDatabase();
            String query = " SELECT * FROM " + ExpenseDatabase.TABLE_VALUES + " WHERE month_id = " + monthId + " ORDER BY ID DESC";
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Values values = new Values();

                    values.setId(cursor.getInt(0));
                    values.setValue(cursor.getDouble(1));
                    values.setDay_month(cursor.getString(2));
                    values.setTime_value(cursor.getString(3));
                    values.setDt_value(cursor.getString(4));
                    values.setMonth_id(cursor.getInt(5));

                    valuesList.add(values);

                } while (cursor.moveToNext());
            }
            cursor.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return valuesList;
    }

    public Values findValueById(int id) {
        Values values = new Values();
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String query = " SELECT * FROM " + ExpenseDatabase.TABLE_VALUES + " WHERE ID = '" + id + "'";
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                values.setId(cursor.getInt(0));
                values.setValue(cursor.getDouble(1));
                values.setDay_month(cursor.getString(2));
                values.setTime_value(cursor.getString(3));
                values.setDt_value(cursor.getString(4));
                values.setMonth_id(cursor.getInt(5));
            }
            if (cursor != null) {
                cursor.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }

        return values;
    }

    public boolean alterValue(Values values) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ExpenseConstants.ValueConstants.VALUE, values.getValue());
            cv.put(ExpenseConstants.ValueConstants.DAY_MONTH, values.getDay_month());
            cv.put(ExpenseConstants.ValueConstants.DT_VALUE, values.getDt_value());
            cv.put(ExpenseConstants.ValueConstants.TIME_VALUE, values.getTime_value());
            String where = " ID '" + values.getId() + "'";
            db.update(ExpenseDatabase.TABLE_VALUES, cv, where, null);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return false;
    }

    public boolean removeValue(int id) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String whereClause = ExpenseConstants.ValueConstants.ID + " = ? ";
            String[] whereArgs = {String.valueOf(id)};
            db.delete(ExpenseDatabase.TABLE_VALUES, whereClause, whereArgs);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ExpenseDatabase.getInstance().close();
        }
        return false;
    }


}
