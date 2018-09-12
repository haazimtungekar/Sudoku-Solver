public class Grid {

  private Square[][] grid = new Square[9][9];

  public Grid(int[][] nums) {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        Square s;
        if(nums[i][j] == 0) {
          s = new Square();
        } else {
          s = new Square(nums[i][j]);
        }
        grid[i][j] = s;
      }
    }
    removeSurplusPMarks();
  }

  void print() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j].print();
      }
      System.out.println();
    }
  }

  boolean hasFreeSpace() {
    for(int row = 0; row < 9; row++) {
      for(int col = 0; col < 9; col++) {
        if (grid[row][col].isEmpty()) {
          return true;
        }
      }
    }
    return false;
  }

  boolean isGoodMove(int row, int col){
    return grid[row][col].hasUniquePMark();
  }

  void makeMove(int row, int col) {
    assert(isGoodMove(row, col)) : "Must be a good move";
    grid[row][col] = new Square(grid[row][col].uniquePMark());

  }

  private void removeSurplusPMarks() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        removePMarks(i, j);
      }
    }
  }

  //Remove pencil marks for all squares in the same row/column/block to the current square
  void removePMarks(int row, int col) {
    int squareValue = grid[row][col].value();

    //remove pencil marks in the same row
    for(int column = 0; column < 9; column++) {
      grid[row][column].removePMarkIfThere(squareValue);
    }

    //remove pencil marks in the same column
    for(int rows = 0; rows < 9; rows++) {
      grid[rows][col].removePMarkIfThere(squareValue);
    }

    //remove pencil marks in the same block
    int startRow = startIndex(row);
    int startCol = startIndex(col);

    for(int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        grid[i][j].removePMarkIfThere(squareValue);
      }
    }

  }

  private int startIndex(int n) {
    assert(n >= 0 && n < 9): "Must be a number between 0 and 8";
    switch(n) {

      case 0: case 1: case 2:
        return 0;

      case 3: case 4: case 5:
        return 3;

      default: //cases 6,7,8
        return 6;
    }
  }
}
