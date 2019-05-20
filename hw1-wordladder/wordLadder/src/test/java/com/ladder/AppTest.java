package com.ladder;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    private WordList wordList = new WordList();

    public void test1(){
        String[] result = wordList.searchWord(new String[]{"cat","dog"});
        assertTrue( result.length==4);
    }

    public void test2(){
        String[] result = wordList.searchWord(new String[]{"cat","dog"});
        assertTrue( result[0].equals("cat"));
        assertTrue( result[1].equals("cot"));
        assertTrue( result[2].equals("dot"));
        assertTrue( result[3].equals("dog"));
    }

    public void test3(){
        String[] result = wordList.searchWord(new String[]{"catt","dog"});
        assertNull(result);
    }
}
