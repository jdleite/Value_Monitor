package br.com.value_monitor.listener;

import br.com.value_monitor.model.Values;

public interface ValueListener {

    void onClickList(int id);

    void onDeleteClick(int id);

    void subtractValue(double value,int id);

}



