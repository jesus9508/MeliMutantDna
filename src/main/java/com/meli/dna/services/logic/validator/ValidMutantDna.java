package com.meli.dna.services.logic.validator;

import com.meli.dna.dto.RequestDna;
import com.meli.dna.services.logic.validator.interfaces.IValidMutantDna;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidMutantDna implements IValidMutantDna {

    private static final String REGEX = "[ACGT]+";
    private static final String VALID = "valid";
    private static final String MESSAGE = "message";

    @Override
    public Map<String,String> validationsList(RequestDna requestProcess) {

        Map<String,String> responseValidations = getMapResponseInstance();
        String valid = "true";
        String message = null;
        int initialRange = 0;
        List<String> request ;
        //validate for empty list of strings
        if(validateIsNotEmptyList(requestProcess.getDna())){
            System.out.println(requestProcess.getDna().toString());
            request = requestProcess.getDna();
            initialRange = request.get(0).length();
            //valid for different numbers of characteres in list
            if(!validateIsValidRangeOfCharacters(request,initialRange)){
                valid ="false";
                message = "there are different numbers of characters in List, please confirm you information";
            }else if(!validateIsValidCharacters(request)){
                valid ="false";
                message = "there are differents characters that not in (A,T,C,G), please confirm you information";
            }
        }else{
            valid = "false";
            message = "List can't be empty";
        }

        responseValidations.put(VALID, valid);
        responseValidations.put(MESSAGE, message);

        return responseValidations;
    }

    /**
     *
     * @param request
     * @return
     */
    private Boolean validateIsNotEmptyList(List<String> request){
        return (request != null && request.size() > 0);
    }

    /**
     * valid range of numbers of characters
     * @param request
     * @param range
     * @return Boolean
     */
    private Boolean validateIsValidRangeOfCharacters(List<String> request,int range){
        for (String string :request) {
             if(string.length() != range){
                 return false;
             }
        }
        return true;
    }

    /**
     * Valid regex characters
     * @param request
     * @return Boolean
     */
    private Boolean validateIsValidCharacters(List<String> request){
        for (String string :request) {
            if(!string.matches(REGEX)){
                return false;
            }
        }
        return true;
    }

    private Map<String,String> getMapResponseInstance(){
        return new HashMap<>();
    }

}
