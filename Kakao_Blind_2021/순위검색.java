package Kakao_Blind_2021;

import java.util.HashMap;
import java.util.StringTokenizer;

public class 순위검색 {
    HashMap<String, Integer> lang,job,career,food;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        init();

        int[][] board = new int[info.length][5];

        for(int i=0; i<info.length; i++){
            StringTokenizer st = new StringTokenizer(info[i]);

            board[i][0] = lang.get(st.nextToken());
            board[i][1] = job.get(st.nextToken());
            board[i][2] = career.get(st.nextToken());
            board[i][3] = food.get(st.nextToken());
            board[i][4] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<query.length; i++){
            answer[i] = execQuery(board, query[i]);
        }

        return answer;
    }

    public int execQuery(int[][] board, String query){
        boolean[][] result = new boolean[board.length][5];

        int index = 0;
        StringTokenizer st = new StringTokenizer(query);

        while(st.hasMoreTokens()){
            String field = st.nextToken();

            if(!field.equals("and")) {
                switch (index){
                    case 0:
                        if(!updateResult(result, board, index, lang.get(field)))
                            return 0;
                        break;
                    case 1:
                        if(!updateResult(result, board, index, job.get(field)))
                            return 0;
                        break;
                    case 2:
                        if(!updateResult(result, board, index, career.get(field)))
                            return 0;
                        break;
                    case 3:
                        if(!updateResult(result, board, index, food.get(field)))
                            return 0;
                        break;
                    case 4:
                        if(!updateResult(result, board, index, Integer.parseInt(field)))
                            return 0;
                        break;
                }
                index++;
            }
        }


        return countResult(result);
    }

    public int countResult(boolean[][] result){
        int cnt = 0;
        for(int i=0; i<result.length; i++){
            boolean flag = true;

            for(int j=0; j<5; j++){
                flag = flag & result[i][j];
            }

            if(flag)
                cnt++;
        }

        return cnt;
    }

    public boolean updateResult(boolean[][] result, int[][] board, int index, int target){
        boolean flag = false;

        if(index == 4){
            for(int i=0; i< board.length; i++){
                if(board[i][index] >= target){
                    result[i][index] = true;
                    flag = true;
                }
            }
        }else{
            if(target == 0){
                for(int i=0; i< board.length; i++)
                    result[i][index] = true;
                return true;
            }

            for(int i=0; i< board.length; i++){
                if(board[i][index] == target){
                    result[i][index] = true;
                    flag = true;
                }
            }
        }


        return flag;
    }

    public void init(){
        lang = new HashMap<>();
        job = new HashMap<>();
        career = new HashMap<>();
        food = new HashMap<>();

        lang.put("-", 0);
        lang.put("cpp", 1);
        lang.put("java", 2);
        lang.put("python", 3);

        job.put("-", 0);
        job.put("backend", 1);
        job.put("frontend", 2);

        career.put("-", 0);
        career.put("junior", 1);
        career.put("senior", 2);

        food.put("-", 0);
        food.put("chicken", 1);
        food.put("pizza", 2);
    }
}
