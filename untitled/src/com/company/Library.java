package com.company;

public class Library implements Comparable<Library> {
  Book[] thisBooks;
  int numberOfBooks;
  boolean isSignedUp;
  int elapsed = 0;
  int libID;
  int totalBookScore = 0;
  private long signUpTime;
  private int dailyScanLimit;
  public Library(
      int libID, int numberOfBooks, int signUpTime, int dailyScanLimit, boolean isSignedUp) {
    this.libID = libID;
    this.numberOfBooks = numberOfBooks;
    this.signUpTime = signUpTime;
    this.dailyScanLimit = dailyScanLimit;
    this.isSignedUp = isSignedUp;
  }

  public int getNumberOfBooks() {
    return numberOfBooks;
  }

  public int findTotalBookScore() {
    for (Book book : thisBooks) {
      totalBookScore += book.getScore();
    }
    return totalBookScore;
  }

  public Book[] getBooks() {
    return thisBooks;
  }

  public int getSignUpTime() {
    return (int) signUpTime;
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

  //
  @Override
  public int compareTo(Library o) {
    return this.getSignUpTime() <= o.getSignUpTime() ? -1 : 1;
  }
  //    @Override
  //    public int compareTo(Library o) {
  //        return this.findTotalBookScore() >= o.findTotalBookScore()? -1 : 1;
  //    }
  /*@Override
  public int compareTo(Library o) {
      return this.getDailyScanLimit() >= o.getDailyScanLimit() ? -1 : 1;
  }*/

}
