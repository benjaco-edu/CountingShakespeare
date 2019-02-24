import java.util.List;

/**
 * @author seana
 */
public class HashFunction {
    List<String> wordList;
    WordCount[] arr;


    public HashFunction(List<String> wordList) {
        this.wordList = wordList;
        this.arr = new WordCount[calcArrSize()];
    }

    private int calcArrSize() {
        return (int) (wordList.size() * 1.3);
    }

    public void insertion() {
        for (String word : wordList) {
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
    }

    private int calculateIndex(String word) {
        int code = word.hashCode();
        int hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash = (31 * hash + word.charAt(i)) % (arr.length);
        }
        return hash;
    }

    public WordCount[] getArray() {
        return this.arr;
    }
}