package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class WordLadder {
    //the path of dictionary
    public static String dictPath;

    //create wordList
    public  HashSet<String> getWordList(){
        dictPath = "src/main/resources/static/dictionary.txt";
        HashSet<String> set = new HashSet<>();
        try{
            FileReader fin = new FileReader(dictPath);
            BufferedReader br = new BufferedReader(fin);

            String str;


            while ((str = br.readLine()) != null) {

                set.add(str);
            }

            br.close();
            fin.close();
            return set;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    //dfs search
    public  String[] searchWord(String[] words,HashSet<String> wordList){


        ArrayList<ArrayList<String>> dfsQueue = new ArrayList<>();
        ArrayList<String> wordChain = new ArrayList<>();
        HashSet<String> usedWords = new HashSet<>();

        String start = words[0];
        String end = words[1];

        if(start.length()!=end.length() || !wordList.contains(start) || !wordList.contains(end)){
            return words;
        }

        wordChain.add(start);
        dfsQueue.add(wordChain);
        usedWords.add(start);

        while(!dfsQueue.isEmpty()){
            ArrayList<String> tempChain = dfsQueue.get(0);
            dfsQueue.remove(0);

            ArrayList<String> neighbors = new ArrayList<String>();

            String str = tempChain.get(tempChain.size()-1);

            for(int i = 0;i<str.length();i++){
                for( char j='a';j<='z';j++){
                    String tempStr = str.substring(0,i)+j+str.substring(i+1);
                    if(wordList.contains(tempStr) && !tempStr.equals(str) ){
                        neighbors.add(tempStr);
                    }
                }
            }

            for(int i=0;i<neighbors.size();i++){
                String s = neighbors.get(i);
                if(!usedWords.contains(s)){
                    usedWords.add(s);
                }

                if(s.equals(end)){
                    tempChain.add(s);
                    return tempChain.toArray(new String[tempChain.size()]);
                }else{
                    ArrayList<String> cpy = new ArrayList<String>(tempChain);
                    cpy.add(s);
                    dfsQueue.add(cpy);
                }
            }
        }

        return words;

    }

    @RequestMapping(value = "/wordLadder" , method = RequestMethod.GET)
    public  String[] result(@RequestParam("start") String start,@RequestParam("end") String end){
        String[] words = new String[]{start,end};
        HashSet<String> wordList = getWordList();
        return searchWord(words,wordList);
    }

}
