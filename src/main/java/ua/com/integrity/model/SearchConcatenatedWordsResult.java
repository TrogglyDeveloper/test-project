package ua.com.integrity.model;

import java.util.HashSet;

public class SearchConcatenatedWordsResult {

    private String firstLongConcatenatedWord;

    private String secondLongConcatenatedWord;

    private HashSet<String> words;

    private HashSet<String> concatenatedWords;

    public String getFirstLongConcatenatedWord() {
        return firstLongConcatenatedWord;
    }

    public void setFirstLongConcatenatedWord(String firstLongConcatenatedWord) {
        this.firstLongConcatenatedWord = firstLongConcatenatedWord;
    }

    public String getSecondLongConcatenatedWord() {
        return secondLongConcatenatedWord;
    }

    public void setSecondLongConcatenatedWord(String secondLongConcatenatedWord) {
        this.secondLongConcatenatedWord = secondLongConcatenatedWord;
    }

    public HashSet<String> getWords() {
        return words;
    }

    public void setWords(HashSet<String> words) {
        this.words = words;
    }

    public HashSet<String> getConcatenatedWords() {
        return concatenatedWords;
    }

    public void setConcatenatedWords(HashSet<String> concatenatedWords) {
        this.concatenatedWords = concatenatedWords;
    }
}
