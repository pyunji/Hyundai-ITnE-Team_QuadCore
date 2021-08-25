import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genPlMap = new HashMap<>(); // {장르: 장르별 총 재생횟수}
        Map<String, List<Music>> genMuMap = new HashMap<>(); // {장르: 해당 장르의 Music객체의 리스트}
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

        // 장르별 총 재생횟수를 정렬해주는 비교 기준을 만든다
        Comparator<Map.Entry<String, Integer>> comp1 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue()?1 : -1;
            }
        };

        // 특정 장르의 재생횟수가 가장 많은 순으로 Music 객체를 정렬하고, 재생 횟수가 같으면 id 순으로 정렬하는 비교 기준을 만든다
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
        // comp1을 사용해 장르를 정렬한다.
        genPlList.sort(comp1);

        List<Integer> answerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genPlList) {
            String genre = entry.getKey();
            List<Music> musics = genMuMap.get(genre);
            // 요소가 하나면 따로 comp를 사용하지 않고 그냥 가져온다
            if (musics.size() < 2) answerList.add(musics.get(0).getId());
            else for (int i = 0; i < 2; i++) {
                // comp2를 사용해 정렬한다
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