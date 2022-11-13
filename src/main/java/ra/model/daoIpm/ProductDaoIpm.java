package ra.model.daoIpm;

import ra.model.dao.ProductDao;
import ra.model.emtity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import static sun.rmi.transport.TransportConstants.Call;

public class ProductDaoIpm implements ProductDao<Product, Integer> {
    @Override
    public List<Product> searchByName(String name) {
        Connection con = null;
        CallableStatement cast = null;
        List<Product>productList= null;
        try {
            con= ConnectionDB.openConnection();
            cast= con.prepareCall("{call searchByName(?)}");
            cast.setString(1,name);
            ResultSet rs =cast.executeQuery();
            productList =new ArrayList<>();
            while (rs.next()){
                Product pr=new Product();
                pr.setProductId(rs.getInt("productId"));
                pr.setProductName(rs.getString("productName"));
                pr.setProductPrice(rs.getFloat("price"));
                pr.setDateCreated(rs.getDate("createdDate"));
                pr.setDescriptions(rs.getString("descriptions"));
                pr.setProductStatus(rs.getBoolean("productStatus"));
                productList.add(pr);
            }
        }catch (Exception exx){
            exx.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return productList;
    }

    @Override
    public List<Product> searchByPrice(float value1, float value2) {
        Connection con = null;
        CallableStatement cast = null;
        List<Product>productList= null;
        try {
            con= ConnectionDB.openConnection();
            cast= con.prepareCall("{call searchByPrice(?,?)}");
            cast.setFloat(1,value1);
            cast.setFloat(2,value2);
            ResultSet rs =cast.executeQuery();
            productList =new ArrayList<>();
            while (rs.next()){
                Product pr=new Product();
                pr.setProductId(rs.getInt("productId"));
                pr.setProductName(rs.getString("productName"));
                pr.setProductPrice(rs.getFloat("price"));
                pr.setDateCreated(rs.getDate("createdDate"));
                pr.setDescriptions(rs.getString("descriptions"));
                pr.setProductStatus(rs.getBoolean("productStatus"));
                productList.add(pr);
            }
        }catch (Exception exx){
            exx.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return productList;
    }

    @Override
    public List<Product> sortByPrice() {
        Connection con = null;
        CallableStatement cast = null;
        List<Product>productList= null;
        try {
            con= ConnectionDB.openConnection();
            cast= con.prepareCall("{call sortByPrice()}");
            ResultSet rs =cast.executeQuery();
            productList =new ArrayList<>();
            while (rs.next()){
                Product pr=new Product();
                pr.setProductId(rs.getInt("productId"));
                pr.setProductName(rs.getString("productName"));
                pr.setProductPrice(rs.getFloat("price"));
                pr.setDateCreated(rs.getDate("createdDate"));
                pr.setDescriptions(rs.getString("descriptions"));
                pr.setProductStatus(rs.getBoolean("productStatus"));
                productList.add(pr);
            }
        }catch (Exception exx){
            exx.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return productList;
    }

    @Override
    public List<Product> getAll() {
        Connection con = null;
        CallableStatement cast = null;
        List<Product>productList= null;
        try {
            con= ConnectionDB.openConnection();
            cast= con.prepareCall("{call getAll()}");
            ResultSet rs =cast.executeQuery();
            productList =new ArrayList<>();
            while (rs.next()){
                Product pr=new Product();
                pr.setProductId(rs.getInt("productId"));
                pr.setProductName(rs.getString("productName"));
                pr.setProductPrice(rs.getFloat("price"));
                pr.setDateCreated(rs.getDate("createdDate"));
                pr.setDescriptions(rs.getString("descriptions"));
                pr.setProductStatus(rs.getBoolean("productStatus"));
                productList.add(pr);
            }
        }catch (Exception exx){
            exx.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection con =null;
        CallableStatement cast =null;
        boolean check = true;
        try {
            con= ConnectionDB.openConnection() ;
            cast=con.prepareCall("{call insertProduct(?,?,?,?,?)}");
            cast.setString(1,product.getProductName());
            cast.setFloat(2,product.getProductPrice());
            cast.setDate(3,new Date(product.getDateCreated().getTime()));
            cast.setString(4,product.getDescriptions());
            cast.setBoolean(5,product.isProductStatus());
            cast.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            check=false;
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return check;
    }

    @Override
    public boolean update(Product product) {
        Connection con =null;
        CallableStatement cast =null;
        boolean check = true;
        try {
            con= ConnectionDB.openConnection() ;
            cast=con.prepareCall("{call updateProduct(?,?,?,?,?,?)}");
            cast.setInt(1,product.getProductId());
            cast.setString(2,product.getProductName());
            cast.setFloat(3,product.getProductPrice());
            cast.setDate(4,new Date(product.getDateCreated().getTime()));
            cast.setString(5,product.getDescriptions());
            cast.setBoolean(6,product.isProductStatus());
            cast.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            check=false;
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return check;
    }

    @Override
    public boolean delete(Integer id) {
        Connection con =null;
        CallableStatement cast=null;
        boolean check=true;
        try {
            con= ConnectionDB.openConnection();
            cast=con.prepareCall("{call deleteProduct(?)}");
            cast.setInt(1,id);
            cast.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            check=false;
        }finally {
            ConnectionDB.closeConnection(con,cast);
        }
        return check;
    }

    @Override
    public Product getById(Integer id) {
       Connection con =null;
       CallableStatement cast=null;
       Product pr=null;
       try {
           con= ConnectionDB.openConnection();
           cast=con.prepareCall("{call getById(?)}");
           cast.setInt(1,id);
           pr=new Product();
           ResultSet rs= cast.executeQuery();
           if (rs.next()){
               pr=new Product();
               pr.setProductId(rs.getInt("productId"));
               pr.setProductName(rs.getString("productName"));
               pr.setProductPrice(rs.getFloat("price"));
               pr.setDateCreated(rs.getDate("createdDate"));
               pr.setDescriptions(rs.getString("descriptions"));
               pr.setProductStatus(rs.getBoolean("productStatus"));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           ConnectionDB.closeConnection(con,cast);
       }
       return pr;
    }
}
