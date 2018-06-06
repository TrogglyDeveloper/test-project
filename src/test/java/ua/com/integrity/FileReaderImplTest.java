package ua.com.integrity;

import org.junit.Test;
import ua.com.integrity.api.SearchConcatenation;
import ua.com.integrity.impl.SearchConcatenationImpl;
import ua.com.integrity.model.SearchConcatenatedWordsResult;

import java.io.File;

public class FileReaderImplTest {

    private final String WORDS_FILE = "/home/wallace/Buffer/words.txt";
    private final String CAT_FILE = "/home/wallace/Buffer/cat.txt";

    @Test
    public void testSearchConcatenate() {

        File file = new File(WORDS_FILE);
        SearchConcatenatedWordsResult searchConcatenatedWordsResult = null;

        SearchConcatenation searchContains = new SearchConcatenationImpl();
        searchConcatenatedWordsResult = searchContains.searchWordsInFile(file);

        System.out.println(searchConcatenatedWordsResult.getFirstLongConcatenatedWord());
        System.out.println(searchConcatenatedWordsResult.getSecondLongConcatenatedWord());
        System.out.println(searchConcatenatedWordsResult.getConcatenatedWords().size());
    }

    @Test
    public void testSearchConcatenateCat() {

        File file = new File(CAT_FILE);
        SearchConcatenatedWordsResult searchConcatenatedWordsResult = null;

        SearchConcatenation searchContains = new SearchConcatenationImpl();
        searchConcatenatedWordsResult = searchContains.searchWordsInFile(file);

        System.out.println(searchConcatenatedWordsResult.getFirstLongConcatenatedWord());
        System.out.println(searchConcatenatedWordsResult.getSecondLongConcatenatedWord());
        System.out.println(searchConcatenatedWordsResult.getConcatenatedWords().size());
    }
}
