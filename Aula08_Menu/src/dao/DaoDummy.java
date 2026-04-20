package dao;

import java.util.ArrayList;
import java.util.List;

import entidade.Pato;

public class DaoDummy {
	
	List<Pato> patos = new ArrayList<>();
	
	public void salvaPatos(List<Pato> patos) {
		this.patos = patos;
	}
	
	public List<Pato> loadPatos(){
		return patos;
	}

}
