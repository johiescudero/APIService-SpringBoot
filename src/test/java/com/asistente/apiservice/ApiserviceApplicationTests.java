package com.asistente.apiservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.ExamRepository;
import com.asistente.apiservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiserviceApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	/**
	 * TEST UNITARIO = CREACIÓN DE UN USUARIO 
	 */
	@Test
	public void crearUsuarioTest(){

		Users nuevoUser = new Users();
		nuevoUser.setName("TEST_1_CREATE_USER");
		nuevoUser.setPassword(encoder.encode("12345"));
		nuevoUser.setEmail("test-1@test.com");
		Users usuarioGuardado = userRepository.save(nuevoUser);
		assertTrue(usuarioGuardado.getEmail().equalsIgnoreCase(nuevoUser.getEmail()));
	}

	/**
	 * TEST UNITARIO = CREACIÓN DE UN EXAMEN FINAL  
	 */
	@Test
	public void crearFinaTest(){

		Exam newExam = new Exam();
		//Nombre de materia
		newExam.setMateria("Redes de Computadoras");
		//Fechas: Inicio de Estudio y Examen final
		Calendar fechaCalendar = Calendar.getInstance(); 
		fechaCalendar.set(Calendar.YEAR,2020);
		fechaCalendar.set(Calendar.MONTH, Calendar.AUGUST);
		fechaCalendar.set(Calendar.DAY_OF_MONTH,20);
		newExam.setInicioEstudioDate(fechaCalendar.getTime());
		fechaCalendar.set(Calendar.YEAR,2020);
		fechaCalendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
		fechaCalendar.set(Calendar.DAY_OF_MONTH,10);
		newExam.setFinalTestDate(fechaCalendar.getTime());

		Users usuario = userRepository.findByName("TEST_1_CREATE_USER");
		newExam.setUsuario(usuario);
		Exam examenGuardado = examRepository.save(newExam);
		assertTrue(examenGuardado.getMateria().equalsIgnoreCase(newExam.getMateria()));
	}

	/**
	 * TEST UNITARIO = CREACIÓN DE UNA PLANIFICACIÓN 
	 
	@Test
	public void crearPlanificacionTest(){

		Users nuevaPlanificacion = new Users();
		nuevoUser.setName("Test_2");
		nuevoUser.setPassword(encoder.encode("12345"));
		nuevoUser.setEmail("test-2@gmail.com");
		Users usuarioGuardado = userRepository.save(nuevoUser);
		assertTrue(usuarioGuardado.getEmail().equalsIgnoreCase(nuevoUser.getEmail()));
	}
	*/
	
}
