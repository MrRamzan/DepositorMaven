package kg.megacom.Database;

import kg.megacom.Methods.*;
import kg.megacom.Models.*;

import java.sql.Connection;
import java.util.ArrayList;

public interface DbworkInterface {

    Connection getConnection();

    ArrayList<DepositorInfo> selectAllDepositor ();
    ArrayList<Deposit> selectAllDeposit();
    ArrayList<AmountOfDeposit> selectAllAmountOfDeposit();
    ArrayList<DepositorByAddress> selectAddresses();
    ArrayList<AlphabeticalList> selectAlphabetically();
    ArrayList<RequesWithCalculations> selectRequesWithCalculations();
    ArrayList<StateRequest> selectRequestWithParameters();
    ArrayList<SurnamesAndInitials> selectInitials ();
    ArrayList<ChangingTheCase> changeRegistr();

    double MinSum();
    double avgSum();
    ArrayList<CountOfDeposit> countOfDep ();


    boolean addNewDepositor(DepositorInfo depositorInfo);
    boolean createNewTable (DepositorInfo depositorInfo);
    boolean copyInfoToOtherTable(DepositorInfo depositorInfo);

}
