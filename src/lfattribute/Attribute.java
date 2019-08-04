/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfattribute.model;

/**
 *
 * @author Terence Brawley Copyright, all rights reserved.
 */
public class Attribute {
 private Integer Attribute_ID;
    private String Attribute;
    private String Attribute_Abbreviation;
    private String Attribute_Type;
    
    public Attribute() {
        this.Attribute_ID = 0;
        this.Attribute = "X";
        this.Attribute_Abbreviation = "XXX";
        this.Attribute_Type = "Undeclared";
    }
    
    public Attribute(Integer p_id, String p_att, String p_abv, String p_type) {
        this.Attribute_ID = p_id;
        this.Attribute = p_att;
        this.Attribute_Abbreviation = p_abv;
        this.Attribute_Type = p_type;
    }
    
    public int getAttribute_ID() {
        return this.Attribute_ID;
    }
    public String getAttribute() {
        return this.Attribute;
    }
    public String getAttribute_Abbreviation() {
        return this.Attribute_Abbreviation;
    }
    public String getAttribute_Type() {
        return this.Attribute_Type;
    }
    
    public void setAttribute(String p_att) {
        this.Attribute = p_att;
    }
    public void setAttribute_Abbreviation(String p_abv) {
        this.Attribute_Abbreviation = p_abv;
    }
    public void setAttribute_Type(String p_type) {
        this.Attribute_Type = p_type;
    }   
}
