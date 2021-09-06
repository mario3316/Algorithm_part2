package Kakao_Blind_2021;

import java.util.*;

public class 메뉴리뉴얼 {
    int maxCnt = 0;
    List<String> maxStr;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> result = new ArrayList<>();

        Set<String> strSet = new HashSet<>();

        for(String s : orders){
            for(int i=0; i<s.length(); i++){
                strSet.add(Character.toString(s.charAt(i)));
            }
        }

        String[] strArr = strSet.toArray(new String[0]);

        for(int i: course){
            maxCnt = 0;
            maxStr = new ArrayList<>();
            combination(0, 0, i, strArr, new String[i], orders);

            if(maxCnt > 1){
                result.addAll(maxStr);
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }

    public void combination(int cnt, int start, int limit, String[] input, String[] output, String[] orders){
        if(cnt == limit){
            int result = getCount(orders, output);

            if(result > maxCnt){
                maxCnt = result;
                maxStr.clear();
                maxStr.add(String.join("", output));
            }else if (result == maxCnt){
                maxStr.add(String.join("", output));
            }
        }else{
            for(int i=start; i<input.length; i++){
                output[cnt] = input[i];
                combination(cnt+1, i+1, limit, input, output, orders);
            }
        }
    }

    public int getCount(String[] orders, String[] output){
        int cnt = 0;

        for(String i: orders){
            boolean flag = true;
            for(String o: output){
                if (!i.contains(o)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        return cnt;
    }

}
