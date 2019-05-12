package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Before
    public void beforeMethod() {
        System.out.println("--------------------------------------");
        System.out.println("              junit test              ");
        System.out.println("--------------------------------------");
        System.out.println("junit demo success  --> beforeMethod !");
    }


    @Test
    public void test() throws Exception {
        WordLadder ladder = new WordLadder();
        HashSet<String> dict = ladder.getWordList();
        String[] words=new String[]{"cat","dog"};
        String[] chain = new String[]{"cat","cot","dot","dog"};
        System.out.print("the expected length is equal to actual:");
        assertEquals(chain.length,ladder.searchWord(words,dict).length);
        System.out.println("testing");
    }



    @After
    public void afterMethod() {
        System.out.println("junit demo success  --> afterMethod !");
        System.out.println("--------------------------------------");
        System.out.println("              test   over             ");
        System.out.println("--------------------------------------");
    }
}
