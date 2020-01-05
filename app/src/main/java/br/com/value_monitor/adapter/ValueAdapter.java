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
import br.com.value_monitor.listener.ValueListener;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.model.Values;
import br.com.value_monitor.viewHolder.MonthViewHolder;
import br.com.value_monitor.viewHolder.ValueViewHolder;

public class ValueAdapter extends RecyclerView.Adapter<ValueViewHolder> {

    private List<Values> listValues;
    private ValueListener valueListener;

    public ValueAdapter(List<Values> listValues, ValueListener valueListener) {
        this.listValues = listValues;
        this.valueListener = valueListener;
    }

    @NonNull
    @Override
    public ValueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.activity_value_row, parent, false);

        return new ValueViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ValueViewHolder holder, int position) {
        Values values = this.listValues.get(position);

        holder.bindData(values, valueListener);


    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }
}
