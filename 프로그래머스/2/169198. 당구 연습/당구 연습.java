class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int endX = balls[i][0];
            int endY = balls[i][1];
            int res = Integer.MAX_VALUE;
            int distance = 0;
            
            // top
            if (!(startX == endX && startY > endY)) {
                distance = (startY + endY) * (startY + endY) + Math.abs(startX - endX) * Math.abs(startX - endX);
            
                res = Math.min(res, distance);
            }
            
            // bottom
            if(!(startX == endX && startY < endY)) {
                distance = (2 * n - startY - endY) * (2 * n - startY - endY) + Math.abs(startX - endX) * Math.abs(startX - endX);
                
                res = Math.min(res, distance);
            }
            
            // right
            if(!(startY == endY && startX < endX)) {
                distance = (2 * m - startX - endX) * (2 * m - startX - endX) + Math.abs(startY - endY) * Math.abs(startY - endY);
            
                res = Math.min(res, distance);
            }
            
            // left
            if(!(startY == endY && startX > endX)) {
                distance = (startX + endX) * (startX + endX) + Math.abs(startY - endY) * Math.abs(startY - endY);
            
                res = Math.min(res, distance);
            }
            
            answer[i] = res;
        }
        
        
        return answer;
    }
}