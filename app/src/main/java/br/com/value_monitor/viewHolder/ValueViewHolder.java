package br.com.value_monitor.viewHolder;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.Locale;

import javax.microedition.khronos.opengles.GL;

import br.com.value_monitor.R;
import br.com.value_monitor.database.MyApp;
import br.com.value_monitor.listener.MonthListener;
import br.com.value_monitor.listener.ValueListener;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.model.Values;
import br.com.value_monitor.view.InputDialogFragment;
import br.com.value_monitor.view.ListExpense;
import br.com.value_monitor.view.ListMonth;

public class ValueViewHolder extends RecyclerView.ViewHolder {

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private TextView txtValue,txtDate,txtDay,txtHour;
    private ImageView imgClose;
    private Context context;

    public ValueViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        txtDay = itemView.findViewById(R.id.id_txt_day);
        txtValue = itemView.findViewById(R.id.id_txt_value);
        txtHour = itemView.findViewById(R.id.id_txt_hour);
        txtDate = itemView.findViewById(R.id.id_txt_date);
        imgClose = itemView.findViewById(R.id.id_img_close);
        this.context = context;

    }

    public void bindData(final Values values, final ValueListener listener){
        txtDay.setText(values.getDay_month());
        txtValue.setText((nf.format(values.getValue())));
        txtHour.setText(values.getTime_value());
        txtDate.setText(String.valueOf(values.getDt_value()));

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle(R.string.deletar_valor)
                        .setMessage(R.string.remover_valor)
                        .setIcon(R.drawable.close)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listener.subtractValue(values.getValue(),values.getMonth_id());
                                listener.onDeleteClick(values.getId());
                            }
                        })
                        .setNeutralButton(R.string.nao,null)
                        .show();
            }
        });





    }

}
