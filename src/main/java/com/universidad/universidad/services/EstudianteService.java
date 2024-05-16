package com.universidad.universidad.services;

import com.universidad.universidad.models.EstudianteModel;
import com.universidad.universidad.repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired //Inyección de dependencias
    IEstudianteRepository estudianteRepository;

    public ArrayList<EstudianteModel> getEstudiantes(){
        return (ArrayList<EstudianteModel>) estudianteRepository.findAll();
    }//Fin getEstudiantes

    public EstudianteModel saveEstudiante(EstudianteModel estudianteModel){
        return  estudianteRepository.save(estudianteModel);
    }//Fin save

    //Optional puede devolver algo o null
    public Optional<EstudianteModel> getEstudiantebyId(Long idEstudiante){
        return estudianteRepository.findById(idEstudiante);
    }//Fin getbyID

    public EstudianteModel updateEstudiantebyId(EstudianteModel request, Long idEstudiante){
        EstudianteModel estudianteModel = estudianteRepository.findById(idEstudiante).get();
        estudianteModel.setCarnet(request.getCarnet());
        estudianteModel.setNombre(request.getNombre());
        estudianteModel.setApellido(request.getApellido());
        estudianteModel.setSemestre_ingreso(request.getSemestre_ingreso());
        estudianteModel.setPromedio(request.getPromedio());
        estudianteRepository.save(estudianteModel);

        return estudianteModel;
    }//Fin update

    public Boolean deleteEstudiante(Long idEstudiante){
        try{
            estudianteRepository.deleteById(idEstudiante);
            return true;
        }catch (Exception e){
            return false;
        }
    }//Fin delete

}
