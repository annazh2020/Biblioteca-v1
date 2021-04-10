package org.iesalandalus.programacion.biblioteca.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;

public class Alumnos {

	private List<Alumno> coleccionAlumnos;

	public Alumnos () {
		coleccionAlumnos=new ArrayList<>();
	}

	public List<Alumno> copiaProfundaAlumnos() {
		List<Alumno>copiaAlumnos=new ArrayList<>();
		for(Alumno alumno: coleccionAlumnos) {
			copiaAlumnos.add(new Alumno(alumno));
		}
		return copiaAlumnos;
	}

	public List<Alumno> get() {
		List<Alumno> copiaAlumnos=copiaProfundaAlumnos();
		copiaAlumnos.sort(Comparator.comparing(Alumno:: getNombre));
		return copiaAlumnos;
	}

	public int getTamano() {
		return coleccionAlumnos.size();
	}



	public void insertar(Alumno alumno)throws OperationNotSupportedException {
		if (alumno==null) {
			throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
		}
		if (!coleccionAlumnos.contains(alumno)) {
			coleccionAlumnos.add(new Alumno(alumno));
		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese correo.");
		}
	}

	public Alumno buscar(Alumno alumno) {
		if(alumno==null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar un alumno nulo.");
		}
		int indice=coleccionAlumnos.indexOf(alumno);
		if(indice==-1) {
			return null;
		}else {
			return new Alumno(coleccionAlumnos.get(indice));
		}
	}

	public void borrar(Alumno alumno) throws OperationNotSupportedException {
		if(alumno==null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar un alumno nulo.");
		}
		if(!coleccionAlumnos.contains(alumno)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alumno con ese correo.");
		}else {
			coleccionAlumnos.remove(alumno);
		}

	}


}
