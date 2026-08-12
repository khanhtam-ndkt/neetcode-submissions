class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        int trow = 0;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] <= target) {
                trow = mid;
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        up = 0;
        down = matrix[0].length - 1;        
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[trow][mid] == target) {
                return true;
            }
            else if (matrix[trow][mid] > target) {
                down = mid - 1;
            }
            else {
                up = mid + 1;
            }
        }
        return false;
    }
}


// 1  2  3
// 4  5  6
// 7  8  9
// 10 11 12
// target = 7
