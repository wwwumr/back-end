package com.ladder;

import static junit.framework.Assert.assertTrue;

public class WordListTest {

    public static void testWordList(){
        WordList wordList = new WordList();

        String[] result = wordList.searchWord(new String[]{"cat","dog"});
        assertTrue( result.length==4);
        assertTrue( result[0].equals("cat"));
        assertTrue( result[1].equals("cot"));
        assertTrue( result[2].equals("dot"));
        assertTrue( result[3].equals("dog"));
    }
}
