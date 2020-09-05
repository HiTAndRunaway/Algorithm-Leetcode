class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();     //列
        Set<Integer> diagonals1 = new HashSet<Integer>();  //左上到右下方向的斜线
        Set<Integer> diagonals2 = new HashSet<Integer>();  //右上到左下方向的斜线
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //遍历每一列 判断每一列和两条斜线是否符合N皇后问题的关系
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                /*方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等，例如 (0,0)(0,0) 和 (3,3)(3,3) 在同一条                  方向一的斜线上。因此使用行下标与列下标之差即可明确表示每一条方向一的斜线。*/
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                /*
                方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等，例如 (3,0)(3,0) 和 (1,2)(1,2) 在同一条方                  向二的斜线上。因此使用行下标与列下标之和即可明确表示每一条方向二的斜线。 */
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
    //制作满足条件的棋盘的一行
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            if(queens[i] != -1){
                row[queens[i]] = 'Q';
            }
            board.add(new String(row));
        }
        return board;
    }
}
