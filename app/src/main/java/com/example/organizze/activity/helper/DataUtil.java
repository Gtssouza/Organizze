package com.example.organizze.activity.helper;

import java.text.Format;
import java.text.SimpleDateFormat;

public class DataUtil {

    public static String dataAtual(){
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormat = sdf.format(date);
        return dataFormat;
    }

}
