import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class Library {

    public int ID;
    public int signUpDays;
    public int numScanDay;
    public HashSet<Book> booksSet;
    public PriorityQueue<Book> booksMaxHeap;

    public Library(int ID, int signUpDays, int numScanDay){
        this.ID = ID;
        this.signUpDays = signUpDays;
        this.numScanDay = numScanDay;
        this.booksSet = new HashSet<>();
        this.booksMaxHeap = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getScore()==o1.getScore()){
                    return 0;
                }
                return o1.getScore()>o2.getScore()? -1:1;
            }
        });
    }

    public int getID() {
        return ID;
    }

    public int getSignUpDays() {
        return signUpDays;
    }

    public int getNumScanDay() {
        return numScanDay;
    }

    public HashSet<Book> getBooksSet() {
        return booksSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return getID() == library.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    public void addBook(Book book){
        if (!booksSet.contains(book)){
            booksSet.add(book);
            booksMaxHeap.offer(book);
        }
    }
}
