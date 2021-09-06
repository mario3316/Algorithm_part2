package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Song implements Comparable<Song>{
    int num;
    int genre;
    int plays;

    Song(int num, int genre, int plays){
        this.num = num;
        this.genre = genre;
        this.plays = plays;
    }

    public int compareTo(Song s){
        if(this.genre != s.genre){
            return s.genre - this.genre;
        }else{
            if(this.plays != s.plays)
                return s.plays - this.plays;
            else{
                return this.num - s.num;
            }
        }
    }
}

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        PriorityQueue<Song> pq = new PriorityQueue<>();

        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i]))
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            else{
                map.put(genres[i], plays[i]);
                count.put(genres[i], 2);
            }
        }

        for(int i=0; i< genres.length; i++){
            Song s = new Song(i, map.get(genres[i]), plays[i]);

            pq.add(s);
        }

        while(!pq.isEmpty()){
            Song s = pq.poll();
            String genre = genres[s.num];

            if(count.get(genre) > 0){
                list.add(s.num);
                count.put(genre, count.get(genre) - 1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
