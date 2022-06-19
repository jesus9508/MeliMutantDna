package com.meli.dna.services.logic;

import com.meli.dna.services.logic.interfaces.IMutantDna;

public abstract class AbstractMutantDna implements IMutantDna {
    @Override
    public Boolean isMutant() {
        return false;
    }
}
