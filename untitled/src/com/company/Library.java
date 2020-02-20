package com.company;

import com.company.Book;

public class Library implements Comparable<Library> {
    Book[] thisBooks;

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    int numberOfBooks;
    private int signUpTime;
    private int dailyScanLimit;
    boolean isSignedUp;
    int elapsed = 0;
    int libID;
    int totalBookScore = 0;

    public int findTotalBookScore(){
        for(Book book : thisBooks){
            totalBookScore += book.getScore();
        }
        return totalBookScore;
    }

    public Book[] getBooks() {
        return thisBooks;
    }

    public int getSignUpTime() {
        return signUpTime;
    }

    public int getDailyScanLimit() {
        return dailyScanLimit;
    }

    public boolean isSignedUp() {
        return isSignedUp;
    }

    public void setSignedUp() {
        this.isSignedUp = true;
    }

    public Library(int libID, int numberOfBooks, int signUpTime, int dailyScanLimit, boolean isSignedUp) {
        this.libID = libID;
        this.numberOfBooks = numberOfBooks;
        this.signUpTime = signUpTime;
        this.dailyScanLimit = dailyScanLimit;
        this.isSignedUp = isSignedUp;
    }
//
//        @Override
//    public int compareTo(Library o) {
//        return this.getSignUpTime() <= o.getSignUpTime() ? -1 : 1;
////    }
//    @Override
//    public int compareTo(Library o) {
//        return this.findTotalBookScore() >= o.findTotalBookScore()? -1 : 1;
//    }
@Override
public int compareTo(Library o) {
    return this.getDailyScanLimit() >= o.getDailyScanLimit() ? -1 : 1;
}

}
