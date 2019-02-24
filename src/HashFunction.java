import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author seana
 */
public class HashFunction {
    int size;
    WordCount[] arr;


    public HashFunction(int size) {
        this.size = size;
        this.arr = new WordCount[calcArrSize()];
    }

    private int calcArrSize() {
        return (int) (size * 1.3);
    }

    public void insert(String word){
        int index = calculateIndex(word);
        while (true) {
            if (index > arr.length + 1) {
                index = 0;
            }
            if (arr[index] == null) {
                WordCount newWord = new WordCount(word, 1);
                arr[index] = newWord;
                break;
            }
            if (arr[index].getWord().equals(word)) {
                int newCount = arr[index].getCount() + 1;
                WordCount newWord = new WordCount(word, newCount);

                arr[index] = newWord;
                break;
            }
            index++;
        }
    }


    private int calculateIndex(String word) {
        return Math.abs(word.hashCode()) % (arr.length);
    }

    public WordCount[] getArray() {
        return Arrays.stream(arr) .filter(Objects::nonNull) .toArray(WordCount[]::new);
    }
}