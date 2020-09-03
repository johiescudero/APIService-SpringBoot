package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Mode;
import com.asistente.apiservice.services.ModeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/modes")
public class ModeController {
 
    @Autowired
    private ModeService modoService;

    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Mode> listarModos(){
      return modoService.listarModosService();
      
    }
    /**POST : Añadir nuevo usuario */
    @PostMapping(value = "/add")
    public Mode addMode(@RequestBody Mode newMode) {
        return modoService.agregarModoService(newMode);
    }

    /**PUT : Actualizar un usuario */
    @PutMapping(value = "/update")
    public void updateMode(@RequestBody Mode updMode){
        modoService.actualizarModo(updMode);
    }
    /**DELETE : Eliminar un usuario con el id */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteMode(@PathVariable ("id") Integer id){
        modoService.eliminarModo(id);
    }
}
