package co.com.dna.domains;

import co.com.dna.exception.DnaException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DNA {
    private String[] dna;
    private int length;

    public DNA(String[] dna) throws DnaException {
        this.length = dna.length;
        this.dna = dna;
        validate(dna);
    }

    public char get(int x, int y) {
        return dna[y].charAt(x);
    }

    private void validate(String[] raw) throws DnaException {
        for (String str : raw) {
            if (str.length() != length) throw new DnaException("DNA must be a square matrix");
            for (int i = 0; i < length; i++) {
                char character = str.charAt(i);
                if (!isDnaNitrogenousBase(character))
                    throw new DnaException("'" + character + "' must be a DNA nitrogenous base");
            }
        }
    }

    private static boolean isDnaNitrogenousBase(char character){
        return character == 'A' || character == 'G' || character == 'C' || character == 'T';
    }
}