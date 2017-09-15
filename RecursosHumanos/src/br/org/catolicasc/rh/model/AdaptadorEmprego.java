
package br.org.catolicasc.rh.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorEmprego extends XmlAdapter<String, Emprego>{

	@Override
	public String marshal(Emprego v) throws Exception {
	
		return v.getEmpresa();
	}

	@Override
	public Emprego unmarshal(String v) throws Exception {
		
		 return new Emprego(null,v, v, null, null, v,null);
	}

   
}
