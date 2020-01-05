package br.com.value_monitor.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.value_monitor.R;
import br.com.value_monitor.adapter.MonthAdapter;
import br.com.value_monitor.bo.ExpenseBO;
import br.com.value_monitor.database.CreateDatabase;
import br.com.value_monitor.listener.MonthListener;
import br.com.value_monitor.model.Month;
import br.com.value_monitor.utils.Utils;

public class ListMonth extends AppCompatActivity implements InputDialogFragment.Listener {

    private CreateDatabase cdb = new CreateDatabase();
    private ViewHolder viewHolder = new ViewHolder();
    private MonthAdapter adapter;
    private ExpenseBO bo = new ExpenseBO();
    private Utils u = new Utils();
    private MonthListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_month);
        setTitle(R.string.lista_meses);

        cdb.create();


        listener = new MonthListener() {
            @Override
            public void onClickList(int id) {
                startActivity(new Intent(getApplicationContext(), ListExpense.class));
            }


        };


        viewHolder.fab = findViewById(R.id.id_fab);
        viewHolder.recyclerView = findViewById(R.id.id_recycler);

        bo.setMonth();
        callFragment();


    }

    @Override
    protected void onResume() {
        super.onResume();

        getListMonth();
    }


    @Override
    public void input(double input) {
        getListMonth();
    }


    private class ViewHolder {
        FloatingActionButton fab;
        RecyclerView recyclerView;
    }

    private void getListMonth() {
        List<Month> monthList = new ArrayList<>();

        monthList.addAll(bo.listAllMonth());

        adapter = new MonthAdapter(monthList, listener);

        viewHolder.recyclerView.setAdapter(adapter);
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void callFragment() {

        viewHolder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputDialogFragment fragment = new InputDialogFragment();
                fragment.show(getSupportFragmentManager(), "fragment");
            }
        });
    }


}
