package co.com.dna.domains;

public class Vertical implements LineTraverser {
    private DNA dna;
    private int x = 0;
    private int y = 0;
    public Vertical(DNA dna){
        this.dna = dna;
    }

    @Override
    public char current(){
        return dna.get(x, y);
    }

    @Override
    public char retrieve(int offset){
        return dna.get(x, y + offset);
    }

    @Override
    public boolean advance(int amount){
        y += amount;
        return y < dna.getLength();
    }

    @Override
    public boolean nextLine(){
        y = 0;
        return ++x < dna.getLength();
    }
}
