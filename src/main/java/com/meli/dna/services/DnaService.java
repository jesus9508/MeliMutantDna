package com.meli.dna.services;

import com.meli.dna.dto.RequestDna;
import com.meli.dna.dto.ResponseDna;
import com.meli.dna.dto.ResponseStats;
import com.meli.dna.entities.DnaEntity;
import com.meli.dna.projections.IStats;
import com.meli.dna.repositories.IDnaRepository;
import com.meli.dna.services.interfaces.IDnaService;
import com.meli.dna.services.logic.MutantDna;
import com.meli.dna.services.logic.validator.interfaces.IValidMutantDna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DnaService implements IDnaService {

    @Autowired
    IValidMutantDna iValidMutantDna;

    @Autowired
    IDnaRepository iDnaRepository;

    @Override
    public ResponseEntity<?> processDna(RequestDna request) {
        try{
            Map<String, String> validated = iValidMutantDna.validationsList(request);
            String valid = validated.get("valid");
            String message = validated.get("message");
            if(valid.equals("false")){
                return getResponseEntity(setResponseFailDna(message),HttpStatus.FORBIDDEN);
            }
            MutantDna mutantDna = getMutantDnaInstance(request.getDna());
            //process if dna is of mutant or human
            Boolean isMutant = mutantDna.isMutant();
            //saveDna
            saveDna(isMutant,request.getDna());
            return getResponseEntity(getResponseObject(isMutant,"this person has superpowers"),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return getResponseEntity(setResponseFailDna(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    private ResponseDna getResponseObject(Boolean isMutant, String message){
        ResponseDna obj = new ResponseDna(isMutant,message);
        return obj;
    }

    private ResponseEntity<?> getResponseEntity(Object object, HttpStatus httpStatus){
        return new ResponseEntity<>(object,httpStatus);
    }

    private ResponseDna setResponseFailDna(String message){
        return new ResponseDna(message);
    }

    private MutantDna getMutantDnaInstance(List<String> listDna){
        return new MutantDna(listDna);
    }

    private DnaEntity saveDna(boolean isMutant, List<String> list) {
        long humanOrMutant = (isMutant) ? 2 : 1;
        DnaEntity exist = getExistDna(list);
        if(exist == null){
         return iDnaRepository.save(new DnaEntity(list.toString(), humanOrMutant));
        }
        return null;
    }

    private DnaEntity getExistDna(List<String> list){
        Optional<DnaEntity> exist =
            iDnaRepository.findFirstByDna(list.toString());
        return exist.orElse(null);
    }

    public ResponseEntity<?> getStats(){
        double mutantCount;
        double humanCount;
        double ratio;
        mutantCount = iDnaRepository.getStatsOf(2L).getCount();
        humanCount = iDnaRepository.getStatsOf(1L).getCount();
        try{
            ratio = mutantCount / humanCount;
            ratio = (ratio == Double.POSITIVE_INFINITY)?0.0:ratio;
        }catch (Exception e){
            ratio = 0.0;
        }

        return getResponseEntity(getResponseStatsEntity(mutantCount,humanCount,ratio),HttpStatus.OK);
    }

    public ResponseStats getResponseStatsEntity(Double mutant,Double human, Double ratio){
        return new ResponseStats(mutant, human, ratio);
    }
}
