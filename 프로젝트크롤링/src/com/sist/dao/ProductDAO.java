package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.vo.*;


public class ProductDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	   private static ProductDAO dao;
	   
	   public ProductDAO() {
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	      } catch (Exception e) {
	         // TODO: handle exception
	      }
	   }
	   public static ProductDAO newInstance() {
	      if(dao==null)
	         dao= new ProductDAO();
	      return dao;
	   }
	   
	   public void getConnection() {
	      try {
	         conn = DriverManager.getConnection(URL, "hr_1","happy");
	      } catch (Exception e) {
	         // TODO: handle exception
	      }
	   }
	   public void disConnection() {
	      try {
	         if(conn != null) conn.close();
	         if(ps != null) ps.close();
	      } catch (Exception e) {
	         // TODO: handle exception
	      }
	   }
	   
	   /*
	   PRODUCT_NO         NUMBER
	   PRODUCT_NAME      VARCHAR2(100 BYTE)
	   PRODUCT_INTRO      VARCHAR2(200 BYTE)
	   PRODUCT_POSTER   VARCHAR2(300 BYTE)
	   PRICE                  NUMBER
	   SALE                     VARCHAR2(200 BYTE)
	   DELIVER               VARCHAR2(200 BYTE)
	   HIT                     NUMBER
	   CATEGORY            VARCHAR2(30 BYTE)
	    */
	   public void productInsert(ProductVO vo)
	   {
	      try {
	         getConnection();
	         String sql = "INSERT INTO product VALUES(product_seq.nextval,"
	               + "?,' ',?,?,?,?,0,?)";
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, vo.getName());
	         ps.setString(2, vo.getPoster());
	         ps.setString(3, vo.getPrice());
	         ps.setString(4, vo.getSale());
	         ps.setString(5, vo.getDeliver());
	         ps.setString(6, vo.getCategory());
	         ps.executeUpdate();
	         
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally
	      {
	         disConnection();
	      }
	   }
	   
	}
