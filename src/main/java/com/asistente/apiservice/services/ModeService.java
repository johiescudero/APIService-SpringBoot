package com.asistente.apiservice.services;

import java.util.List;

import com.asistente.apiservice.models.Mode;
import com.asistente.apiservice.repository.ModeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeService {

    @Autowired
    private ModeRepository modeRepository;

	public List<Mode> listarModosService() {
		return modeRepository.findAll();
	}

	public Mode agregarModoService(Mode newMode) {
        return modeRepository.save(newMode);
	}

	public void actualizarModo(Mode updMode) {
        modeRepository.save(updMode);
	}

	public void eliminarModo(Integer id) {
        modeRepository.deleteById(id);
	}
    
}
