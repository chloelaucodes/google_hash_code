package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
   static int librarySize =0 ;
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chloelau/google_hash_code/untitled/src/com/company/example" +
                ".txt");
        Scanner scanner = new Scanner(file);


        int bookSize = scanner.nextInt();
        Book[] books = new Book[bookSize];
         librarySize = scanner.nextInt();
        Library[] libraries = new Library[librarySize];
        int totalDays = scanner.nextInt();
        for (int i = 0; i < bookSize; i++) {
            books[i] = new Book(i, scanner.nextInt(), false);
        }

        for (int i = 0; i < librarySize; i++) {
            libraries[i] = new Library(i, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), false);
            Library currentLibrary = libraries[i];
            currentLibrary.thisBooks = new Book[currentLibrary.getNumberOfBooks()];
            for (int j = 0; j < currentLibrary.getNumberOfBooks(); j++) {
                int index = scanner.nextInt();
                currentLibrary.thisBooks[j] = books[index];
            }
        }

        Arrays.sort(libraries);

        for (Library library : libraries) {
            Arrays.sort(library.getBooks());
        }

        int days = 0;
        int index = 0;
        int totalScore = 0 ;
        boolean freeToScan = true;
        while (days <= totalDays) {
            if (freeToScan) {
                Library top = getTop(libraries);
                top.elapsed += 1;
                freeToScan = false;
                if (top.elapsed == top.getSignUpTime()){
                    top.setSignedUp();
                    freeToScan = true;
                }
                }

            for(Library library: libraries){
                if(library.isSignedUp){
                    for(int i = 0; i < library.getDailyScanLimit(); i++){
                        Book top = getTopBook(library);
                        top.scan();
                        totalScore += top.getScore();
                    }
                }
            }
            days++;
            }





            StringBuilder output = new StringBuilder();
            output.append(librarySize);
            output.append("\n");
            for (int i = 0; i < librarySize; i++) {
                output.append(libraries[i].libID + " ");
                output.append(libraries[i].getNumberOfBooks());
                output.append("\n");
                for (Book book : libraries[i].getBooks()) {
                    output.append(book.getID() + " ");
                }
                output.append("\n");
            }
            String outFile = "/Users/chloelau/google_hash_code/untitled/src/com/company/output1" +
                    ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            writer.write(output.toString());
            writer.close();

        }


    private static Library getTop(Library[] libraries) {
        for (int i = 0; i < librarySize; i++) {
            if (!libraries[i].isSignedUp()) {
               return libraries[i];
            }
        }
        return libraries[librarySize-1];
    }
    private static Book getTopBook(Library library) {
        for (int i = 0; i < library.getNumberOfBooks(); i++) {
            if (!library.getBooks()[i].isScanned()) {
                return  library.getBooks()[i];
            }
        }
        return library.getBooks()[library.getNumberOfBooks()-1];
    }


}




