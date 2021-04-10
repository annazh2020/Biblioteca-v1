package org.iesalandalus.programacion.biblioteca.mvc.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Curso;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {
	
	private Consola() {	
	}
	
	public static void mostrarMenu() {
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		String formatoStr = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(formatoStr, 0).replace("0", "-"));
	}
	
	public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opción: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
	}
	
	public static Alumno leerAlumno() {
		System.out.print("Introduce el nombre del alumno: ");
		String nombre = Entrada.cadena();
		System.out.print("Introduce el correo del alumno: ");
		String correo = Entrada.cadena();
		int curso=0;
		while(curso<1 ||curso>4) {
			System.out.print("Introduce el curso del alumno: [1.-PRIMERO, 2.-SEGUNDO, 3.-TERCERO, 4.-CUARTO]");
			curso=Entrada.entero();
		}
		return new Alumno(nombre,correo,Curso.values()[curso-1]);
	}
	
	public static Alumno leerAlumnoFicticio() {
		System.out.print("Introduce el correo del alumno: ");
		return Alumno.getAlumnoFicticio(Entrada.cadena());
	}
	
	public static Libro leerLibro() {
		System.out.print("Introduce el título del libro: ");
		String titulo = Entrada.cadena();
		System.out.print("Introduce el autor del libro: ");
		String autor = Entrada.cadena();
		System.out.print("Introduce el número de páginas del libro: ");
		int numPaginas = Entrada.entero();
		return new Libro(titulo, autor, numPaginas);
	}
	
	public static Libro leerLibroFicticio() {
		System.out.print("Introduce el título del libro: ");
		String titulo = Entrada.cadena();
		System.out.print("Introduce el autor del libro: ");
		String autor = Entrada.cadena();
		return Libro.getLibroFicticio(titulo,autor);
	}
	
	
	
	public static LocalDate leerFecha(String mensaje) {
		System.out.print(mensaje);
		String fechaLeida=Entrada.cadena();
		LocalDate fecha=null;
		try {
			fecha=LocalDate.parse(fechaLeida, Prestamo.FORMATO_FECHA);
		}catch(DateTimeParseException e) {
			throw new IllegalArgumentException("ERROR: El formato de fecha no es correcto.");
		}
		return fecha;
	}
	
	
	
	public static Prestamo leerPrestamo() {
		Alumno alumno = leerAlumnoFicticio();
		Libro libro = leerLibro();
		LocalDate fechaPrestamo = leerFecha("Introduce la fecha");
		return new Prestamo(alumno, libro, fechaPrestamo);
	}
	
	public static Prestamo leerPrestamoFicticio() {
		return Prestamo.getPrestamoFicticio(leerAlumno(),leerLibro());
	}


}
