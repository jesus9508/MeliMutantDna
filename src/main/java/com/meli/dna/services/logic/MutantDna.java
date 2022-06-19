package com.meli.dna.services.logic;

import com.meli.dna.services.logic.interfaces.IMutantDna;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MutantDna extends AbstractMutantDna {

    private List<String> listMutantDna;

    public MutantDna(List<String> requestDna) {
        listMutantDna = requestDna;
    }

    public Boolean isMutant(String[] dna) {
        //Contabiliza total de combinaciones iguales
        int totalDna = 0;
        //Variable i recorre los string completos ej "ATAGC"
        for (int i = 0; i < dna.length; i++) {
            //j determina la posicion dentro del string
            for (int j = 0; j < dna[i].length(); j++) {
                // Control Horizontal
                if (j < dna[i].length() - 3) {
                    if (isEqual(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2), dna[i].charAt(j + 3))) {
                        totalDna++;
                    }
                }
                // Control Vertical
                if (i < dna.length - 3) {
                    // vertical check
                    if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j), dna[i + 3].charAt(j))) {
                        totalDna++;
                    }
                }

                //Control Diagonal
                if (i < dna.length - 3 && j < dna[i].length() - 3) {
                    if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j + 1), dna[i + 2].charAt(j + 2), dna[i + 3].charAt(j + 3))) {
                        totalDna++;
                    }
                }

                //Control Diagonal Invertido
                if (i >= 3 && j < dna[i].length() - 3) {
                    if (isEqual(dna[i].charAt(j), dna[i - 1].charAt(j + 1), dna[i - 2].charAt(j + 2), dna[i - 3].charAt(j + 3))) {
                        totalDna++;
                    }
                }

                if (totalDna > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //Retorana verdadedos si todo los char son iguales
    public static boolean isEqual(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }


}
