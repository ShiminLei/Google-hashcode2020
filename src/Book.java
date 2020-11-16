import java.util.Objects;

public class Book {

    public int ID;
    public int score;
    public boolean scanned;

    public Book(int ID, int score){
        this.ID = ID;
        this.score = score;
        this.scanned = false;
    }

    public int getID() {
        return ID;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getID() == book.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    public void scan(){
        this.scanned = true;
    }

    public boolean isScanned(){
        return this.scanned;
    }
}
