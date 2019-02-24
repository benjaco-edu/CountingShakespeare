import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Main {


    public static void main(String[] args) throws IOException {

        List<String> originalList = Helpers.fileToWordArray("./src/shakespeare-complete.txt");

        System.out.println("Calculating FlexibleArray...");
        double flexibleTime = Helpers.timeExecutionInSeconds(() -> countUsingFlexibleArray(originalList));
        System.out.println("----");
        System.out.println("Calculating LinkedList...");
        double linkedListTime = Helpers.timeExecutionInSeconds(() -> countUsingLinkedList(originalList));
        System.out.println("----");
        System.out.println("Calculating HashMap...");
        double hashMapTime = Helpers.timeExecutionInSeconds(() -> countUsingHashMap(originalList));
        System.out.println("----");
        System.out.println("Calculating RedBlackBST...");
        double redBlackBSTTime = Helpers.timeExecutionInSeconds(() -> countUsingRedBlackBST(originalList));
        System.out.println("!--- Final Results ---!");
        System.out.println("FlexibleArray: " + flexibleTime + " Seconds");
        System.out.println("LinkedList: " + linkedListTime + " Seconds");
        System.out.println("HashMap: " + hashMapTime + " Seconds");
        System.out.println("RedBlackBST " + redBlackBSTTime + " Seconds");
        System.out.println("--------------------");

    }

    private static void countUsingHashMap(List<String> originalList) {
        HashFunction hashFunc = new HashFunction(originalList.size());

        for (String word : originalList) {
            hashFunc.insert(word);
        }

        WordCount[] array = hashFunc.getArray();
        for (WordCount wc : array) {
            System.out.print(wc.getCount() + "X " + wc.getWord() + ", ");
        }
        System.out.println("");

    }

    private static void countUsingRedBlackBST(List<String> originalList) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<>();

        for (String word : originalList) {
            Integer timesFound = bst.get(word);
            if (timesFound == null) {
                bst.insert(word, 1);
            } else {
                bst.insert(word, timesFound + 1);
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
            if (wordCountForWord != null) {
                wordCountForWord.count++;
            } else {
                linkedList.add(new WordCount(word, 1));
            }
        }

        for (WordCount wc : linkedList) {
            System.out.print(wc.count + "X " + wc.word + ", ");
        }
        System.out.println("");
    }

    private static void countUsingFlexibleArray(List<String> originalList) {
        FlexibleArray<WordCount> flexArray = new FlexibleArray<WordCount>(32);

        for (String word : originalList) {
            WordCount wordCountForWord = find(flexArray, word);
            if (wordCountForWord != null) {
                wordCountForWord.count++;
            } else {
                flexArray.add(new WordCount(word, 1));
            }
        }

        for (WordCount wc : flexArray) {
            System.out.print(wc.count + "X " + wc.word + ", ");
        }
        System.out.println("");
    }

}
