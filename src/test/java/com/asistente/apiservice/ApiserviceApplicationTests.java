package com.asistente.apiservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class ApiserviceApplicationTests {

	@Autowired
	private UserRepository repositorio;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void crearUsuarioTest(){

		Users nuevoUser = new Users();
		nuevoUser.setIdUser(1);
		nuevoUser.setName("Johanna");
		nuevoUser.setPassword(encoder.encode("12345"));
		Users retorno = repositorio.save(nuevoUser);

		assertTrue(retorno.getPassword().equalsIgnoreCase(nuevoUser.getPassword()));
	}

}
