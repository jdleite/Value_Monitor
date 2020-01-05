package br.com.value_monitor.view;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import br.com.value_monitor.R;
import br.com.value_monitor.bo.ExpenseBO;
import br.com.value_monitor.model.Values;
import br.com.value_monitor.utils.Utils;

public class InputDialogFragment extends DialogFragment {

    private TextView txtOk, txtCancel;
    private EditText edtValue;
    private Utils utils = new Utils();
    public Listener listener;
    String a;
    private ExpenseBO bo = new ExpenseBO();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_input_fragment, container, false);

        txtOk = view.findViewById(R.id.id_txt_ok);
        txtCancel = view.findViewById(R.id.id_txt_cancel);
        edtValue = view.findViewById(R.id.id_edt_input_value);
        callFragment();


        return view;
    }

    public interface Listener {
        void input(double input);
    }


    public void callFragment() {
        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate()) {
                    return;
                } else {

                    double value = Double.parseDouble(edtValue.getText().toString().replace(",",""));
                    bo.insertValue(new Values(value,utils.getMonthDay(),utils.getHour(),utils.getDate(),utils.getIdMonth()));
                    bo.sumTotValue(value, utils.getIdMonth());
                    listener.input(value);
                    getDialog().dismiss();
                }

            }
        });
        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (Listener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " deve ser implementado Listener");        }
    }

    public boolean validate() {
        if (edtValue.getText().toString().trim().isEmpty()) {
            edtValue.setError(getString(R.string.campo_vazio));
            return false;
        }
        return true;
    }
}
