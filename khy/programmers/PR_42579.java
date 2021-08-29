import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> genreAndPlay = new HashMap();
        HashMap<String,ArrayList<Music>> hm = new HashMap();
        ArrayList<Map.Entry<String,Integer>> playsort = new ArrayList();
        ArrayList<Integer> result = new ArrayList();
        for(int i=0; i<genres.length; i++){
            genreAndPlay.put(genres[i],genreAndPlay.getOrDefault(genres[i],0)+plays[i]);
            Music music = new Music(genres[i],plays[i],i);
            
            if(!hm.containsKey(genres[i])){
                ArrayList<Music> arr = new ArrayList();
                hm.put(genres[i],arr);
                arr.add(music);
            }else{
                hm.get(genres[i]).add(music);
            }
        }
        
        playsort = new ArrayList(genreAndPlay.entrySet());
        playsort.sort((obj1,obj2)->{
            return -(obj1.getValue()-obj2.getValue());
        });
        
        for(Map.Entry<String,Integer> m : playsort){
            String str = m.getKey();
            hm.get(str).sort((music1, music2)->{
                if(music1.getPlay()==music2.getPlay()){
                    return music1.getIdenti()-music2.getIdenti();
                }else{
                    return -(music1.getPlay()-music2.getPlay());
                }
            });
            if(hm.get(str).size()==1){
                result.add(hm.get(str).get(0).getIdenti());
            }else{
                result.add(hm.get(str).get(0).getIdenti());
                result.add(hm.get(str).get(1).getIdenti());
            }
        }
        int[] result1 = new int[result.size()];
        for(int i=0;i<result.size();i++){
            result1[i] = result.get(i);
        }
        answer = result1;
        return answer;
    }
    
    class Music {
        private String genre;
        private int play;
        private int ident;
        
        Music(String genre, int play, int ident){
            this.genre = genre;
            this.play = play;
            this.ident = ident;
        }
        
        public String getGenre(){
            return this.genre;
        }
        public int getPlay(){
            return this.play;
        }
        public int getIdenti(){
            return this.ident;
        }
    }
}
