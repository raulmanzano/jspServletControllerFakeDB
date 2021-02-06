package es.manzano.ejemplo.jspjdbc.business;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.manzano.ejemplo.jspjdbc.model.Primaria;

public class BusinessDelegate {	
	private static final Logger logger = LoggerFactory.getLogger(BusinessDelegate.class);
	
	private TreeMap<Integer,Primaria> almacen= null;
	private int contador=0;
	public BusinessDelegate() {
		super();
		this.almacen = new TreeMap<Integer,Primaria>();		
		this.almacen.put(1,(new Primaria(1,"unoC1","unoC2","unoC3")));
		this.almacen.put(2,(new Primaria(2,"dosC1","dosC2","dosC3")));
		this.almacen.put(3,(new Primaria(3,"tresC1","tresC2","tresC3")));
		contador=3;
	}
	
	
	public List<Primaria> getAllPrimaria() {
		//logger.info("getAllPrimaria()");		
		return new ArrayList<Primaria>(almacen.values());
	}
	public void insertarPrimaria(Primaria parametro) {
		//logger.info("insertarPrimaria()");
		contador++;
		parametro.setId(contador);
		almacen.put(parametro.getId(),parametro);
	}


	public Primaria getById(String parameter) {
		return almacen.get(Integer.valueOf(parameter));
	}


	public void delete(String parameter) {
		almacen.remove(Integer.valueOf(parameter));		
	}


	public void updatePrimaria(Primaria primaria) {
		almacen.remove(primaria.getId());
		almacen.put(primaria.getId(),primaria);

	}

}
