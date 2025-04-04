package com.dts.pemobdasar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dts.pemobdasar.R;

public class Home extends Fragment {

    private Button btnAddFinancialRecord, btnAddMemo;
    private TextView tvFinancialRecords, tvMemo;
    private EditText etFinancialRecord, etMemo;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_home, container, false);

        btnAddFinancialRecord = view.findViewById(R.id.btnAddFinancialRecord);
        btnAddMemo = view.findViewById(R.id.btnAddMemo);
        tvFinancialRecords = view.findViewById(R.id.tvFinancialRecords);
        tvMemo = view.findViewById(R.id.tvMemo);
        etFinancialRecord = view.findViewById(R.id.etFinancialRecord);
        etMemo = view.findViewById(R.id.etMemo);

        // Menambahkan aksi klik pada Button untuk Pencatatan Keuangan
        btnAddFinancialRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String financialRecord = etFinancialRecord.getText().toString();
                if (!financialRecord.isEmpty()) {
                    // Menampilkan pencatatan keuangan di TextView
                    tvFinancialRecords.setText("Pencatatan: " + financialRecord);
                    // Mengosongkan EditText setelah klik
                    etFinancialRecord.setText("");
                } else {
                    tvFinancialRecords.setText("Masukkan jumlah uang terlebih dahulu!");
                }
            }
        });

        // Menambahkan aksi klik pada Button untuk Memo
        btnAddMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memoText = etMemo.getText().toString();
                if (!memoText.isEmpty()) {
                    // Menampilkan memo di TextView
                    tvMemo.setText("Memo: " + memoText);
                    // Mengosongkan EditText setelah klik
                    etMemo.setText("");
                } else {
                    tvMemo.setText("Masukkan memo terlebih dahulu!");
                }
            }
        });


        return view;
    }
}
