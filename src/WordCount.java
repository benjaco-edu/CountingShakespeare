public class WordCount {
    public String word;
    public int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
}