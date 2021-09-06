package Hash;

import java.util.HashMap;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();
        for(String str : completion){
            if(map.containsKey(str))
                map.put(str, map.get(str)+1);
            else
                map.put(str, 1);
        }

        for(String str : participant){
            Integer result = map.get(str);

            if(result == null || result == 0){
                answer = str;
                break;
            }else{
                map.put(str, result-1);
            }
        }

        return answer;
    }
}
