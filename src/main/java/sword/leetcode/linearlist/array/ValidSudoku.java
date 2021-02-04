package sword.leetcode.linearlist.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: draft
 * @description:
 * Valid Sudoku:
 * Determine[vt.决定,确定;判定,判决;限定] if a Sudoku is valid, according to:
 * Sudoku Puzzles[n. 谜题（puzzle的复数）；智力游戏；游戏拼图] - The Rules http://sudoku.com.au/TheRules.aspx.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * How Sudoku is Played?
 * There are just 3 rules to Sudoku.
 * Each row must have the numbers 1-9 occuring just once.
 * Each column must have the numbers 1-9 occuring just once.
 * And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.如图->ValidSudoku.jpg
 * Example1:
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 * Example2:
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Solution:
 * 数独问题是个二维的图，实际是有三个条件下都没有重复的数据，
 * 很明显用Set来过滤，如果数据加入失败，那么表示数据已经存在。
 * 接下来降维解决，把二维图化解为三个条件的一维处理。
 * row横向方向是否重复
 * column纵向方向是否重复
 * cube方框内是否重复
 * 该题重点是如何判断cube是不重复的
 * 每个cube是一个3x3的方格,如果把cube看作一个整体则可把Sudoku视为一个3x3的二维数组。
 * 每个cube都对应一个index作为唯一标识。
 * 我们把9x9数组的横纵坐标/3然后拼接。
 *
 *
 * @author: atong
 * @create: 2021-02-03 14:04
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Output 1: " + isValidSudoku(board1));
        System.out.println("Output 2: " + isValidSudoku(board2));
        System.out.println("================");
        System.out.println("Output 1: " + isValidSudokuI(board1));
        System.out.println("Output 2: " + isValidSudokuI(board2));
    }

    /**
     * 校验二维数组是否符合数组规则
     * @param board 二维数组
     * @return boolean true->符合,false->不符合
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<String> visitSet = new HashSet<>(81);
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char data = board[row][column];
                if (data == '.') {
                    continue;
                }
                if (!visitSet.add(data + " row " + row)) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " row " + row);
                    return false;
                }
                if (!visitSet.add(data + " column " + column)) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " column " + column);
                    return false;
                }
                if (!visitSet.add(data + " cube " + row/3 + '-' + column/3) ) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " cube " + row/3 + '-' + column/3);
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 校验二维数组是否符合数组规则校验二维数组是否符合数组规则
     * 较优解
     * @param board 二维数组
     * @return true->符合,false->不符合
     */
    public static boolean isValidSudokuI(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char num = board[row][column];
                if (num != '.') {
                    int n = (int)num;
                    //参考 ValidSudokuBoxIndex.png
                    int box_index = (row / 3 ) * 3 + column / 3;

                    // keep the current cell value
                    rows[row].put(n, rows[row].getOrDefault(n, 0) + 1);
                    columns[column].put(n, columns[column].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[row].get(n) > 1 || columns[column].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
