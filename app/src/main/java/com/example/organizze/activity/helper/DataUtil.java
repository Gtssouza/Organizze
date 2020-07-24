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

    public static String mesAnoDataEscolhida(String data){
        String retornoData[] = data.split("/");
        String dia = retornoData[0];
        String mes = retornoData[1];
        String ano = retornoData[2];

        String mesAno = mes + ano;
        return mesAno;
    }

}
