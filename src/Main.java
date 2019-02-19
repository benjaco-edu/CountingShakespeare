import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<String> originalList = new ArrayList<String>();


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.readFileToArray();


        main.countUsingFlexibleArray();



    }

    private static WordCount find(Iterable<WordCount> arr, String word) {

        for (WordCount i : arr) {
            if (i.word.equals(word)) {
                return i;
            }
        }
        return null;

    }

    private void countUsingFlexibleArray() {
        FlexibleArray<WordCount> flexArray =new FlexibleArray<WordCount>(32);

        for (String word : originalList) {
            WordCount wordCountForWord = find(flexArray, word);
            if (wordCountForWord !=  null) {
                wordCountForWord.count++;
            }else {
                flexArray.add(new WordCount(word, 1));
            }
        }

        for (WordCount wc : flexArray) {
            System.out.print(wc.count +"X "+wc.word+", ");
        }
        System.out.println("");

    }


    //Function to ReadFile
    //While reading the file and putting it into an ArrayList, ALL words are put into lowercase
    //Also removes all symbols etc. leaving only alphabetic characters.
    public void readFileToArray() throws IOException {

//        Scanner s = new Scanner(new File("./src/shakespear.txt"));
        Scanner s = new Scanner(new File("./src/Shaky.txt"));

        while (s.hasNext()){
            String word = s.next().toLowerCase().replaceAll("[^a-z]","");
            if(word.isBlank()){
                continue;
            }
            originalList.add(word);
        }

        s.close();
    }


    public void printArray(String[] strArray){
        for(int i = 0; i<20;i++){
            System.out.print(strArray[i] + " ");
        }
        System.out.println("");
    }


    public static double timeExecution(Runnable func){
        long startTime = System.nanoTime();
        func.run();
        long endTime = System.nanoTime();

        return (double)(endTime - startTime) / 1000000;
    }
}
