package br.com.value_monitor.bo;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.value_monitor.dao.ExpenseDAO;
import br.com.value_monitor.database.ExpenseDatabase;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.model.Values;
import br.com.value_monitor.utils.Utils;

public class ExpenseBO {

    ExpenseDAO dao = new ExpenseDAO();
    Utils utils = new Utils();

    public boolean insertMonth(Month month) {
        return dao.insertMonth(month);
    }

    public boolean insertValue(Values values) {
        return dao.insertValue(values);

    }

    public List<Values> listAllValues(int monthId) {
        return dao.listAllValues(monthId);
    }

    public Values findValueById(int id) {
        return dao.findValueById(id);

    }

    public boolean alterValue(Values values) {
        return dao.alterValue(values);

    }

    public boolean removeValue(int id) {
        return dao.removeValue(id);
    }

    public List<Month> listAllMonth() {
        return dao.listAllMonth();
    }

    public int getLastMonth() {
        int id = 0;
        SQLiteDatabase db = ExpenseDatabase.getInstance().getReadableDatabase();
        String query = "SELECT MONTH_ID FROM " + ExpenseDatabase.TABLE_MONTH + " ORDER BY ID desc LIMIT 1";
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            id = c.getInt(0);
        }
        if (c != null) {
            c.close();
        }
        return id;

    }


    public boolean setFirstMonth() {
        if (listAllMonth().isEmpty()) {
            Month month = new Month(utils.getIdMonth(), utils.getMonthName(), 0.0);
            insertMonth(month);
            return true;
        }
        return false;
    }

    public void setMonth() {
        if (!setFirstMonth()) {
            if (utils.getIdMonth() != getLastMonth()) {
                dao.insertMonth(new Month(utils.getIdMonth(), utils.getMonthName(), 0.0));
            }
        }
    }

    public boolean sumTotValue(double value, int month_id) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String query = ("UPDATE " + ExpenseDatabase.TABLE_MONTH + " SET TOT_VALUE = TOT_VALUE +'" + value + "' WHERE MONTH_ID ='" + month_id + "'");
            db.execSQL(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    public void subtractTotValue(double value, int month_id) {
        try {
            SQLiteDatabase db = ExpenseDatabase.getInstance().getWritableDatabase();
            String query = ("UPDATE " + ExpenseDatabase.TABLE_MONTH + " SET TOT_VALUE = TOT_VALUE -'" + value + "' WHERE MONTH_ID ='" + month_id + "'");
            db.execSQL(query);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
