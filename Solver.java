public class Solver {

  static int[][] sudoku = {
      {6, 0, 5, 1, 0, 0, 2, 4, 0},
      {0, 7, 0, 4, 0, 0, 5, 1, 0},
      {0, 9, 4, 0, 8, 0, 7, 0, 0},
      {0, 0, 2, 0, 9, 0, 0, 0, 0},
      {5, 0, 0, 2, 4, 6, 0, 0, 3},
      {0, 0, 0, 0, 3, 0, 1, 0, 0},
      {0, 0, 6, 0, 2, 0, 4, 8, 0},
      {0, 2, 1, 0, 0, 4, 0, 9, 0},
      {0, 3, 7, 0, 0, 8, 6, 0, 2}
  };

  public static void main(String[] args) {
    Grid grid = new Grid(sudoku);
    System.out.println("Input grid:");
    grid.print();
    while (grid.hasFreeSpace()) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (grid.isGoodMove(i, j)) {
            grid.makeMove(i, j);
            grid.removePMarks(i, j);
          }
        }
      }
    }
    System.out.println("Solution:");
    grid.print();
  }
}
