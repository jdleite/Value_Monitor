package br.com.value_monitor.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {

    Calendar calendar = Calendar.getInstance();

    public String getDate() {

        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int ano = calendar.get(Calendar.YEAR);

        String date = dia + "/" + mes + "/" + ano;

        return date;
    }

    public String getHour() {
        Date hr = new Date();
        String hora = new SimpleDateFormat("HH:mm").format(hr);
        return hora;
    }

    public String getMonthName() {
        Calendar calendar = Calendar.getInstance();
        String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        return ptMonth(monthName);
    }

    public int getIdMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;

        return month;
    }

    public String getMonthDay() {
        Calendar calendar = Calendar.getInstance();
        String monthName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);


        return dayOfWeek(monthName);
    }

    public String dayOfWeek(String day) {

        if (day.equalsIgnoreCase("monday")) {
            return "Segunda-Feira";
        } else if (day.equalsIgnoreCase("tuesday")) {
            return "Terça-feira";
        } else if (day.equalsIgnoreCase("wednesday")) {
            return "Quarta-Feira";
        } else if (day.equalsIgnoreCase("thursday")) {
            return "Quinta-Feira";
        } else if (day.equalsIgnoreCase("friday")) {
            return "Sexta-Feira";
        } else if (day.equalsIgnoreCase("Saturday")) {
            return "Sabado";
        }
        return "domingo";
    }

    public String ptMonth(String month) {
        if (month.equalsIgnoreCase("january")) {
            return "Janeiro";
        } else if (month.equalsIgnoreCase("february")) {
            return "Fevereiro";
        } else if (month.equalsIgnoreCase("march")) {
            return "Março";
        } else if (month.equalsIgnoreCase("april")) {
            return "Abril";
        } else if (month.equalsIgnoreCase("may")) {
            return "Maio";
        } else if (month.equalsIgnoreCase("june")) {
            return "Junho";
        } else if (month.equalsIgnoreCase("july")) {
            return "Julho";
        } else if (month.equalsIgnoreCase("august")) {
            return "Agosto";
        } else if (month.equalsIgnoreCase("september")) {
            return "Setembro";
        } else if (month.equalsIgnoreCase("october")) {
            return "Outubro";
        } else if (month.equalsIgnoreCase("november")) {
            return "Novembro";
        }
        return "Dezembro";
    }


}
