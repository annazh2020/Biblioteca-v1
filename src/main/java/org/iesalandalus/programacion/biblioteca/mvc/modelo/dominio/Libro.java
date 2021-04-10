package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;

import java.util.Objects;

public class Libro {
	
	private static final int PAGINAS_PARA_RECOMPENSA=25;
	private static final float PUNTOS_PREMIO=0.5f;
	
	private String titulo;
	private String autor;
	private int numPaginas;
	
	public Libro(String titulo, String autor, int numPaginas) {
		setTitulo(titulo);
		setAutor(autor);
		setNumPaginas(numPaginas);
	}
	
	public Libro(Libro libro) {
		if (libro==null) {
			throw new NullPointerException("ERROR: No es posible copiar un libro nulo.");
		}
		this.titulo=libro.titulo;
		this.autor=libro.autor;
		this.numPaginas=libro.numPaginas;
	}
	
	public static Libro getLibroFicticio (String titulo, String autor) {
		return new Libro (titulo, autor, 275);
	}
	
	public float getPuntos() {
		int resultado=numPaginas/PAGINAS_PARA_RECOMPENSA;
		return PUNTOS_PREMIO*(resultado+1);
	}
	
	private void setTitulo(String titulo) {
		if (titulo == null) {
			throw new NullPointerException("ERROR: El título no puede ser nulo.");
		}
		if (titulo.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El título no puede estar vacío.");
		}
		this.titulo = titulo;
	}
	
	private void setAutor(String autor) {
		if (autor == null) {
			throw new NullPointerException("ERROR: El autor no puede ser nulo.");
		}
		if (autor.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El autor no puede estar vacío.");
		}
		this.autor = autor;
	}
	
	private void setNumPaginas(int numPaginas) {
		if (numPaginas <=0) {
			throw new IllegalArgumentException("ERROR: El número de páginas debe ser mayor que cero.");
		}
		
		this.numPaginas = numPaginas;
	}
	
	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(autor,titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Libro)) {
			return false;
		}
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return String.format("título=%s, autor=%s, número de páginas=%s", titulo, autor, numPaginas);
	}
	
	
}
