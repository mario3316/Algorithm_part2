package DFS_BFS;

public class 타겟넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers.length, 0, numbers, target);

        return answer;
    }

    public void dfs(int start, int end, int result, int[] numbers, int target){
        if(start == end){
            if(result == target)
                answer++;
        }else{
            dfs(start+1, end, result+numbers[start], numbers, target);
            dfs(start+1, end, result-numbers[start], numbers, target);
        }
    }
}
