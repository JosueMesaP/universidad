package com.universidad.universidad.controllers;
import com.universidad.universidad.models.EstudianteModel;
import com.universidad.universidad.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Estudiante")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ArrayList<EstudianteModel> getEstudiantes(){
        return this.estudianteService.getEstudiantes();
    }

    @PostMapping
    public EstudianteModel saveEstudiante(@RequestBody EstudianteModel estudianteModel){
        return this.estudianteService.saveEstudiante(estudianteModel);
    }

    @GetMapping(path = "/{idEstudiante}")
    public Optional<EstudianteModel> getEstudiantebyId(@PathVariable("idEstudiante") Long idEstudiante){
        return this.estudianteService.getEstudiantebyId(idEstudiante);
    }

    @PutMapping(path = "/{idEstudiante}")
    public EstudianteModel updateEstudiantebyId(@RequestBody EstudianteModel request, @PathVariable("idEstudiante") Long idEstudiante){
        return this.estudianteService.updateEstudiantebyId(request, idEstudiante);
    }//fin update

    @DeleteMapping(path = "/{idEstudiante}")
    public String deleteEstudiante(@PathVariable("idEstudiante")Long idEstudiante){
        Boolean ok = this.estudianteService.deleteEstudiante(idEstudiante);
        if(ok){
            return "Estudiante con id: " + idEstudiante + " eliminado correctamente";
        }else{
            return "No se ha podido eliminar el estudiante con id: " + idEstudiante;
        }
    }//fin delete

}
