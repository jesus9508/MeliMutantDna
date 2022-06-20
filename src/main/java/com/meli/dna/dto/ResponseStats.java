package com.meli.dna.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStats {
    @JsonProperty("count_mutant_dna")
    private Double count_mutant_dna;
    @JsonProperty("count_human_dna")
    private Double count_human_dna;
    @JsonProperty("ratio")
    private Double ratio;

    public ResponseStats(Double count_mutant_dna, Double count_human_dna, Double ratio) {
        this.setCount_mutant_dna(count_mutant_dna);
        this.setCount_human_dna(count_human_dna);
        this.setRatio(ratio);
    }

    public Double getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Double count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Double getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Double count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
