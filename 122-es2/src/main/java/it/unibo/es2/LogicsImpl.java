package it.unibo.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogicsImpl implements Logics {

    private final List<List<Boolean>> field; 

    public LogicsImpl(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size cannot be negative or zero");
        }
        this.field = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.field.add(new ArrayList<>(Collections.nCopies(size, false)));
        }
    }

    @Override
    public int getColumns() {
        return this.field.size();
    }

    @Override
    public int getRows() {
        return this.field.get(0).size();
    }

    @Override
    public boolean hit(Pair<Integer, Integer> position) {
        final boolean result = !this.field.get(position.getX()).get(position.getY());
        this.field.get(position.getX()).set(position.getY(), result);
        return result;
    }

    @Override
    public boolean finish() {
        return this.correctRow();
    }

    private boolean correctRow() {
        return this.field.stream().allMatch(t -> true);
    }
}
