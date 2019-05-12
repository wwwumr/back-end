package com.ladder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    //get start word and end word
    public static String[] getWords(){
        Scanner sc = new Scanner(System.in);

        System.out.print("start word:");
        String word1 = sc.nextLine();
        System.out.print("end word:");
        String word2 = sc.nextLine() ;
        sc.close();

        return  new String[]{word1,word2};
    }

    //print final chain of words
    private static void printWord(String[] words){
        int len = words.length;
        if(len >=2){
            System.out.println("--------------------------------------------");
            System.out.println("This is the chain of words.");
            for(int i=0;i<len;i++){
                System.out.print(words[i]);
                if(i<len-1){
                    System.out.print("->");
                }
            }
        }else{
            System.out.println("Sorry, there is no chain between these words.\n");
        }
        
    }

    public static void main(String[] args){

        String[] words = getWords();
        WordList wordList = new WordList();
        String[] wordChain = wordList.searchWord(words);
        printWord(wordChain);
    }
}
