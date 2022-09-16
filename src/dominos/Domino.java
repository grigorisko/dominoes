package dominos;

public class Domino {
    private int firstNumber;
    private int secondNumber;
    private int row;
    private int sidePlayed;
    public Domino(int firstNumber,int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSidePlayed() {
        return sidePlayed;
    }

    public void setSidePlayed(int sidePlayed) {
        this.sidePlayed = sidePlayed;
    }
}
