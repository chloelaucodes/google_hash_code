package com.company;

public class Book implements Comparable<Book> {
    int ID;
    int score;
    boolean isScanned = false;

    public Book(int ID, int score, boolean isScanned) {
        this.ID = ID;
        this.score = score;
        this.isScanned = isScanned;
    }

    public int getID() {
        return ID;
    }

    public int getScore() {
        return score;
    }
    public void scan(){
        this.isScanned = true;
    }

    public boolean isScanned() {
        return isScanned;
    }

    @Override
    public int compareTo(Book o) {
        return (this.getScore() >= o.getScore()? -1 : 1 );
    }
}
