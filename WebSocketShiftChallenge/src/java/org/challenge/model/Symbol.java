/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.challenge.model;

/**
 *
 * @author GenDium
 */
public class Symbol {
    private String name;
    private double value;
    
    public Symbol()
    {
     this.name = "";
     this.value = 0.0;
    }
    
    public Symbol(String name)
    {
        this.name = name;
        this.value = new SymbolValueCollections().getValue(name);
    }
    
    public String getName(){
        return this.name;
    }
    public double getValue(){
        return this.value;
    }
    public void setNameAndValue(String name)
    {
        this.name = name;
        this.value = new SymbolValueCollections().getValue(name);
    }
}
