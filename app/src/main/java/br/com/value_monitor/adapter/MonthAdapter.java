package br.com.value_monitor.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.value_monitor.R;
import br.com.value_monitor.listener.MonthListener;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.viewHolder.MonthViewHolder;

public class MonthAdapter extends RecyclerView.Adapter<MonthViewHolder> {

    private List<Month> listMonth;
    private MonthListener listener;

    public MonthAdapter(List<Month> listMonth, MonthListener listener) {
        this.listMonth = listMonth;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.activity_month_row, parent, false);

        return new MonthViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder holder, int position) {
        Month month = this.listMonth.get(position);

        holder.bindData(month, listener);


    }

    @Override
    public int getItemCount() {
        return listMonth.size();
    }
}
