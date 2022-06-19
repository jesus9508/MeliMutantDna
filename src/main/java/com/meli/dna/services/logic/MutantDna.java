package com.meli.dna.services.logic;


import javax.swing.text.StyledEditorKit;
import java.util.List;

public class MutantDna extends AbstractMutantDna {

    private List<String> listMutantDna;

    public MutantDna(List<String> requestDna) {
        listMutantDna = requestDna;
    }

    public Boolean isMutant() {
        List<String> dna = getListMutantDna();
        //total of combinations
        int dnaCombinations = 0;
        //run array by each dna String
        for (int i = 0; i < dna.size(); i++) {
            //run string  by each character
            for (int j = 0; j < dna.get(i).length(); j++) {
                //Diag inv
                if (checkPossibleDiagReverseValid(i,j,dna.get(i).length())) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i - 1).charAt(j + 1), dna.get(i - 2).charAt(j + 2), dna.get(i - 3).charAt(j + 3))) {
                        dnaCombinations++;
                    }
                }
                //Diag
                if (checkPossibleDiagValid(i,j,dna.size(),dna.get(i).length())) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i+1).charAt(j+1), dna.get(i+ 2).charAt(j + 2), dna.get(i + 3).charAt(j + 3))) {
                        dnaCombinations++;
                    }
                }

                //horizontal
                if (checkPossibleHorizontalValid(j,dna.get(i).length())) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i).charAt(j+1), dna.get(i).charAt(j+2), dna.get(i).charAt(j+3))) {
                        dnaCombinations++;
                    }
                }
                //vertical
                if (checkPossibleVerticalValid(i,dna.get(i).length())) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i + 1).charAt(j), dna.get(i + 2).charAt(j), dna.get(i + 3).charAt(j))) {
                        dnaCombinations++;
                    }
                }

                if (checkNumberOfCombinations(dnaCombinations)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean charactersAllEqual(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }

    public List<String> getListMutantDna() {
        return listMutantDna;
    }

    public void setListMutantDna(List<String> listMutantDna) {
        this.listMutantDna = listMutantDna;
    }

    private Boolean checkNumberOfCombinations(Integer combinations){
       return combinations > 1;
    }

    private Boolean checkPossibleVerticalValid(Integer arrayPos,Integer stringLength){
        return arrayPos < stringLength - 3;
    }

    private Boolean checkPossibleHorizontalValid(Integer stringPosition,Integer stringLength){
        return stringPosition < stringLength - 3;
    }

    private Boolean checkPossibleDiagValid(Integer arrayPos,Integer stringPos,Integer arrayLength,Integer stringLength){
        return arrayPos < arrayLength - 3 && stringPos < stringLength - 3;
    }
    private Boolean checkPossibleDiagReverseValid(Integer arrayPos,Integer stringPos,Integer stringLength){
        return arrayPos >= 3 && stringPos < stringLength - 3;
    }
}
