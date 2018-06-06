package ua.com.integrity.api;

import ua.com.integrity.model.SearchConcatenatedWordsResult;

import java.io.File;

public interface SearchConcatenation {

    /**
     * Performing a search of a concatenated words in the file.
     * @param file file with words
     * @return SearchConcatenatedWordsResult
     */
    SearchConcatenatedWordsResult searchWordsInFile(File file);
}
