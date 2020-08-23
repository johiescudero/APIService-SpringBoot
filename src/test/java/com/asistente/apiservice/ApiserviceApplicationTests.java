package com.asistente.apiservice;

import org.springframework.beans.factory.annotation.Autowired;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiserviceApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void crearUsuarioTest(){

		Users nuevoUser = new Users();
		nuevoUser.setName("Test_2");
		nuevoUser.setPassword(encoder.encode("12345"));
		nuevoUser.setEmail("test-2@gmail.com");
		Users usuarioGuardado = userRepository.save(nuevoUser);
		assertTrue(usuarioGuardado.getEmail().equalsIgnoreCase(nuevoUser.getEmail()));
	}

	
}
