package co.com.dna.domains;

public class MatchFinder {
    private byte found = 0;
    private LineTraverser traverses;

    public boolean scan(LineTraverser traverses) {
        this.traverses = traverses;
        do {
            if(scanLine()) return true;
        } while (traverses.nextLine());
        return false;
    }

    private boolean scanLine(){
        if (!traverses.advance(1)) return false;
        char last = traverses.current();

        while (traverses.advance(2)) {
            char current = traverses.current();
            if (current == last){
                if (current == traverses.retrieve(-1)) {
                    if (current == traverses.retrieve(-3)) {
                        if (addMatchFound(current)) return true;
                    } else if (traverses.advance(1)) {
                        if (current == traverses.current()) {
                            if (addMatchFound(current)) return true;
                        } else {
                            traverses.advance(1);
                        }
                    }
                }
            }
            if(isOffBounds()) break;
            last = traverses.current();
        }
        return false;
    }

    private boolean addMatchFound(char value){
        found++;
        if (theSearchIsOver()) return true;
        skip(value);
        traverses.advance(1);
        return false;
    }

    private boolean isOffBounds(){
        return !traverses.advance(0);
    }

    private boolean theSearchIsOver(){
        return found > 1;
    }

    private void skip(char value){
        while (traverses.advance(1)){
            if (traverses.current() != value) return;
        }
    }
}
