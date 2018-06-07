package ua.com.integrity.impl;

import ua.com.integrity.exception.SearchConcatenationException;
import ua.com.integrity.model.SearchConcatenatedWordsResult;
import ua.com.integrity.api.SearchConcatenation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class SearchConcatenationImpl implements SearchConcatenation {

    private String firstLongConcatenatedWord;

    private String secondLongConcatenatedWord;

    private HashSet<String> words;

    private HashSet<String> concatenatedWords;

    private void clearVariables() {
        firstLongConcatenatedWord = "";
        secondLongConcatenatedWord = "";
        words = new HashSet<>();
        concatenatedWords = new HashSet<>();
    }

    @Override
    public SearchConcatenatedWordsResult searchWordsInFile(File file) {

        if (!file.exists()) {
            throw new SearchConcatenationException("File " + file.getAbsolutePath() + " not exists!");
        }

        clearVariables();

        SearchConcatenatedWordsResult searchConcatenatedWordsResult = new SearchConcatenatedWordsResult();

        words = readWordsFile(file);

        for (String word : words) {

            if (isContainWordInArray(word.toCharArray(), 0)) {
                concatenatedWords.add(word);

                if (firstLongConcatenatedWord.length() < word.length()) {
                    secondLongConcatenatedWord = firstLongConcatenatedWord;
                    firstLongConcatenatedWord = word;
                } else {
                    if (secondLongConcatenatedWord.length() < word.length()) {
                        secondLongConcatenatedWord = word;
                    }
                }
            }
        }

        searchConcatenatedWordsResult.setConcatenatedWords(concatenatedWords);
        searchConcatenatedWordsResult.setWords(words);
        searchConcatenatedWordsResult.setFirstLongConcatenatedWord(firstLongConcatenatedWord);
        searchConcatenatedWordsResult.setSecondLongConcatenatedWord(secondLongConcatenatedWord);

        return searchConcatenatedWordsResult;
    }

    private HashSet<String> readWordsFile(File file) {

        HashSet<String> words = new HashSet<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;

            while ((strLine = bufferedReader.readLine()) != null) {
                words.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    private boolean isContainWordInArray(
            char[] wordLetters,
            int startIndex) {

        LinkedList<Integer> entryIndexes = new LinkedList<>();
        boolean processResult = false;
        StringBuilder searchedWord = new StringBuilder();

        for (int i = startIndex; i < wordLetters.length; i++) {

            searchedWord.append(wordLetters[i]);

            if ((words.contains(searchedWord.toString()))
                    && (searchedWord.length() != wordLetters.length)) {
                entryIndexes.addFirst(i + 1);

                if (searchedWord.toString().length() != wordLetters.length
                        && (i + 1 == wordLetters.length)) {
                    return true;
                }
            }
        }

        for (Integer index : entryIndexes) {
            if (isContainWordInArray(wordLetters, index)) {
                return true;
            }
        }

        return processResult;
    }
}
