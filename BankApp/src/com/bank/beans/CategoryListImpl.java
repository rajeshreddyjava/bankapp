package com.bank.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class CategoryListImpl {
	
    public Map<Integer, HashMap<Integer, CategoryDetails>> getCategoryStartandEndDates() throws Exception {
		 Map<Integer, HashMap<Integer,CategoryDetails>> categoryMap = null;
		try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection conn = DriverManager.getConnection
          ("jdbc:derby://localhost:1527/holidaydb","holidayuser","password");
          Statement stmt = conn.createStatement();
          String query = "select T2565_LBR_CGY_CD,T2695_LBR_SCG_ID,CTT_DT_CTL_RUL_OFS_1_DAY_CNT,CTT_DT_CTL_RUL_OFS_2_DAY_CNT" +
                            " from holidaydb.T6914_CTT_DT_CTL_RUL_EXU ";
          ResultSet rs =  stmt.executeQuery(query);
          categoryMap = new HashMap<Integer, HashMap<Integer,CategoryDetails>>();
          int category = 0;
          int subCategory = 0;
          HashMap<Integer,CategoryDetails> subCategoryMap = null;
          while(rs.next()){
        	  CategoryDetails categoryDetails = new CategoryDetails();
        	  categoryDetails.setJobStartDate(rs.getInt("CTT_DT_CTL_RUL_OFS_1_DAY_CNT"));
        	  categoryDetails.setJobEndDate(rs.getInt("CTT_DT_CTL_RUL_OFS_2_DAY_CNT"));
        	   category = rs.getInt("T2565_LBR_CGY_CD");
        	   subCategory = rs.getInt("T2695_LBR_SCG_ID");
        	  if(categoryMap.containsKey(category)){
        		  categoryMap.get(category).put(subCategory,categoryDetails );
        	  }
        	  else{
        		  subCategoryMap =  new HashMap<Integer,CategoryDetails>(); 
        		  subCategoryMap.put(subCategory, categoryDetails);
        		  categoryMap.put(category,subCategoryMap);
        	  }
             }
        }
        catch (SQLException sqlexception) {
            // TODO Auto-generated catch block
            sqlexception.printStackTrace();
        }catch (IllegalArgumentException illegalexception) {
        // TODO Auto-generated catch block
        illegalexception.printStackTrace();
    }
        return categoryMap;

    }

}

