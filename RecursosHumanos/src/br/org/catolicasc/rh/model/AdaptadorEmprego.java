/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rh.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorEmprego extends XmlAdapter<String, Emprego>{

    @Override
    public Emprego unmarshal(String v) throws Exception {
    	 return new Emprego(Long.MAX_VALUE,v, v, null, null, v,null);
    }

    @Override
    public String marshal(Emprego v) throws Exception {
       return v.getEmpresa();
    }
}
