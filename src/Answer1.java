import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Answer1 {
    public static int answer1(Book[] total_books, Library[] libraries, int D){
        int totalScore = 0;
        PriorityQueue<Library> libraryHeap = new PriorityQueue<>(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                if (o1.getSignUpDays()==o2.getSignUpDays()){
                    return 0;
                }
                return o1.getSignUpDays()<o2.getSignUpDays()? -1:1;
            }
        });
        for (Library library: libraries){
            libraryHeap.offer(library);
            System.out.println(library.getID());
            System.out.println(library.signUpDays);
        }

        ArrayList<Library> libOnScan = new ArrayList<>();
        Library curLib = null;
        boolean finish = false;
        for (int i=0; i<D; i++){
            // 处理 signup line
            if (curLib!=null){
                if (curLib.signUpDays==0){
                    if (!finish){
                        libOnScan.add(curLib);
                    }
                    if (!libraryHeap.isEmpty()){
                        curLib = libraryHeap.poll();
                        curLib.signUpDays--;
                        finish = false;
                    }else {
                        finish = true;
                    }
                }else{
                    curLib.signUpDays--;
                }
            }else {
                if (!libraryHeap.isEmpty()){
                    curLib = libraryHeap.poll();
                    curLib.signUpDays--;
                    finish = false;
                }
            }

            //  处理 scan line
            for (Library library: libOnScan){
                System.out.println("library"+library.getID()+"\n");
                int count = library.getNumScanDay();
                while (!library.booksMaxHeap.isEmpty() && count!=0){
                    Book book = library.booksMaxHeap.poll();
                    System.out.println("book"+book.getID()+"\n");
                    if (!book.isScanned()){
                        totalScore += book.getScore();
                    }
                    book.scan();
                    count--;
                }
            }

            System.out.println("day"+i+"finish----\n ");
        }
        System.out.println("total score : "+totalScore);
        return totalScore;
    }
}
