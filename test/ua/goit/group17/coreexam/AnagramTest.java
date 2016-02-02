package ua.goit.group17.coreexam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnagramTest {
    LinkedList wordList;
    LinkedList emptyList;

    private static final String TEST_WORD1 = "Andrew";
    private static final String TEST_WORD2 = "Warned";
    private static final String WRONG_TEST_WORD1 = "123ASDAwen";
    private static final String WRONG_TEST_WORD2 = "wen   ";


    @Before
    public void setUp() throws Exception {
        emptyList= new LinkedList();
        wordList = new LinkedList(Arrays.asList("Andrew", "Warned", "error", "read", "dear"));
    }

    @Test
    public void testIsAnagram() throws Exception {
        Assert.assertFalse(Anagram.isAnagram(null,null)); //check null Strings
        Assert.assertTrue(Anagram.isAnagram(TEST_WORD1,TEST_WORD2));
        Assert.assertFalse(Anagram.isAnagram(WRONG_TEST_WORD1,WRONG_TEST_WORD2));
    }

    @Test
    public void testGetAnagramsFromList() throws Exception {
        List resultList=Anagram.getAnagramsFromList(null); //check null
        Assert.assertTrue(resultList.size()==0);

        resultList=Anagram.getAnagramsFromList(emptyList); //check empty List
        Assert.assertTrue(resultList.size()==0);

        resultList=Anagram.getAnagramsFromList(wordList);
        Assert.assertTrue(resultList.contains("Andrew, Warned"));
        Assert.assertTrue(resultList.contains("Warned, Andrew"));
        Assert.assertTrue(resultList.contains("read, dear"));
        Assert.assertTrue(resultList.contains("dear, read"));
        Assert.assertFalse(resultList.contains("error"));
    }

    @Test
    public void testGetAnagramInList() throws Exception {
        Assert.assertEquals(Anagram.getAnagramInList(null,null),"");  //check null
        Assert.assertEquals(Anagram.getAnagramInList(null,"dear"),"");
        Assert.assertEquals(Anagram.getAnagramInList(wordList,null),"");
        Assert.assertEquals(Anagram.getAnagramInList(emptyList,null),"");  //check emptyList
        Assert.assertEquals(Anagram.getAnagramInList(emptyList,"dear"),"");

        Assert.assertEquals(Anagram.getAnagramInList(wordList,"dear"),"read");
        Assert.assertEquals(Anagram.getAnagramInList(wordList,"Andrew"),"Warned");
        Assert.assertEquals(Anagram.getAnagramInList(wordList,"empty"),"");
    }
}