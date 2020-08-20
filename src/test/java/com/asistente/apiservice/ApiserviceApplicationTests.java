package com.asistente.apiservice;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.models.FinalTest;
import com.asistente.apiservice.repository.UserRepository;
import com.asistente.apiservice.repository.FinalTestRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiserviceApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FinalTestRepository finalTestRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void crearUsuarioTest(){

		Users nuevoUser = new Users();
		nuevoUser.setName("Test_1");
		nuevoUser.setPassword(encoder.encode("12345"));
		nuevoUser.setEmail("test-1@gmail.com");
		Users usuarioGuardado = userRepository.save(nuevoUser);
		assertTrue(usuarioGuardado.getEmail().equalsIgnoreCase(nuevoUser.getEmail()));
	}

	@Test
	public void crearFinalTest(){
		
		FinalTest newFinalTest = new FinalTest();
		
		//Creo un nuevo usuario
		Users newUser = new Users();
		newUser.setName("Test_2");
		newUser.setPassword(encoder.encode("12345"));
		newUser.setEmail("test-2@gmail.com");
		Users retorno = userRepository.save(newUser);
		
		//Configuro el examen con los datos del usuario anteriormente creado
		newFinalTest.setMateria("Ingeniera en Aplicaciones Web");
		newFinalTest.setIdUser(retorno.getIdUser());
		Calendar calendario = Calendar.getInstance();
		//Fecha Inicio de Estudio
		calendario.set(Calendar.YEAR,2020);
		calendario.set(Calendar.MONTH,8);
		calendario.set(Calendar.DAY_OF_MONTH,1);
		newFinalTest.setInicioEstudioDate(calendario.getTime());
		//Fecha de Examen Final
		calendario.set(Calendar.YEAR, 2020);
		calendario.set(Calendar.MONTH,9);
		calendario.set(Calendar.DAY_OF_MONTH,4);
		newFinalTest.setFinalTestDate(calendario.getTime());

		FinalTest finalGuardado = finalTestRepository.save(newFinalTest);
		
		assertTrue(finalGuardado.getMateria().equalsIgnoreCase(newFinalTest.getMateria()));
	}
}
