package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Pakar extends AppCompatActivity {

    Button btn_submit ;
    TextView output ;
    CheckBox tanya1,tanya2,tanya3 ;
    AutoCompleteTextView nilai1,nilai2,nilai3 ;

    String[] nilaiyakin1 = {"","0","0.2","0.5","0.8","1"};
    String[] nilaiyakin2 = {"","0","0.2","0.5","0.8","1"};
    String[] nilaiyakin3 = {"","0","0.2","0.5","0.8","1"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakar);

        btn_submit = (Button)findViewById(R.id.btn_submit);
        output = (TextView)findViewById(R.id.output);
        tanya1 = (CheckBox)findViewById(R.id.tanya1);
        tanya2 = (CheckBox)findViewById(R.id.tanya2);
        tanya3 = (CheckBox)findViewById(R.id.tanya3);
        nilai1 = (AutoCompleteTextView)findViewById(R.id.nilai1);
        nilai2 = (AutoCompleteTextView)findViewById(R.id.nilai2);
        nilai3 = (AutoCompleteTextView)findViewById(R.id.nilai3);

        final ArrayAdapter<String> adapternilai1 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiyakin1);
        nilai1.setThreshold(1);
        nilai1.setAdapter(adapternilai1);
        final ArrayAdapter<String> adapternilai2 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiyakin2);
        nilai2.setThreshold(1);
        nilai2.setAdapter(adapternilai2);
        final ArrayAdapter<String> adapternilai3 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiyakin3);
        nilai3.setThreshold(1);
        nilai3.setAdapter(adapternilai3);

        nilai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Pakar.this).setTitle("Pilih Nilai Keyakinan :").setAdapter(adapternilai1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nilai1.setText(nilaiyakin1[which].toString());
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });

        nilai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Pakar.this).setTitle("Pilih Nilai Keyakinan :").setAdapter(adapternilai2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nilai2.setText(nilaiyakin2[which].toString());
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });

        nilai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Pakar.this).setTitle("Pilih Nilai Keyakinan :").setAdapter(adapternilai3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nilai3.setText(nilaiyakin3[which].toString());
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namapenyakit = "Tanaman Menderita Penyakit :";
                String nilaipenyakit = "Presentase Kepercayaan :";

                if (tanya1.isChecked() && tanya2.isChecked() && tanya3.isChecked()){

                    double nilaitanya1 = 0.2;
                    double nilaitanya2 = 0.5;
                    double nilaitanya3 = 0.8;

                    double doubleTanya1 = Double.parseDouble(nilai1.getText().toString());
                    double doubleTanya2 = Double.parseDouble(nilai2.getText().toString());
                    double doubleTanya3 = Double.parseDouble(nilai3.getText().toString());

                    double hasilHitungtanya1 = nilaitanya1*doubleTanya1 ;
                    double hasilHitungtanya2 = nilaitanya2*doubleTanya2 ;
                    double hasilHitungtanya3 = nilaitanya3*doubleTanya3;

                    double combine_cf1_cf2 = hasilHitungtanya1 + hasilHitungtanya2 * (1 - hasilHitungtanya1);
                    double combine_cf1old_cf3 = combine_cf1_cf2 + hasilHitungtanya3 * (1 - combine_cf1_cf2);

                    String hasilHitungPenyakit1 = String.valueOf((combine_cf1old_cf3 * 100));

                    namapenyakit += "\nPenyakit Kepik";
                    nilaipenyakit +="\n"+hasilHitungPenyakit1;

                }

                output.setText(""+namapenyakit+"\n"+nilaipenyakit+" % \n\n");

            }
        });

    }
}