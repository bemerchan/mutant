package co.com.dna.domains;

import co.com.dna.exception.DnaException;

import java.util.ArrayList;
import java.util.List;

public class MutantIdentifier {
    private DNA dna;
    private List<LineTraverser> lineTraversers = new ArrayList<>();
    private MatchFinder matchFinder = new MatchFinder();

    private MutantIdentifier(String[] request) throws DnaException {
        dna = new DNA(request);
        lineTraversers.add(new Horizontal(dna));
        lineTraversers.add(new Vertical(dna));
        lineTraversers.add(new Diagonal(dna));
        lineTraversers.add(new InvertedDiagonal(dna));
    }

    public static boolean isMutant(String[] dna) throws DnaException {
        MutantIdentifier mutantIdentifier = new MutantIdentifier(dna);
        return mutantIdentifier.isMutant();
    }

    private boolean isMutant() {
        if (dna.getLength() < 4) return false;
        for (LineTraverser traverser : lineTraversers)
            if(matchFinder.scan(traverser))
                return true;
        return false;
    }
}