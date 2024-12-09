package it.unibo.es2;

public interface Logics {

    /**
     * @return the columns of the field.
     */
    int getColumns();

    /**
     * @return the rows of the field.
     */
    int getRows();

    /**
     * @param position
     * @return if this buttonis pressed.
     */
    boolean hit(Pair<Integer, Integer> position);

    /**
     * @return if the game is finished. 
     */
    boolean finish();
}
