import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genPlMap = new HashMap<>(); 
        Map<String, List<Music>> genMuMap = new HashMap<>(); 
        List<Music> tmpList;
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            Music music = new Music(i, genre, play);

            genPlMap.put(genre, genPlMap.getOrDefault(genre, 0) + play);
            tmpList = genMuMap.getOrDefault(genre, new ArrayList<>());
            tmpList.add(music);
            genMuMap.put(genre, tmpList);
        }

        Comparator<Map.Entry<String, Integer>> comp1 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue()?1 : -1;
            }
        };

        Comparator<Music> comp2 = new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                if (o1.getPlay() < o2.getPlay()) return 1;
                else if (o1.getPlay()==o2.getPlay()) {
                    if (o1.getId() < o2.getId()) return -1;
                    else return 1;
                } else return -1;
            }
        };

        List<Map.Entry<String, Integer>> genPlList = new ArrayList<>(genPlMap.entrySet());
        genPlList.sort(comp1);

        List<Integer> answerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genPlList) {
            String genre = entry.getKey();
            List<Music> musics = genMuMap.get(genre);
            if (musics.size() < 2) answerList.add(musics.get(0).getId());
            else for (int i = 0; i < 2; i++) {
                musics.sort(comp2);
                answerList.add(musics.get(i).getId());
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;


    }
}
class Music {
    private int id;
    private String genre;
    private int play;

    public Music() {}
    public Music(int id, String genre, int play) {
        this.id = id;
        this.genre = genre;
        this.play = play;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlay() {
        return play;
    }
}