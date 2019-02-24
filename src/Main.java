import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        List<String> originalList = Helpers.fileToWordArray("./src/Shaky.txt");


        countUsingFlexibleArray(originalList);
        countUsingLinkedList(originalList);
        countUsingRedBlackBST(originalList);

	HashFunction hashFunc = new HashFunction(originalList);
        hashFunc.insertion();

        WordCount[] myArray = hashFunc.getArray();
        System.out.println(myArray[58].getWord());
        for (WordCount wc : myArray) {
            if (wc!=null){
                System.out.print(wc.getCount() +"X "+wc.getWord()+", ");
            }
        }

    }

    private static void countUsingRedBlackBST(List<String> originalList) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<>();

        for (String word : originalList) {
            Integer timesFound = bst.get(word);
            if (timesFound == null) {
                bst.insert(word, 1);
            } else {
                bst.insert(word, timesFound+1);
            }
        }


        bst.printInorder();

        System.out.println("");


    }

    private static WordCount find(Iterable<WordCount> arr, String word) {

        for (WordCount i : arr) {
            if (i.word.equals(word)) {
                return i;
            }
        }
        return null;

    }

    private static void countUsingLinkedList(List<String> originalList) {
        LinkedSymbolTable<WordCount> linkedList = new LinkedSymbolTable<>();

        for (String word : originalList) {
            WordCount wordCountForWord = find(linkedList, word);
            if (wordCountForWord !=  null) {
                wordCountForWord.count++;
            }else {
                linkedList.add(new WordCount(word, 1));
            }
        }

        for (WordCount wc : linkedList) {
            System.out.print(wc.count +"X "+wc.word+", ");
        }
        System.out.println("");

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
