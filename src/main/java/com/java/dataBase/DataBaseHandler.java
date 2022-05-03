package com.java.dataBase;
import com.java.product.Fruit;
import com.java.product.Oversize;
import com.java.product.Supermarket;
import com.java.product.Toy;

import java.sql.*;
import java.sql.Connection;

public class DataBaseHandler extends ConfigsDB{
    Connection dbConnection;

    public DataBaseHandler(){

        try {
            getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("dbConnection dont create in construct");
            e.printStackTrace();
        }
    }

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        //jdbc:postgresql://localhost:5432/Prog
        System.out.println("connectionString= " + connectionString);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return null;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }

        if (dbConnection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return dbConnection;

    }

    public int getCountProductsTable(){
        ResultSet resultSet = null;
        String select="SELECT COUNT(*) FROM "+ConstDB.PRODUCTS_TABLE;
        if(dbConnection!=null){
            System.out.println("Connection Successful !");
        }
        else {
            System.out.println("Not Connection!");
            return 0;
        }
        Statement statement=null;
        try {
             statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not createStatement!");
        }

        try {
            resultSet=statement.executeQuery(select);
        } catch (SQLException e) {
            System.out.println("Not select!");
            e.printStackTrace();
        }
        String countStr;
        int count = 0;
        try {
            if(resultSet.next())
                count =resultSet.getInt("count");
        } catch (SQLException e) {
            System.out.println("Not getCount!");
            e.printStackTrace();
        }

        return count;
    }

    public void setDBSuper(Supermarket supermarket){
        String insert="INSERT INTO "+ConstDB.PRODUCTS_TABLE+"("+
                ConstDB.PRODUCTS_TABLE_DEPARTMENT_NAME+","+
                ConstDB.PRODUCTS_TABLE_PRODUCT_NAME+","+
                ConstDB.PRODUCTS_TABLE_PRODUCING_COUNTRY+","+
                ConstDB.PRODUCTS_TABLE_RETAIL_PRICE+")"+
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setString(1, supermarket.getDepartmentName());
            prSt.setString(2, supermarket.getProductName());
            prSt.setString(3, supermarket.getCountry());
            prSt.setDouble(4, supermarket.getPrice());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }

    public void setDB(Toy toy){
        setDBSuper(toy.getSupermarket());
        String insert="INSERT INTO "+ConstDB.TOYS_TABLE+"("+
                ConstDB.TOYS_TABLE_AGE_GROUP+","+
                ConstDB.TOYS_TABLE_TYPE+","+
                ConstDB.TOYS_TABLE_FK_ID_PRODUCT+")"+
                "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setDouble(1, toy.getAgeGroup());
            prSt.setString(2, toy.getType());
            prSt.setInt(   3, getCountProductsTable()-1);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }
    public void setDB(Fruit fruit){
        setDBSuper(fruit.getSupermarket());
        String insert="INSERT INTO "+ConstDB.FRUITS_TABLE+"("+
                ConstDB.FRUITS_TABLE_TIME_DAYS+","+
                ConstDB.FRUITS_TABLE_TEMPERATURE+","+
                ConstDB.FRUITS_TABLE_FK_ID_PRODUCT+")"+
                "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setInt(1, fruit.getTime());
            prSt.setDouble(2, fruit.getTemperature());
            prSt.setInt(   3, getCountProductsTable()-1);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }
    public void setDB(Oversize oversize){
        setDBSuper(oversize.getSupermarket());
        String insert="INSERT INTO "+ConstDB.OVERSIZES_TABLE+"("+
                ConstDB.OVERSIZES_TABLE_HEIGHT+","+
                ConstDB.OVERSIZES_TABLE_WIDTH+","+
                ConstDB.OVERSIZES_TABLE_LENGTH+","+
                ConstDB.OVERSIZES_TABLE_FK_ID_PRODUCT+")"+
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setDouble(1, oversize.getHeight());
            prSt.setDouble(2, oversize.getWidth());
            prSt.setDouble(3, oversize.getLength());
            prSt.setInt(   4, getCountProductsTable()-1);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }
    private ResultSet getResultSet(String sql)throws SQLException {
        ResultSet resultSet = null;
        Statement statement=dbConnection.createStatement();
        resultSet=statement.executeQuery(sql);
        return resultSet;
    }
    public ResultSet getToys()  {
        String select=
                "SELECT " +
                ConstDB.PRODUCTS_TABLE_DEPARTMENT_NAME+","+
                ConstDB.PRODUCTS_TABLE_PRODUCT_NAME+","+
                ConstDB.PRODUCTS_TABLE_PRODUCING_COUNTRY+","+
                ConstDB.PRODUCTS_TABLE_RETAIL_PRICE+","+
                ConstDB.TOYS_TABLE_AGE_GROUP+","+
                ConstDB.TOYS_TABLE_TYPE+
                " FROM "+ConstDB.PRODUCTS_TABLE+
                        ","+
                ConstDB.TOYS_TABLE+
                " WHERE "+ ConstDB.PRODUCTS_TABLE+"."+ConstDB.PRODUCTS_TABLE_ID_PRODUCT+
                "="+
                ConstDB.TOYS_TABLE+"."+ConstDB.TOYS_TABLE_FK_ID_PRODUCT;
        try {
            System.out.println("getToys)!!!");
            return getResultSet(select);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Dont getToys(");
            return null;
        }
    }
    public ResultSet getFruits()  {
        String select=
                "SELECT " +
                        ConstDB.PRODUCTS_TABLE_DEPARTMENT_NAME+","+
                        ConstDB.PRODUCTS_TABLE_PRODUCT_NAME+","+
                        ConstDB.PRODUCTS_TABLE_PRODUCING_COUNTRY+","+
                        ConstDB.PRODUCTS_TABLE_RETAIL_PRICE+","+
                        ConstDB.FRUITS_TABLE_TIME_DAYS+","+
                        ConstDB.FRUITS_TABLE_TEMPERATURE+
                        " FROM "+ConstDB.PRODUCTS_TABLE+","+
                        ConstDB.FRUITS_TABLE+
                        " WHERE "+ ConstDB.PRODUCTS_TABLE+"."+ConstDB.PRODUCTS_TABLE_ID_PRODUCT+
                        "="+
                        ConstDB.FRUITS_TABLE+"."+ConstDB.FRUITS_TABLE_FK_ID_PRODUCT;
        try {
            System.out.println("getFruits)!!!");
            return getResultSet(select);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Dont getFruits(");
            return null;
        }
    }
    public ResultSet getOversizes()  {
        String select=
                "SELECT " +
                        ConstDB.PRODUCTS_TABLE_DEPARTMENT_NAME+","+
                        ConstDB.PRODUCTS_TABLE_PRODUCT_NAME+","+
                        ConstDB.PRODUCTS_TABLE_PRODUCING_COUNTRY+","+
                        ConstDB.PRODUCTS_TABLE_RETAIL_PRICE+","+
                        ConstDB.OVERSIZES_TABLE_HEIGHT+","+
                        ConstDB.OVERSIZES_TABLE_WIDTH+","+
                        ConstDB.OVERSIZES_TABLE_LENGTH+
                        " FROM "+ConstDB.PRODUCTS_TABLE+","+
                        ConstDB.OVERSIZES_TABLE+
                        " WHERE "+ ConstDB.PRODUCTS_TABLE+"."+ConstDB.PRODUCTS_TABLE_ID_PRODUCT+
                        "="+
                        ConstDB.OVERSIZES_TABLE+"."+ConstDB.OVERSIZES_TABLE_FK_ID_PRODUCT;
        try {
            System.out.println("getOversizes)!!!");
            return getResultSet(select);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Dont getOversizes(");
            return null;
        }
    }

}
