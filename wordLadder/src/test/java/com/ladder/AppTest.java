package com.ladder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IllegalAccessError
    {
        assertEquals("cat","cat");
        WordList wordList = new WordList();

        assertTrue( wordList.searchWord(new String[]{"cat","dog"}).length==4);
        assertTrue( wordList.searchWord(new String[]{"cat","dog"})[0].equals("cat"));
        assertTrue( wordList.searchWord(new String[]{"cat","dog"})[1].equals("cot"));
        assertTrue( wordList.searchWord(new String[]{"cat","dog"})[2].equals("dot"));
        assertTrue( wordList.searchWord(new String[]{"cat","dog"})[3].equals("dog"));

    }
}
