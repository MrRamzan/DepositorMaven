package kg.megacom.Database;

import kg.megacom.Methods.*;
import kg.megacom.Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class DbWork implements DbworkInterface {

    public Connection getConnection() {
        Connection connection = null;
        String login = "postgres";
        String password = "251412010414";
        String url = "jdbc:postgresql://localhost:5432/deposit";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //Вызвали метод для вывода всей информации о вкладчиках
    @Override
    public ArrayList<DepositorInfo> selectAllDepositor() {
        ArrayList<DepositorInfo> depositorArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.firstname, d.lastname, d.middlename, d.passnumber,ac.accountnum as accountnum, " +
                    "s.streetname as StreetName, h.housenum as houseNum, top.dateofoperation, op.depositsum, " +
                    "top.sumofoperation from depositor d\n" +
                    "join account ac on ac.id_depositor=d.id\n" +
                    "join address ad on d.id_address=ad.id\n" +
                    "join house h on ad.id_house=h.id\n" +
                    "join street s on ad.id_street=s.id\n" +
                    "join typeOfOperation top on top.id_account=ac.id\n" +
                    "join operation op on op.id_account=ac.id";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                String depositorFirstName = resultSet.getString("firstname");
                String depositorLastName = resultSet.getString("lastname");
                String depositorMiddleName = resultSet.getString("middlename");
                long depositorPassNum = resultSet.getLong("passnumber");
                long accountNum = resultSet.getLong("accountnum");
                String streetName = resultSet.getString("streetname");
                int houseNum = resultSet.getInt("houseNum");
                Date resDateOfOperation = resultSet.getDate("dateofoperation");
                double depositSum = resultSet.getDouble("depositsum");
                double sumOfOper = resultSet.getDouble("sumofoperation");

                Depositor depositor = new Depositor(depositorFirstName, depositorLastName,
                        depositorMiddleName, depositorPassNum);
                Account account = new Account(accountNum);
                Street street = new Street(streetName);
                House house = new House(houseNum);
                TypeOfOperation top = new TypeOfOperation(resDateOfOperation, sumOfOper);
                Operation operation = new Operation(depositSum);

                DepositorInfo depositorInfo = new DepositorInfo(depositor, account, street, house, top, operation);
                depositorArrayList.add(depositorInfo);
                System.out.println(depositorInfo);
            }
            return depositorArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public ArrayList<Deposit> selectAllDeposit() {
        ArrayList<Deposit> depArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM deposit";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int depositID = resultSet.getInt("id");
                String depositName = resultSet.getString("name");
                int depositPeriod = resultSet.getInt("period");
                double depositPercent = resultSet.getDouble("percent");

                Deposit deposit = new Deposit(depositID, depositName, depositPeriod, depositPercent);
                depArrayList.add(deposit);

            }
            return depArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<AmountOfDeposit> selectAllAmountOfDeposit() {
        ArrayList<AmountOfDeposit> amountOfDepositArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.firstname, d.lastname, d.middlename, op.depositSum FROM depositor d \n" +
                    "JOIN account ac ON d.id=ac.id_depositor\n" +
                    "JOIN operation op ON ac.id=op.id_account\n" +
                    "WHERE op.depositSum >= 200000";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String mname = resultSet.getString("middleName");
                double depositSum = resultSet.getDouble("depositSum");

                Depositor depositor = new Depositor(fname, lname, mname);
                Operation operation = new Operation(depositSum);
                AmountOfDeposit amountOfDeposit = new AmountOfDeposit(depositor, operation);
                amountOfDepositArrayList.add(amountOfDeposit);

            }
            return amountOfDepositArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<DepositorByAddress> selectAddresses() {
        ArrayList<DepositorByAddress> depByAddressArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.firstname, d.lastname, d.middlename, s.streetname FROM depositor d \n" +
                    "JOIN address ad ON d.id_address=ad.id\n" +
                    "JOIN street s ON ad.id_street=s.id\n" +
                    "WHERE s.streetname= 'Holy Cross'";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String mname = resultSet.getString("middleName");
                String strname = resultSet.getString("streetname");


                Depositor depositor = new Depositor(fname, lname, mname);
                Street street = new Street(strname);
                DepositorByAddress depositorByAddress = new DepositorByAddress(depositor, street);
                depByAddressArrayList.add(depositorByAddress);

            }
            return depByAddressArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public ArrayList<AlphabeticalList> selectAlphabetically() {
        ArrayList<AlphabeticalList> alphabeticalListArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.lastname, d.firstname, d.middlename FROM depositor d WHERE d.lastname " +
                    "BETWEEN 'B%' AND 'N%' ORDER BY d.lastname" ;

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String mname = resultSet.getString("middleName");

                Depositor depo = new Depositor(fname, lname, mname);
                AlphabeticalList alphabeticalList = new AlphabeticalList(depo);
                alphabeticalListArrayList.add(alphabeticalList);

            }
            return alphabeticalListArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<RequesWithCalculations> selectRequesWithCalculations() {
        ArrayList<RequesWithCalculations> requesWithCalculationsArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.lastname, d.firstname, d.middlename, op.depositsum * 0.25 AS depositSum FROM depositor d \n" +
                    "JOIN account ac ON d.id=ac.id_depositor\n" +
                    "JOIN operation op ON ac.id=op.id_account\n" +
                    "ORDER BY ac.accountnum" ;

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String mname = resultSet.getString("middleName");
                Double depsum = resultSet.getDouble("depositsum");

                Depositor depo = new Depositor(fname, lname, mname);
                Operation opr = new Operation(depsum);
                RequesWithCalculations requesWithCalculations = new RequesWithCalculations(depo, opr);
                requesWithCalculationsArrayList.add(requesWithCalculations);

            }
            return requesWithCalculationsArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<StateRequest> selectRequestWithParameters() {
        ArrayList<StateRequest> requesWithParametersArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = " SELECT d.lastname, d.firstname, d.middlename, top.dateofoperation, " +
                    "round(op.depositsum/84.45, 2) AS depositSum FROM depositor d\n" +
                    "    JOIN account ac ON d.id=ac.id_depositor\n" +
                    "    JOIN typeofoperation top ON ac.id=top.id_account\n" +
                    "    JOIN operation op ON ac.id=op.id_account\n" +
                    "    ORDER BY firstname";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String mname = resultSet.getString("middleName");
                Date dateofoper = resultSet.getDate("dateOfOperation");
                Double depsum = resultSet.getDouble("depositSum");

                Depositor depo = new Depositor(fname, lname, mname);
                TypeOfOperation top = new TypeOfOperation(dateofoper);
                Operation opr = new Operation(depsum);
                StateRequest stateRequest = new StateRequest(depo, top, opr);
                requesWithParametersArrayList.add(stateRequest);

            }
            return requesWithParametersArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    // method to change to uppercase
    @Override
    public ArrayList<ChangingTheCase> changeRegistr() {
        ArrayList<ChangingTheCase> change = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = " SELECT d.lastname, d.firstname, d.middlename FROM depositor d";

            // SELECT UPPER(d.lastname), LOWER(d.firstname), UPPER(d.middlename) FROM depositor d

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String lname = resultSet.getString("lastName");
                String fname = resultSet.getString("firstName");
                String mname = resultSet.getString("middleName");

                String str = lname.toUpperCase();
                String str1 = fname.toLowerCase();
                Depositor depo = new Depositor(str, str1, mname);
                ChangingTheCase changingTheCase = new ChangingTheCase(depo);
                change.add(changingTheCase);

            }
            return change;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public double MinSum() {
        Connection connection = getConnection();
        double result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = " SELECT MIN(op.depositsum) FROM operation op ";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                double minsum = resultSet.getDouble("min");
                result = minsum;
            }
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public double avgSum() {
        Connection connection = getConnection();
        double result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = " SELECT AVG(op.depositsum) FROM operation op ";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                double avgsum = resultSet.getDouble("avg");
                result = avgsum;
            }
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public ArrayList<CountOfDeposit> countOfDep() {

        ArrayList<CountOfDeposit> countDep = new ArrayList<>();
        Connection connection = getConnection();
        double result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT d.lastname, d.firstname, COUNT(depositsum) AS COUNT_DEPOSIT FROM operation op\n" +
                    "JOIN account ac ON ac.id=op.id_account\n" +
                    "JOIN depositor d ON d.id=ac.id_depositor\n" +
                    "GROUP BY d.id ";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String lname = resultSet.getString("lastname");
                String fname = resultSet.getString("firstname");
                int avgsum = resultSet.getInt("COUNT_DEPOSIT");

                Depositor depositor = new Depositor(lname, fname);
                Operation oper = new Operation(avgsum);
                CountOfDeposit countdep = new CountOfDeposit(depositor, oper);
                countDep.add(countdep);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return countDep;
    }

    @Override
    public boolean createNewTable(DepositorInfo depositorInfo) {
        Connection connection = getConnection();
        try {
            String query = "CREATE TABLE depositorInfo (\n" +
                    " id BIGSERIAL NOT NULL,\n" +
                    " lastname VARCHAR(50) NOT NULL,\n" +
                    " firstname VARCHAR(50) NOT NULL,\n" +
                    " middlename VARCHAR(50) NOT NULL,\n" +
                    " passnumber INTEGER NOT NULL,\n" +
                    " accountnum INTEGER NOT NULL,\n" +
                    " streetname VARCHAR(50) NOT NULL,\n" +
                    " housenum INTEGER NOT NULL,\n" +
                    " dateofoper DATE NOT NULL,\n" +
                    " depositsum BIGINT NOT NULL,\n" +
                    " id_account INTEGER\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "ALTER TABLE depositorInfo ADD CONSTRAINT depositorInfo_pkey PRIMARY KEY (id);\n" +
                    "ALTER TABLE depositorInfo ADD CONSTRAINT depositorInfo_id_account_fkey FOREIGN KEY (id_account) REFERENCES account(id)";
            PreparedStatement statement = connection.prepareStatement(query);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
        }

    @Override
    public boolean copyInfoToOtherTable(DepositorInfo depositorInfo) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = " SELECT * INTO newTable FROM depositorInfo";

            ResultSet resultSet = statement.executeQuery(query);
            int resultOfSaving = statement.executeUpdate(query);
            return resultOfSaving == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean addNewDepositor(DepositorInfo depositorInfo) {
       Connection connection = getConnection();
       try{
           String query2 = "INSERT INTO depositorInfo (lastname, firstname, middlename, passnumber, accountnum, streetname, housenum, dateofoper, depositsum )" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Scanner scanner = new Scanner(System.in);
            PreparedStatement statement1 = connection.prepareStatement(query2);
            System.out.println("Введите фамилию: ");
            String lname = scanner.next();
            statement1.setString(1, lname);
            System.out.println("Введите имя: ");
            String fname = scanner.next();
            statement1.setString(2, fname );
            System.out.println("Введите Отчество: ");
            String mname = scanner.next();
            statement1.setString(3, mname);
            System.out.println("Введите номер паспорта: ");
            long passnum = scanner.nextLong();
            statement1.setLong(4, passnum);
            System.out.println("Введите номер лицевого счета: ");
            long acnum = scanner.nextLong();
            statement1.setLong(5, acnum);
            System.out.println("Введите название улицы: ");
            String streetname = scanner.next();
            statement1.setString(6, streetname);
            System.out.println("Введите номер дома: ");
            int housenum = scanner.nextInt();
            statement1.setInt(7, housenum);
            System.out.println("Введите дату совершения операции: ");
            Date dateofoper = Date.valueOf(scanner.next());
            statement1.setDate(8, dateofoper);
            System.out.println("Введите сумму депозита: ");
            double depositsum = scanner.nextDouble();
            statement1.setDouble(9,depositsum);
            int resultOfSaving = statement1.executeUpdate();
            return resultOfSaving == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public ArrayList<SurnamesAndInitials> selectInitials() {
        ArrayList<SurnamesAndInitials> surnamesAndInitialsArrayList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = " select d.lastName, d.firstname, d.middlename FROM depositor d";

            // SELECT d.lastname || ' ' || substr(d.firstname,1,1) || '.' || substr(d.middlename,1,1) || '.' FROM depositor d

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String lname = resultSet.getString("lastname");
                String fname = resultSet.getString("firstname");
                String mname = resultSet.getString("middlename");

                String str = String.valueOf(fname.charAt(0));
                String str1 = String.valueOf(mname.charAt(0));

                Depositor d = new Depositor(lname, str, str1);
                SurnamesAndInitials surnamesAndInitials = new SurnamesAndInitials(d);
                surnamesAndInitialsArrayList.add(surnamesAndInitials);

            }
            return surnamesAndInitialsArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }




}
