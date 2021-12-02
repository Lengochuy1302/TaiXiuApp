package com.example.newww;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class XoSo extends AppCompatActivity {
    MoneyMoney mo = new MoneyMoney();

    TextView tiente,kqgiai8, kqgiai7,  kqgiai6cham1,  kqgiai6cham2,kqgiai6cham3, kqgiai5, kqgiai4cham1,kqgiai4cham2,kqgiai4cham3,kqgiai4cham4,kqgiai4cham5,kqgiai4cham6,kqgiai4cham7,kqgiai3cham1,kqgiai3cham2, kqgiai2,kqgiai1, kqgiaidb;
    Button btn_datcuoc;
    EditText edt_tiencuoc,edt_nhapso;
    Dialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo_so);
        anhxa();

        btn_datcuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    xulyrandom();
                    String nhapcuoc = edt_nhapso.getText().toString().trim();
                    int sonhapcuoc = new Integer(nhapcuoc).intValue();

                    String strkqdb =kqgiaidb.getText().toString().trim();
                    int intkqdb = new Integer(strkqdb).intValue();
                    int bientam = intkqdb%100;





                    if(sonhapcuoc==(bientam)){
                        DecimalFormat formatmoney = new DecimalFormat("###,###,###");
                        String nhaptien = edt_tiencuoc.getText().toString().trim();
                        int sonhaptien = new Integer(nhaptien).intValue();
                        MoneyMoney.SCORE = MoneyMoney.SCORE+(sonhaptien*98);
                        String tien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
                        tiente.setText(tien+"VND");
                        showwindialog();

                    }else{

                        DecimalFormat formatmoney = new DecimalFormat("###,###,###");
                        String nhaptien = edt_tiencuoc.getText().toString().trim();
                        int sonhaptien = new Integer(nhaptien).intValue();
                        MoneyMoney.SCORE = MoneyMoney.SCORE-sonhaptien;
                        String tien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
                        tiente.setText(tien+"VND");

                        showclossialog();
                    }

                }catch (Exception exception){
                    Toast.makeText(getApplication(),"Nhập cược để chơi bạn ơi " , Toast.LENGTH_SHORT).show();

                }













            }
        });


        tiente.setText(mo.tien+"VND");


    }



    private void xulyrandom() {


        Date now = new Date();

        Random random = new Random(now.getTime());


        int haiso = random.nextInt(100);
        String chuoi2so = String.valueOf(haiso);
        if (haiso < 10) {
            kqgiai8.setText("0" + chuoi2so);
        } else {
            kqgiai8.setText(chuoi2so);
        }
        int baso = random.nextInt(1000);
        String chuoi3so = String.valueOf(baso);
        if (baso < 99) {
            kqgiai7.setText("0" + chuoi3so);
        } else if (baso > 100) {
            kqgiai7.setText(chuoi3so);
        }


        int bon4 = random.nextInt(10000);
        int bon4cham2 = ThreadLocalRandom.current().nextInt(0, 10000);
        int bon4cham3 = random.nextInt(10000);
        String chuoi4so = String.valueOf(bon4);
        String chuoi4socham2 = String.valueOf(bon4cham2);
        String chuoi4socham3 = String.valueOf(bon4cham3);

        if (bon4 < 10) {
            kqgiai6cham1.setText("000" + chuoi4so);
        } else if ((bon4 > 10 && bon4 < 99)) {
            kqgiai6cham1.setText("00" + chuoi4so);
        } else if (bon4 > 100 && bon4 < 1000) {
            kqgiai6cham1.setText("0" + chuoi4so);
        } else if (bon4 > 1000 && bon4 < 10000) {
            kqgiai6cham1.setText(chuoi4so);
        }
        if (bon4cham2 < 10) {
            kqgiai6cham2.setText("000" + chuoi4socham2);
        } else if ((bon4cham2 > 10 && bon4cham2 < 99)) {
            kqgiai6cham2.setText("00" + chuoi4socham2);
        } else if (bon4cham2 > 100 && bon4cham2 < 1000) {
            kqgiai6cham2.setText("0" + chuoi4socham2);
        } else if (bon4cham2 > 1000 && bon4cham2 < 10000) {
            kqgiai6cham2.setText(chuoi4socham2);
        }
        if (bon4cham3 < 10) {
            kqgiai6cham3.setText("000" + chuoi4socham3);
        } else if ((bon4cham3 > 10 && bon4cham2 < 99)) {
            kqgiai6cham3.setText("00" + chuoi4socham3);
        } else if (bon4cham3 > 100 && bon4cham2 < 1000) {
            kqgiai6cham3.setText("0" + chuoi4socham3);
        } else if (bon4cham3 > 1000 && bon4cham2 < 10000) {
            kqgiai6cham3.setText(chuoi4socham3);
        }

        int giainam = ThreadLocalRandom.current().nextInt(0, 10000);
        String chuoigiainam = String.valueOf(giainam);
        if (giainam < 10) {
            kqgiai5.setText("000" + chuoigiainam);
        } else if ((giainam > 10 && giainam < 99)) {
            kqgiai5.setText("00" + chuoigiainam);
        } else if (giainam > 100 && giainam < 1000) {
            kqgiai5.setText("0" + chuoigiainam);
        } else if (giainam > 1000 && giainam < 10000) {
            kqgiai5.setText(chuoigiainam);
        }

        int giai4cham1 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham1 = String.valueOf(giai4cham1);
        if (giai4cham1 < 10) {
            kqgiai4cham1.setText("0000" + chuoigiai4cham1);
        } else if ((giai4cham1 > 10 && giai4cham1 < 99)) {
            kqgiai4cham1.setText("000" + chuoigiai4cham1);
        } else if (giai4cham1 > 100 && giai4cham1 < 1000) {
            kqgiai4cham1.setText("00" + chuoigiai4cham1);
        } else if (giai4cham1 > 1000 && giai4cham1 < 10000) {
            kqgiai4cham1.setText("0" + chuoigiai4cham1);
        } else {
            kqgiai4cham1.setText(chuoigiai4cham1);
        }

        int giai4cham2 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham2 = String.valueOf(giai4cham2);
        if (giai4cham2 < 10) {
            kqgiai4cham2.setText("0000" + chuoigiai4cham2);
        } else if ((giai4cham2 > 10 && giai4cham2 < 99)) {
            kqgiai4cham2.setText("000" + chuoigiai4cham2);
        } else if (giai4cham2 > 100 && giai4cham2 < 1000) {
            kqgiai4cham2.setText("00" + chuoigiai4cham2);
        } else if (giai4cham2 > 1000 && giai4cham2 < 10000) {
            kqgiai4cham2.setText("0" + chuoigiai4cham2);
        } else {
            kqgiai4cham2.setText(chuoigiai4cham2);
        }

        int giai4cham3 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham3 = String.valueOf(giai4cham3);
        if (giai4cham3 < 10) {
            kqgiai4cham3.setText("0000" + chuoigiai4cham3);
        } else if ((giai4cham3 > 10 && giai4cham3 < 99)) {
            kqgiai4cham3.setText("000" + chuoigiai4cham3);
        } else if (giai4cham3 > 100 && giai4cham3 < 1000) {
            kqgiai4cham3.setText("00" + chuoigiai4cham3);
        } else if (giai4cham3 > 1000 && giai4cham3 < 10000) {
            kqgiai4cham3.setText("0" + chuoigiai4cham3);
        } else {
            kqgiai4cham3.setText(chuoigiai4cham3);
        }

        int giai4cham4 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham4 = String.valueOf(giai4cham4);
        if (giai4cham4 < 10) {
            kqgiai4cham4.setText("0000" + chuoigiai4cham4);
        } else if ((giai4cham4 > 10 && giai4cham4 < 99)) {
            kqgiai4cham4.setText("000" + chuoigiai4cham4);
        } else if (giai4cham4 > 100 && giai4cham4 < 1000) {
            kqgiai4cham4.setText("00" + chuoigiai4cham4);
        } else if (giai4cham4 > 1000 && giai4cham4 < 10000) {
            kqgiai4cham4.setText("0" + chuoigiai4cham4);
        } else {
            kqgiai4cham4.setText(chuoigiai4cham4);
        }

        int giai4cham5 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham5 = String.valueOf(giai4cham5);
        if (giai4cham5 < 10) {
            kqgiai4cham5.setText("0000" + chuoigiai4cham5);
        } else if ((giai4cham5 > 10 && giai4cham5 < 99)) {
            kqgiai4cham5.setText("000" + chuoigiai4cham5);
        } else if (giai4cham5 > 100 && giai4cham5 < 1000) {
            kqgiai4cham5.setText("00" + chuoigiai4cham5);
        } else if (giai4cham5 > 1000 && giai4cham5 < 10000) {
            kqgiai4cham5.setText("0" + chuoigiai4cham5);
        } else {
            kqgiai4cham5.setText(chuoigiai4cham5);
        }

        int giai4cham6 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham6 = String.valueOf(giai4cham6);
        if (giai4cham6 < 10) {
            kqgiai4cham6.setText("0000" + chuoigiai4cham6);
        } else if ((giai4cham6 > 10 && giai4cham6 < 99)) {
            kqgiai4cham6.setText("000" + chuoigiai4cham6);
        } else if (giai4cham6 > 100 && giai4cham6 < 1000) {
            kqgiai4cham6.setText("00" + chuoigiai4cham6);
        } else if (giai4cham6 > 1000 && giai4cham6 < 10000) {
            kqgiai4cham6.setText("0" + chuoigiai4cham6);
        } else {
            kqgiai4cham6.setText(chuoigiai4cham6);
        }

        int giai4cham7 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai4cham7 = String.valueOf(giai4cham7);
        if (giai4cham7 < 10) {
            kqgiai4cham7.setText("0000" + chuoigiai4cham7);
        } else if ((giai4cham7 > 10 && giai4cham7 < 99)) {
            kqgiai4cham7.setText("000" + chuoigiai4cham7);
        } else if (giai4cham7 > 100 && giai4cham7 < 1000) {
            kqgiai4cham7.setText("00" + chuoigiai4cham7);
        } else if (giai4cham7 > 1000 && giai4cham7 < 10000) {
            kqgiai4cham7.setText("0" + chuoigiai4cham7);
        } else {
            kqgiai4cham7.setText(chuoigiai4cham7);
        }


        int giai3cham1 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai3cham1 = String.valueOf(giai3cham1);
        if (giai3cham1 < 10) {
            kqgiai3cham1.setText("0000" + chuoigiai3cham1);
        } else if ((giai3cham1 > 10 && giai3cham1 < 99)) {
            kqgiai3cham1.setText("000" + chuoigiai3cham1);
        } else if (giai3cham1 > 100 && giai3cham1 < 1000) {
            kqgiai3cham1.setText("00" + chuoigiai3cham1);
        } else if (giai3cham1 > 1000 && giai3cham1 < 10000) {
            kqgiai3cham1.setText("0" + chuoigiai3cham1);
        } else {
            kqgiai3cham1.setText(chuoigiai3cham1);
        }

        int giai3cham2 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai3cham2 = String.valueOf(giai3cham2);
        if (giai3cham2 < 10) {
            kqgiai3cham2.setText("0000" + chuoigiai3cham2);
        } else if ((giai3cham2 > 10 && giai3cham2 < 99)) {
            kqgiai3cham2.setText("000" + chuoigiai3cham2);
        } else if (giai3cham2 > 100 && giai3cham2 < 1000) {
            kqgiai3cham2.setText("00" + chuoigiai3cham2);
        } else if (giai3cham2 > 1000 && giai3cham2 < 10000) {
            kqgiai3cham2.setText("0" + chuoigiai3cham2);
        } else {
            kqgiai3cham2.setText(chuoigiai3cham2);
        }

        int giai2cham1 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai2cham1 = String.valueOf(giai2cham1);
        if (giai2cham1 < 10) {
            kqgiai2.setText("0000" + chuoigiai2cham1);
        } else if ((giai2cham1 > 10 && giai2cham1 < 99)) {
            kqgiai2.setText("000" + chuoigiai2cham1);
        } else if (giai2cham1 > 100 && giai2cham1 < 1000) {
            kqgiai2.setText("00" + chuoigiai2cham1);
        } else if (giai2cham1 > 1000 && giai2cham1 < 10000) {
            kqgiai2.setText("0" + chuoigiai2cham1);
        } else {
            kqgiai2.setText(chuoigiai2cham1);
        }

        int giai1cham1 = ThreadLocalRandom.current().nextInt(0, 100000);
        String chuoigiai1cham1 = String.valueOf(giai1cham1);
        if (giai1cham1 < 10) {
            kqgiai1.setText("0000" + chuoigiai1cham1);
        } else if ((giai1cham1 > 10 && giai1cham1 < 99)) {
            kqgiai1.setText("000" + chuoigiai1cham1);
        } else if (giai1cham1 > 100 && giai1cham1 < 1000) {
            kqgiai1.setText("00" + chuoigiai1cham1);
        } else if (giai1cham1 > 1000 && giai1cham1 < 10000) {
            kqgiai1.setText("0" + chuoigiai1cham1);
        } else {
            kqgiai1.setText(chuoigiai1cham1);
        }


            int giaidbb = ThreadLocalRandom.current().nextInt(0,1000000);
            String chuoigiaidbb = String.valueOf(giaidbb);
            if (giaidbb < 10) {
                kqgiaidb.setText("00000" + chuoigiaidbb);
            } else if ((giaidbb > 10 && giaidbb < 99)) {
                kqgiaidb.setText("0000" + chuoigiaidbb);
            } else if (giaidbb > 100 && giaidbb < 1000) {
                kqgiaidb.setText("000"+chuoigiaidbb);
            }else if (giaidbb > 1000 && giaidbb < 10000) {
                kqgiaidb.setText("00"+chuoigiaidbb);
            }else if (giaidbb>10000 &&giaidbb<100000){
                kqgiaidb.setText("0"+chuoigiaidbb);
            } else{
                kqgiaidb.setText(chuoigiaidbb);
            }
    }




    public void anhxa(){
        kqgiai8 = (TextView)findViewById(R.id.kqgiai8);
        kqgiai7 = (TextView)findViewById(R.id.kqgiai7);
        kqgiai6cham1 = (TextView)findViewById(R.id.kqgiai6cham1);
        kqgiai6cham2 = (TextView)findViewById(R.id.kqgiai6cham2);
        kqgiai6cham3 = (TextView)findViewById(R.id.kqgiai6cham3);
        kqgiai5 = (TextView)findViewById(R.id.kqgiai5);
        kqgiai4cham1 = (TextView)findViewById(R.id.kqgiai4cham1);
        kqgiai4cham2 = (TextView)findViewById(R.id.kqgiai4cham2);
        kqgiai4cham3 = (TextView)findViewById(R.id.kqgiai4cham3);
        kqgiai4cham4 = (TextView)findViewById(R.id.kqgiai4cham4);
        kqgiai4cham5 = (TextView)findViewById(R.id.kqgiai4cham5);
        kqgiai4cham6 = (TextView)findViewById(R.id.kqgiai4cham6);
        kqgiai4cham7 = (TextView)findViewById(R.id.kqgiai4cham7);
        kqgiai3cham1 = (TextView)findViewById(R.id.kqgiai3cham1);
        kqgiai3cham2 = (TextView)findViewById(R.id.kqgiai3cham2);
        kqgiai2 = (TextView) findViewById(R.id.kqgiai2);
        kqgiai1 = (TextView) findViewById(R.id.kqgiai1);
        kqgiaidb = (TextView) findViewById(R.id.kqgiaidb);
        btn_datcuoc = (Button) findViewById(R.id.btn_datcuoc);
        edt_tiencuoc = findViewById(R.id.edt_tiencuoc);
        edt_nhapso = findViewById(R.id.edt_nhapso);
        tiente = findViewById(R.id.tiente);
        dialog = new Dialog(this);
    }

    private void showclossialog() {

        dialog.setContentView(R.layout.close_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))  ;
        ImageView close = dialog.findViewById(R.id.closs);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
    }
    private void showwindialog() {
        dialog.setContentView(R.layout.win_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))  ;
        ImageView close = dialog.findViewById(R.id.closs);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }





        });


    }




}