//package com.asistente.apiservice;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.asistente.apiservice.models.Exam;
//import com.asistente.apiservice.models.Goal;
//import com.asistente.apiservice.models.Mode;
//import com.asistente.apiservice.models.Planning;
//import com.asistente.apiservice.models.Users;
//import com.asistente.apiservice.repository.ExamRepository;
//import com.asistente.apiservice.repository.GoalRepository;
//import com.asistente.apiservice.repository.ModeRepository;
//import com.asistente.apiservice.repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import com.asistente.apiservice.services.PlanningService;

//import static org.junit.jupiter.api.Assertions.assertTrue;
//import java.util.Calendar;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//class ApiserviceApplicationTests {

	//@Autowired
	//private UserRepository userRepository;

//	@Autowired
//	private ExamRepository examRepository;

	//@Autowired
	//private PlanningService planningService; 

	//@Autowired
	//private GoalRepository goalRepository;

	//@Autowired
	//private ModeRepository modeRepository;

	//@Autowired
	//private BCryptPasswordEncoder encoder;

	//@Test
	//void contextLoads() {
	//}

	/**
	 * TEST UNITARIO = CREACIÓN DE UN USUARIO 
	
	@Test
	public void crearUsuarioTest(){

		Users nuevoUser = new Users();
		nuevoUser.setName("TEST_2_CREATE_USER");
		nuevoUser.setPassword(encoder.encode("12345"));
		nuevoUser.setEmail("test-2@test.com");
		Users usuarioGuardado = userRepository.save(nuevoUser);
		assertTrue(usuarioGuardado.getEmail().equalsIgnoreCase(nuevoUser.getEmail()));
	} */

	/**
	 * TEST UNITARIO = CREACIÓN DE UN EXAMEN FINAL  
	 
	@Test
	public void crearFinaTest(){

		Exam newExam = new Exam();
		//Nombre de materia
		newExam.setMateria("Sistemas Operativos");
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

		Users usuario = userRepository.findByName("TEST_1_POSTMAN_CREATE_USER");
		newExam.setUsuario(usuario);
		Exam examenGuardado = examRepository.save(newExam);
		assertTrue(examenGuardado.getMateria().equalsIgnoreCase(newExam.getMateria()));
	}*/
	/**
	 * TEST UNITARIO = CREACIÓN DE UNA PLANIFICACIÓN 
	
//	@Test
	/**public void crearPlanificacionTest(){

		Exam newExamWithPlanning = new Exam();
		//Nombre de materia
		newExamWithPlanning.setMateria("Redes de Computadoras");
		//Fechas: Inicio de Estudio y Examen final
		Calendar fechaCalendar = Calendar.getInstance(); 
		fechaCalendar.set(Calendar.YEAR,2020);
		fechaCalendar.set(Calendar.MONTH, Calendar.AUGUST);
		fechaCalendar.set(Calendar.DAY_OF_MONTH,20);
		newExamWithPlanning.setInicioEstudioDate(fechaCalendar.getTime());
		fechaCalendar.set(Calendar.YEAR,2020);
		fechaCalendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
		fechaCalendar.set(Calendar.DAY_OF_MONTH,10);
		newExamWithPlanning.setFinalTestDate(fechaCalendar.getTime());

		Users usuario = userRepository.findByName("TEST_1_CREATE_USER");
		newExamWithPlanning.setUsuario(usuario);
		Exam examenGuardado = examRepository.save(newExamWithPlanning);
		
		//Añadir algunos objetivos
		Goal newGoal1 = new Goal();
		newGoal1.setExam(newExamWithPlanning);
		newGoal1.setObjetivo("Repasar temas de cursada");
		goalRepository.save(newGoal1);
		
		Goal newGoal2 = new Goal();
		newGoal2.setExam(newExamWithPlanning);
		newGoal2.setObjetivo("Estudiar capítulo de seguridad");
		goalRepository.save(newGoal2);
		
		Goal newGoal3 = new Goal();
		newGoal3.setExam(newExamWithPlanning);
		newGoal3.setObjetivo("Hacer ejercicios de finales");
		goalRepository.save(newGoal3);


		//Selecciono el modo con el cuál se planificara
		Mode modoFinal = new Mode();
		modoFinal.setModo("Rápido");
		modeRepository.save(modoFinal);
		Mode modoFinal = modeRepository.findByModo("Rápido").get(0);
		Planning planningGuardada = planningService.crearPlanificacion(1, modoFinal);
		
		assertTrue(planningGuardada.getModo().equals(modoFinal)); 
		 
	}
	*/	
	
//}

