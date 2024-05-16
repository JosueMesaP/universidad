package com.universidad.universidad.services;

import com.universidad.universidad.models.AsignaturasModel;
import com.universidad.universidad.repositories.IAsignaturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AsignaturaService {
    @Autowired
    IAsignaturasRepository asignaturasRepository;

    public ArrayList<AsignaturasModel> getAsignaturas(){
        return (ArrayList<AsignaturasModel>) asignaturasRepository.findAll();
    }//Fin getAsignaturas

    public AsignaturasModel saveAsignaturas(AsignaturasModel asignaturasModel){
        return asignaturasRepository.save(asignaturasModel);
    }//Fin save

    //Optional puede devolver algo o null
    public Optional<AsignaturasModel> getAsignaturabyId(Long idAsignatura){
        return asignaturasRepository.findById(idAsignatura);
    }//Fin getbyID

    public AsignaturasModel updateAsignaturabyId(AsignaturasModel request, Long idAsignatura){
        AsignaturasModel asignaturasModel = asignaturasRepository.findById(idAsignatura).get();
        asignaturasModel.setNombreAsignatura(request.getNombreAsignatura());
        asignaturasModel.setIntensidadSemanal(request.getIntensidadSemanal());
        asignaturasModel.setSemestre(request.getSemestre());
        asignaturasRepository.save(asignaturasModel);
        return asignaturasModel;
    }//Fin update

    public Boolean deleteAsignatura(Long idAsignatura){
        try{
            asignaturasRepository.deleteById(idAsignatura);
            return true;
        }catch (Exception e){
            return false;
        }
    }//Fin delete

}//Fin asignaturasService
