import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachingWord {
	
	public static void main(String args[]) {
		String begin = "hit";
		String end= "cog";
		Set<String> wordsDict = new HashSet<>();
		wordsDict.add("hot");
		wordsDict.add("dot");
		wordsDict.add("dog");
		wordsDict.add("lot");
		wordsDict.add("log");
	
		new ReachingWord().length(begin, end, wordsDict);
	}
	
public int length(String begin, String end, Set<String> wordsDict) {
    Queue<String> curLevel = new LinkedList<>();
    Queue<String> nextLevel = new LinkedList<>();
    curLevel.add(begin);
 
    wordsDict.add(end);
 
    String curWord;
    int level = 1;
 
    Set<String> visited = new HashSet<>();
 
    while(!curLevel.isEmpty()){
        level++;
        while(!curLevel.isEmpty()) {
            curWord = curLevel.poll();
            visited.add(curWord);
 
 
            char[] arr = curWord.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
 
                    if(newWord.equals(end)){
                        return level;
                    }
                    if(wordsDict.contains(newWord) && !visited.contains(newWord)){
                        nextLevel.add(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
        curLevel = nextLevel;
        nextLevel = new LinkedList<>();
 
    }
 
    return 0;
}

}
