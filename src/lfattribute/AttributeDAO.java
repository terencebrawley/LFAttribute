/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfattribute;
import java.sql.*;
import lfattribute.model.Attribute;
/**
 *
 * @author teren
 */
public class AttributeDAO implements AttributeDaoInt{
    
    private Connection con;
    
    private void getConnection() {
        try{  
              Class.forName("oracle.jdbc.OracleDriver");
        } catch(Exception e) {System.out.println("Driver Problem " + e);}
        try {
            //step2 create  the connection object  
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.77:1521:lifeforce","lifeforce","lifeforce");
        } catch(Exception e){ System.out.println(e);}
        if (con == null) {
                System.out.println("Not Connected.  Sad Face.");
            }
    }
    
    public Boolean addAttribute(String p_att, String p_abv, String p_type) {
        boolean ok = false;
        
        this.getConnection();
        String sqlString = "insert into attributes (attribute_id, attribute, attribute_abbreviation, attribute_type) " +
                "values (attribute_seq.nextval, " + "'" + p_att + "','"  + p_abv + "','" + p_type + "')";
        
        System.out.println("SQL is:  " + sqlString);
        
        PreparedStatement prep = null;
        ResultSet result = null;
        
        try {
            prep = con.prepareStatement(sqlString);
            result = prep.executeQuery();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(result != null) result.close();
                if(prep != null) prep.close();
                con.close();
                ok = true;
            } catch(Exception ex){}
        
    }
        return ok;
    }
    
    public Boolean updAttribute(Integer p_id, String p_att, String p_abv, String p_type) {
        boolean ok = false;
        this.getConnection();
        String sqlString = "update attributes set attribute = '" + p_att +
                "', attribute_abbreviation = '" + p_abv + "', attribute_type = '" + p_type + 
                "' where attribute_id = " + p_id;
        
        System.out.println("SQLString is:  " + sqlString);
        PreparedStatement prep = null;
        ResultSet result = null;
        
        try {
            prep = con.prepareStatement(sqlString);
            result = prep.executeQuery();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(result != null) result.close();
                if(prep != null) prep.close();
                con.close();
                ok = true;
            } catch(Exception ex){}
    }
        return ok;
    }
    
    public Boolean delAttribute(Integer p_id) {
        boolean ok = false;
        
        this.getConnection();
        String sqlString = "delete attributes where attribute_id = " + p_id;
        
        PreparedStatement prep = null;
        ResultSet result = null;
        
        try {
            prep = con.prepareStatement(sqlString);
            result = prep.executeQuery();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(result != null) result.close();
                if(prep != null) prep.close();
                con.close();
                ok = true;
            } catch(Exception ex){}
    }
        return ok;
    }
    
    public ResultSet selAttribute() {
        boolean ok = false;
        this.getConnection();
        String sqlString = "select * from attributes";
        
        PreparedStatement prep = null;
        ResultSet result = null;
        
        try {
            prep = con.prepareStatement(sqlString);
            result = prep.executeQuery();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return result;
}
}
