package br.com.value_monitor.viewHolder;


import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.value_monitor.R;
import br.com.value_monitor.database.MyApp;
import br.com.value_monitor.listener.MonthListener;
import br.com.value_monitor.model.Month;

public class MonthViewHolder extends RecyclerView.ViewHolder {
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private TextView txtMonth, txtTotValue;
    private Context context;
    public static int GLOBAL;

    public MonthViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        txtMonth = itemView.findViewById(R.id.id_txt_month);
        txtTotValue = itemView.findViewById(R.id.id_txt_value);
        this.context = context;
    }

    public void bindData(final Month month, final MonthListener listener) {
        txtMonth.setText(month.getMonth_name());
        txtTotValue.setText((String.valueOf(nf.format(month.getTotValue()))));

        txtMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GLOBAL = month.getMonth_id();
                listener.onClickList(month.getId());


            }
        });

    }

}
