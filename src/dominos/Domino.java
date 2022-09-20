package dominos;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class is the domino of the game.
 * Contains the info of each domino.
 */
public class Domino {
    private int firstNumber;
    private int secondNumber;
    private int row;
    private int sidePlayed;

    /**
     * Constructor for the Domino class
     * @param firstNumber The first number of the domino
     * @param secondNumber The second number of the domino
     */
    public Domino(int firstNumber,int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    /**
     * Getter for the first number
     * @return The first number
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * Getter for the second number
     * @return The second number
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * Setter for the first number
     * @param firstNumber The number to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Setter for the second number
     * @param secondNumber The number to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Getter for the row
     * @return The row
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter for the row
     * @param row The row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter for the side played
     * @return The side played
     */
    public int getSidePlayed() {
        return sidePlayed;
    }

    /**
     * Setter for the side played
     * @param sidePlayed The side played
     */
    public void setSidePlayed(int sidePlayed) {
        this.sidePlayed = sidePlayed;
    }
}
