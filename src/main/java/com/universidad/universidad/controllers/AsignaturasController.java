package com.universidad.universidad.controllers;
import com.universidad.universidad.models.AsignaturasModel;
import com.universidad.universidad.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Asignatura")
public class AsignaturasController {
    @Autowired
    private AsignaturaService asignaturasService;

    @GetMapping
    public ArrayList<AsignaturasModel> getAsignaturas(){
        return this.asignaturasService.getAsignaturas();
    }

    @PostMapping
    public AsignaturasModel saveEstudiante(@RequestBody AsignaturasModel asignaturasModel){
        return this.asignaturasService.saveAsignaturas(asignaturasModel);
    }

    @GetMapping(path = "/{idAsignatura}")
    public Optional<AsignaturasModel> getAsignaturabyId(@PathVariable("idAsignatura") Long idAsignatura){
        return this.asignaturasService.getAsignaturabyId(idAsignatura);
    }

    @PutMapping(path = "/{idAsignatura}")
    public AsignaturasModel updateAsignaturabyId(@RequestBody AsignaturasModel request, @PathVariable("idAsignatura") Long idAsignatura){
        return this.asignaturasService.updateAsignaturabyId(request, idAsignatura);
    }//fin update

    @DeleteMapping(path = "/{idEstudiante}")
    public String deleteAsignatura(@PathVariable("idAsignatura")Long idAsignatura){
        Boolean ok = this.asignaturasService.deleteAsignatura(idAsignatura);
        if(ok){
            return "Asignatura con id: " + idAsignatura + " eliminada correctamente";
        }else{
            return "No se ha podido eliminar la asignatura con id: " + idAsignatura;
        }
    }//fin delete
}
