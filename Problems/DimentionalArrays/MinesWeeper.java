/*
 Assign Numbers in Minesweeper (Java)
Implement a function that assigns correct numbers in a field of Minesweeper, which is represented as a 2 dimensional array.
Example: The size of the field is 3x4, and there are bombs at the positions [0, 0] (row index = 0, column index = 0) and [0, 1] (row index = 0, column index = 1).
Then, the resulting field should be:

[[-1, -1, 1, 0],
 [2, 2, 1, 0],
 [0, 0, 0, 0]]

Your function should return the resulting 2D array after taking the following three arguments:
bombs: A list of bomb locations.  Given as an array of arrays.  Example: [[0, 0], [0, 1]] ([row index = 0, column index = 0], [row index = 0, column index = 1].  Assume that there are no duplicates.
num_rows: The number of rows in the resulting field.
num_columns: The number of columns in the resulting field.
In the resulting field:
-1 represents that there is a bomb in that location.
1, 2, 3... etc. represents that there are 1, 2, 3... etc. bombs in the surrounding cells (including diagonally adjacent cells).
0 represents that there are no bombs in the surrounding cells.
*/
package Problems.DimentionalArrays;

public class MinesWeeper {

  public static void main(String[] args) {
    // NOTE: The following input values will be used for testing your solution.
    int[][] bombs1 = { { 0, 2 }, { 2, 0 } };
    System.out.println("first minesweeper");
    print2DArray(mineSweeper(bombs1, 3, 3));
    // [[0, 1, -1],
    //  [1, 2, 1],
    //  [-1, 1, 0]]

    int[][] bombs2 = { { 0, 0 }, { 0, 1 }, { 1, 2 } };
    System.out.println("second minesweeper");
    print2DArray(mineSweeper(bombs2, 3, 4));
    // [[-1, -1, 2, 1],
    //  [2, 3, -1, 1],
    //  [0, 1, 1, 1]]

    int[][] bombs3 = { { 1, 1 }, { 1, 2 }, { 2, 2 }, { 4, 3 } };
    System.out.println("third minesweeper");
    print2DArray(mineSweeper(bombs3, 5, 5));
    // [[1, 2, 2, 1, 0],
    //  [1, -1, -1, 2, 0],
    //  [1, 3, -1, 2, 0],
    //  [0, 1, 2, 2, 1],
    //  [0, 0, 1, -1, 1]]
  }

  // Implement your solution below.
  public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
    int[][] field = new int[numRows][numCols];
    //place the bombs
    for (int i = 0; i < bombs.length; i++) {
      field[bombs[i][0]][bombs[i][1]] = -1;
    }
    /*traverse the array and fill it.
    be careful about boundaries of the array.
    there are maximum 8 cases to check. */
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (field[i][j] == -1) continue;
        int mineCount = 0;
        if ((i >= 1) && (j >= 1)) {
          if (field[i - 1][j - 1] == -1) mineCount++;
        }
        if ((i >= 1)) {
          if (field[i - 1][j] == -1) mineCount++;
        }
        if ((i >= 1) && (j < numCols - 1)) {
          if (field[i - 1][j + 1] == -1) mineCount++;
        }
        if ((j >= 1)) {
          if (field[i][j - 1] == -1) mineCount++;
        }
        if ((j < numCols - 1)) {
          if (field[i][j + 1] == -1) mineCount++;
        }
        if ((i < numRows - 1) && (j >= 1)) {
          if (field[i + 1][j - 1] == -1) mineCount++;
        }
        if ((i < numRows - 1)) {
          if (field[i + 1][j] == -1) mineCount++;
        }
        if ((i < numRows - 1) && (j < numCols - 1)) {
          if (field[i + 1][j + 1] == -1) mineCount++;
        }
        field[i][j] = mineCount;
      }
    }
    return field;
  }

  public static void print2DArray(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
/*Solution
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        for (int[] bomb: bombs) {
            int rowIndex = bomb[0];
            int colIndex = bomb[1];
            field[rowIndex][colIndex] = -1;
            for(int i = rowIndex - 1; i < rowIndex + 2; i++) {
                for (int j = colIndex - 1; j < colIndex + 2; j++) {
                    if (0 <= i && i < numRows &&
                            0 <= j && j < numCols &&
                            field[i][j] != -1) {
                        field[i][j] += 1;
                    }
                }
            }
        }
        return field;
    }
 }
*/
