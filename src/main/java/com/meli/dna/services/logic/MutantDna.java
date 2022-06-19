package com.meli.dna.services.logic;


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
        //Variable i recorre los string completos ej "ATAGC"
        for (int i = 0; i < dna.size(); i++) {
            //j determina la posicion dentro del string
            for (int j = 0; j < dna.get(i).length(); j++) {
                //Diag inv
                if (i >= 3 && j < dna.get(i).length() - 3) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i - 1).charAt(j + 1), dna.get(i - 2).charAt(j + 2), dna.get(i - 3).charAt(j + 3))) {
                        dnaCombinations++;
                    }
                }

                //Diag
                if (i < dna.size() - 3 && j < dna.get(i).length() - 3) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i+1).charAt(j+1), dna.get(i+ 2).charAt(j + 2), dna.get(i + 3).charAt(j + 3))) {
                        dnaCombinations++;
                    }
                }

                //hprizontal
                if (j < dna.get(i).length() - 3) {
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i).charAt(j+1), dna.get(i).charAt(j+2), dna.get(i).charAt(j+3))) {
                        dnaCombinations++;
                    }
                }
                //vertical
                if (i < dna.get(i).length() - 3) {
                    // vertical check
                    if (charactersAllEqual(dna.get(i).charAt(j), dna.get(i + 1).charAt(j), dna.get(i + 2).charAt(j), dna.get(i + 3).charAt(j))) {
                        dnaCombinations++;
                    }
                }

                if (dnaCombinations > 1) {
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
}
