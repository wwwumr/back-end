import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadder {

    //the path of dictionary
    private static final String dictPath = "./dictionary.txt";

    //get start word and end word
    public static String[] getWords(){
        Scanner sc = new Scanner(System.in);

        System.out.println("This is wordLadder, please input your words.");
        System.out.println("--------------------------------------------");
        System.out.print("start word:");
        String word1 = new String(sc.nextLine());
        System.out.print("end word:");
        String word2 = new String(sc.nextLine()) ;
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

    //create wordList
    private static HashSet<String> getWordList(){
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
    private static String[] searchWord(String[] words,HashSet<String> wordList){

        
        ArrayList<ArrayList<String>> dfsQueue = new ArrayList<>();
        ArrayList<String> wordChain = new ArrayList<>();
        HashSet<String> usedWords = new HashSet<>();

        String start = new String(words[0]);
        String end = new String(words[1]);

        if(start.length()!=end.length() || !wordList.contains(start) || !wordList.contains(end)){
            return words;
        }
        
        wordChain.add(start);
        dfsQueue.add(wordChain);
        usedWords.add(start);

        while(!dfsQueue.isEmpty()){
            ArrayList<String> tempChain = dfsQueue.get(0); 
            dfsQueue.remove(0);

            ArrayList<String> neighbors = new ArrayList<>();  

            String str = tempChain.get(tempChain.size()-1);

            for(int i = 0;i<str.length();i++){
                for( char j='a';j<='z';j++){
                    String tempStr = new String(str.substring(0,i)+j+str.substring(i+1));
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
                    ArrayList<String> cpy = new ArrayList<>(tempChain);
                    cpy.add(s);
                    dfsQueue.add(cpy);
                }
            }
        }

        return words;
        
    }

    public static void main(String[] args){

        String[] words = getWords();
        HashSet<String> wordList = getWordList();
        String[] wordChain = searchWord(words,wordList);
        printWord(wordChain);
    }
}