package com.example.newww;

import java.text.DecimalFormat;

public class MoneyMoney {

    public static int SCORE =500000;
    DecimalFormat formatmoney = new DecimalFormat("###,###,###");
    String tien = String.valueOf(formatmoney.format(SCORE));



}
