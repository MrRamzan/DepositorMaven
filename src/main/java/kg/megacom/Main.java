package kg.megacom;

import kg.megacom.Database.DbWork;
import kg.megacom.Methods.AlphabeticalList;
import kg.megacom.Methods.CountOfDeposit;
import kg.megacom.Methods.DepositorInfo;
import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.IdentifierProjection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DbWork dbWork = new DbWork();
        System.out.println(dbWork.countOfDep());







    }

}
