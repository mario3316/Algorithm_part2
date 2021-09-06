package Hash;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] arr : clothes){
            if(map.containsKey(arr[1]))
                map.put(arr[1], map.get(arr[1]) + 1);
            else
                map.put(arr[1], 1);
        }

        for(String key : map.keySet()){
            Integer value = map.get(key);
            answer *= value + 1;
        }

        return answer - 1;
    }
}
