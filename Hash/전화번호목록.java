package Hash;

import java.util.HashMap;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<phone_book.length; i++)
            map.put(phone_book[i], i);

        for (String s : phone_book) {
            for (int j = 1; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
