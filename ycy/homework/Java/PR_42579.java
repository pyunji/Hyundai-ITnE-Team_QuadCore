import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       int MAX = 0;
		
		HashMap<String, Integer> playsMap = new HashMap(); //장르, 재생횟수 hashmap
		HashMap<String, ArrayList<Music>> musicMap = new HashMap();
		ArrayList<String> sortPlayGenre = new ArrayList();//총 재생횟수 비교해 담을 변수
		
		for(int i=0; i<genres.length; i++) {
			//playMap(장르, 총 재생 횟수) 만들기
			playsMap.put(genres[i], playsMap.getOrDefault(genres[i], 0)+plays[i]);
			
			//musicMap(장르, Music객체의 ArrayList) 만들기
			Music music = new Music(i, genres[i], plays[i]);
			ArrayList<Music> musicList;
			if(!musicMap.containsKey(genres[i])){
				musicList = new ArrayList();
				musicList.add(music);
				musicMap.put(genres[i], musicList);
			}else {
				musicList = musicMap.get(genres[i]);
				musicList.add(music);
				//musicMap.replace(genres[i], musicList);
			}
		}
		
		//총 재생 횟수 비교하여 배열에 장르 담기
		String maxKey="";
		while(playsMap.size() > 0) {
			MAX=0;
			for(String gen : playsMap.keySet()) {
				if(MAX < playsMap.get(gen)) {
					MAX = playsMap.get(gen);
					maxKey = gen;
				}
			}
			sortPlayGenre.add(maxKey);
			playsMap.remove(maxKey);
		}
		
		
		//**** 정렬 기준 만들기 ****//
		//재생횟수 내림차순, 재생횟수 같으면 아이디 오름차순
		Comparator<Music> comp = new Comparator<Music>() {
			public int compare(Music o1, Music o2) {
				if(o1.getPlay() < o2.getPlay()) return 1;
				else if(o1.getPlay() == o2.getPlay()) {
					if(o1.getMid() < o2.getMid()) return -1;
					else return 1;
				}else return -1;
			}
		};

		
		//장르별 높은 순위의 음악 2개씩 뽑기
		//재생횟수 같으면 고유번호 순서대로
		//musicMap : 장르와 Music객체
		MAX = 0;
		ArrayList<Integer> result = new ArrayList();
		for(String gen : sortPlayGenre) {//높은 순서의 장르대로 뽑아옴
			ArrayList<Music> sortInnerList = musicMap.get(gen);
			sortInnerList.sort(comp);//정렬
			
			if(sortInnerList.size() <= 2) {
				for(int i=0; i<sortInnerList.size(); i++) {
					result.add(sortInnerList.get(i).getMid());
				}
			}else {
				result.add(sortInnerList.get(0).getMid());
				result.add(sortInnerList.get(1).getMid());
			}
		}
		
		
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
		return answer;
	    }
    }

    class Music{
	int mid;//고유번호
	String genre;//장르
	int play;//재생수
	
	public Music(int mid, String genre, int play) {
		this.mid=mid;
		this.genre = genre;
		this.play = play;
	}

	public int getMid() {
		return mid;
	}

	public String getGenre() {
		return genre;
	}

	public int getPlay() {
		return play;
	}
}