package br.com.value_monitor.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import br.com.value_monitor.R;
import br.com.value_monitor.adapter.ValueAdapter;
import br.com.value_monitor.bo.ExpenseBO;
import br.com.value_monitor.listener.ValueListener;
import br.com.value_monitor.model.Values;
import br.com.value_monitor.viewHolder.MonthViewHolder;

public class ListExpense extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ValueListener listener;
    List<Values> listValues = new ArrayList<>();
    private ExpenseBO bo = new ExpenseBO();
    private ValueAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_expense);
        setTitle(R.string.valores_lancados);

        recyclerView = findViewById(R.id.id_recycler_values);

        listener = new ValueListener() {
            @Override
            public void onClickList(int id) {

            }

            @Override
            public void onDeleteClick(int id) {

                bo.removeValue(id);
                listValues.clear();
                onResume();

            }

            @Override
            public void subtractValue(double value, int id) {
                bo.subtractTotValue(value, id);
            }
        };


    }

    @Override
    protected void onResume() {
        super.onResume();


        getListValues();
    }

    private void getListValues() {

        listValues.addAll(bo.listAllValues(MonthViewHolder.GLOBAL));
        adapter = new ValueAdapter(listValues, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}



