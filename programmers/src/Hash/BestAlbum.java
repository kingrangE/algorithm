package Hash;
import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic","pop", "classic", "classic", "pop","pop"};
        int[] plays =  {500, 600, 500, 800, 2500,2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
    static int[] solution(String[] genres, int[] plays) {
        // 노래가 가장 많이 재생된 장르 수록
        // 장르 내에서 가장 많이 재생된 노래 수록
        // 장르별 최대 노래는 2곡 수록
        /*
        * 가장 많이 재생된 장르를 먼저 선택
        * 장르 별 재생 횟수를 먼저 구해야 함 ( String, Int -> map 형식 )
        * 해당 재생횟수를 value값으로 정렬
        * 장르 별 많이 재생된 2곡을 따로 분류 ( 이후 출력 용도 ) ( 위의 map의 key를 이용해서 해당 key의 value끼리 비교하며 최종 2곡을 최종 answer에 추가 )
        * */
        List<Integer> answer = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();
        Map<String,Integer> play_cnt = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            play_cnt.put(genres[i], play_cnt.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(plays[i],genres[i],i));
        }
        //play_cnt는 많이 재생된 장르부터 차례대로 저장되어 있음 musicList에서 장르를 하나씩 꺼내서 play_cnt 높은 순서대로 출력하면된다.
        musicList.sort(((o1, o2) -> o2.play_cnt - o1.play_cnt));
        List<Map.Entry<String,Integer>> list = new ArrayList<>(play_cnt.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        for(int i = 0; i<list.size(); i++) {
            int cnt = 0;
            for(int j = 0; j<musicList.size(); j++) {
                if(musicList.get(j).genre.equals(list.get(i).getKey())) {
                    answer.add(musicList.get(j).index);
                    cnt++;
                }
                if(cnt == 2) break;
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
class Music{
    int play_cnt;
    String genre;
    int index;

    public Music(int play_cnt, String genre, int index) {
        this.play_cnt = play_cnt;
        this.genre = genre;
        this.index = index;
    }

    public int getPlay_cnt() {
        return play_cnt;
    }

    public void setPlay_cnt(int play_cnt) {
        this.play_cnt = play_cnt;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}