package kg.megacom;

import kg.megacom.Database.DbWork;
import kg.megacom.Methods.AlphabeticalList;
import kg.megacom.Methods.DepositorInfo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DbWork dbWork = new DbWork();
        DepositorInfo depositorInfo = new DepositorInfo();
//        System.out.println(depositorInfo);
       dbWork.addNewDepositor(depositorInfo);


    }

}
