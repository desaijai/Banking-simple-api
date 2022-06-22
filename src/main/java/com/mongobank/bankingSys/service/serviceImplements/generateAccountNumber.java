package com.mongobank.bankingSys.service.serviceImplements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class generateAccountNumber {

    private String bname;
    private String branValue;
    private int bid;
    private int aid;

    public static String generatorANumber(String bname,int bid,int aid){
        bname=bname.toUpperCase(Locale.ROOT);
        String bn=bname.replaceAll("\\s+","").substring(0,4);
        String s=bn+"00001"+bid+aid;
        if(bname.equals("HDFC")){
            return bname+"04037"+bid+aid;
        }
        else if (bname.equals("KOTAK")){
            return bname+"01298"+bid+aid;
        }
        else if(bname.equals("UNION BANK OF INDIA")){
            return bn+"05923"+bid+aid;
        }
        else{
            s.strip();
            return s;
        }
    }
}
