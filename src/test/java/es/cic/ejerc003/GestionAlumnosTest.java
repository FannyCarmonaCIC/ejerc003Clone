package es.cic.ejerc003;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class GestionAlumnosTest {

	GestionAlumnos gestAlum = new GestionAlumnos();

	@Test
	void testCrearAlumno() {
		gestAlum.crearAlumno(998, "Prueba", 8, "pr@pr.es");
		List<Alumnos> listado = gestAlum.crearAlumno(999, "Test", 9, "test@test.es");

		assertEquals(999, listado.get(listado.size() - 1).id, 0.000001);
		assertEquals("Test", listado.get(listado.size() - 1).nombre);
		assertEquals(9, listado.get(listado.size() - 1).nota, 0.000001);
		assertEquals("test@test.es", listado.get(listado.size() - 1).contacto);
	}

	@Test
	void testEliminarAlumno() {
		int id = 999; // Asigna valor a la variable id
		boolean validacion = true; // Inicializa validación con el valor true
		List<Alumnos> listado = gestAlum.eliminarAlumno(id); // listado = a la lista sin el alumno con id 999

		for (Alumnos l : listado) {
			if (l.getId() == id) { // Si el id coincide con algún alumno de la lista, el alumno no se ha eliminado
				validacion = false; // por lo que validación pasa a false
			}
		}
		assertTrue(validacion); // validacion = true porque el alumno no existe en la lista.

		id = 998; // Cambia el valor de id
		validacion = false;
		for (Alumnos l : listado) { // recorre la lista
			if (l.getId() == id) { // Si los id coinciden, validacion cambia a true
				validacion = true;
			}
		}
		assertTrue(validacion); // Como el array está vacío, nunca encuentra el id 998, por lo que validacion nunca cambia a true
		gestAlum.eliminarAlumno(id);
	}


}
