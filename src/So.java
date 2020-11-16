import java.util.*;

public class So {
    public static void main(String args[]){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders(beginWord, endWord, wordList);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //write your code here
        List<List<String>> result = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String word: wordList){
            set.add(word);
        }
        Set<String> visited = new HashSet<>();
        Queue<Entry> q = new LinkedList<>();
        q.offer(new Entry(beginWord));
        visited.add(beginWord);
        // int count = 1;
        boolean flag = false;
        while(!q.isEmpty()){
            List<Entry> level = new ArrayList<>();
            int size = q.size();
            for (int i=0; i<size; i++){
                Entry cur = q.poll();
                if (cur.str.equals(endWord)){
                    flag = true;
                    level.add(cur);
                }
                char[] array = cur.str.toCharArray();
                for (int j=0; j<array.length; j++){
                    char chaj = array[j];
                    for (char k='a'; k<='z';k++){
                        array[j] = k;
                        String son = new String(array);
                        if (set.contains(son) && !visited.contains(son)){
                            Entry son_e = new Entry(son);
                            son_e.prev = cur;
                            q.offer(son_e);
                            visited.add(son);
                        }
                    }
                    array[j] = chaj;
                }
            }
            if (flag){
                process(level, result);
                break;
            }
        }
        return result;
    }

    private static void process(List<Entry> level, List<List<String>> result){
        for (Entry en: level){
            List<String> list = new ArrayList<>();
            Entry p = en;
            while (p.prev!=null){
                list.add(p.str);
                p = p.prev;
            }
            list.add(p.str);
            Collections.reverse(list);
            result.add(list);
            for (String s: list){
                System.out.println(s);
            }
            System.out.println("----");
        }
    }

    static class Entry{
        String str;
        Entry prev;

        Entry(String str){
            this.str = str;
            this.prev = null;
        }
    }
}