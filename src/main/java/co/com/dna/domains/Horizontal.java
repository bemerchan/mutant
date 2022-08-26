package co.com.dna.domains;

public class Horizontal implements LineTraverser {
    private DNA dna;
    private int x = 0;
    private int y = 0;
    public Horizontal(DNA dna) {
        this.dna = dna;
    }

    @Override
    public char current() {
        return dna.get(x, y);
    }

    @Override
    public char retrieve(int offset) {
        return dna.get(x + offset, y);
    }

    @Override
    public boolean advance(int amount) {
        x += amount;
        return x < dna.getLength();
    }

    @Override
    public boolean nextLine() {
        x = 0;
        return ++y < dna.getLength();
    }
}
