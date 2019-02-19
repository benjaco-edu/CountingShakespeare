import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        List<String> originalList = Helpers.fileToWordArray("./src/Shaky.txt");


        countUsingFlexibleArray(originalList);


    }

    private static WordCount find(Iterable<WordCount> arr, String word) {

        for (WordCount i : arr) {
            if (i.word.equals(word)) {
                return i;
            }
        }
        return null;

    }

    private static void countUsingFlexibleArray(List<String> originalList) {
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

}
