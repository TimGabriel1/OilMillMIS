package DAO;

import Model.MillingProduct;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MillingProductDAOImpl implements MillingProductDAO{
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<MillingProduct> list = null;
    MillingProduct millingProduct = null;
    PreparedStatement preparedStmt = null;
    @Override
    public MillingProduct get() {

        try {

            String sql = "select * from millingProduct ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            millingProduct = new MillingProduct();
            while (resultSet.next()) {
                millingProduct.setFibreOilCan(resultSet.getDouble("fibreOilCan"));
                millingProduct.setPalmOilDrum(resultSet.getInt("palmOilDrum"));
                millingProduct.setPalmOilCan(resultSet.getInt("palmOilCan"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return millingProduct;
    }

    @Override
    public Boolean update(MillingProduct millingProduct) {
        boolean flag = false;
        try {
            String sql = "update millingProduct set fibreOilCan = fibreOilCan +"+ millingProduct.getFibreOilCan() +
                    ", palmOilDrum = palmOilDrum +"+ millingProduct.getPalmOilDrum() +", palMOilCan = palmOilCan + "+ millingProduct.getPalmOilCan()  + " where id= 1";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean sellFibreOilCan(double number) {
        boolean flag = false;
        try {
            String sql = "update millingProduct set fibreOilCan = fibreOilCan -"+ number+ " where id= 1";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean sellPalmOilDrum(int number) {
        boolean flag = false;
        try {
            String sql = "update millingProduct set palmOilDrum = palmOilDrum -"+ number+ " where id= 1";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean sellPalmOilCan(int number) {
        boolean flag = false;
        try {
            String sql = "update millingProduct set palmOilCan = palmOilCan -"+ number+ " where id= 1";
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
