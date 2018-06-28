/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.challenge.model;

import java.util.HashMap;

/**
 *
 * @author GenDium
 */
public class SymbolValueCollections {
    private HashMap<String, Double> symbolValueMap;
    public SymbolValueCollections()
    {
        HashMap<String, Double> svc = new HashMap();
        //symbol pairs with values providing conversion rates
        //hard-coded values
        svc.put("BTCUSD",6124.45 );
        svc.put("ETHUSD",438.00 );
        svc.put("XRPUSD", .460357);
        svc.put("BCHUSD", 701.73);
        svc.put("USDBTC", 0.000164472);
        svc.put("USDETH", 0.002308615);
        svc.put("USDXRP", 2.180435389);
        svc.put("USDBCH", 0.001438021);
        svc.put("BTCETH", 13.98282641);
        svc.put("BTCXRP", 13304.00);
        svc.put("BTCBCH", 8.72766941);
        svc.put("ETHBTC", 0.07151630);
        svc.put("XRPBTC", 0.00007517);
        svc.put("BCHBTC", 0.11457813);
        svc.put("ETHXRP", 951.43117189);
        svc.put("ETHBCH", 0.62417062);
        svc.put("XRPETH", 0.00105105);
        svc.put("BCHETH", 1.60212604);
        svc.put("XRPBCH", 0.00065603);
        svc.put("BCHXRP", 1524.00);
        this.symbolValueMap = svc;
    }
    public double getValue(String symbolPair)
    {
        return this.symbolValueMap.get(symbolPair);
    }
}
