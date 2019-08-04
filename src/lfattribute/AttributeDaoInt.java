/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfattribute;
import lfattribute.model.Attribute;
import java.sql.*;
/**
 *
 * @author teren
 */
interface AttributeDaoInt {
    public Boolean addAttribute(String p_att, String p_abv, String p_type);
    public Boolean updAttribute(Integer p_id, String p_att, String p_abv, String p_type);
    public Boolean delAttribute(Integer p_id);
    public ResultSet selAttribute();
}
