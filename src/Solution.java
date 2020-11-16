import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.*;


public class Solution {

    static int B, L, D;
    static Book[] total_books;
    static Library[] libraries;
    static ArrayList<Library> sign_list;
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String[] filenames = {"a_example"};
        for(String filename: filenames){
            readFromFile(filename);
            solution1();
            solution2();
//            writeToFile(filename);
        }
    }

    private static void solution1(){
        Answer1.answer1(total_books, libraries, D);
    }

    private static void solution2(){

    }

    private static void readFromFile(String filename) throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("input/"+filename+".txt"));
        B = myReader.nextInt();
        L = myReader.nextInt();
        D = myReader.nextInt();
        total_books = new Book[B];
        libraries = new Library[L];
        for (int i = 0; i < B; i++) {
            int score = myReader.nextInt();
            total_books[i] = new Book(i, score);
        }
        for (int i = 0; i < L; i++){
            int N = myReader.nextInt();
            int T = myReader.nextInt();
            int M = myReader.nextInt();
            libraries[i] = new Library(i, T, M);
            for(int j = 0; j < N; j++){
                int id = myReader.nextInt();
                //put the id to id array of a lib
                libraries[i].addBook(total_books[id]);
            }
        }
        myReader.close();
    }

    private static float lib_score(Library library){
        int sum_score = 0;
        for(Book b: library.booksSet){
            sum_score += b.score;
        }
        return (float) (sum_score)/(library.signUpDays+library.booksSet.size()/library.numScanDay);
    }

//    private static void writeToFile(String filename) throws FileNotFoundException, UnsupportedEncodingException {
//        PrintWriter outputfile = new PrintWriter("output/" + filename + ".out", "UTF-8");
//        outputfile.println(selected.size());
//        Collections.reverse(selected);
//        for(int i: selected){
//            outputfile.print(i);
//            outputfile.print(" ");
//        }
//        outputfile.close();
//    }
}
