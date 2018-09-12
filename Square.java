public class Square {

    private int value;
    private boolean[] pencilMarks;

    public Square() {
      value = 0;
      pencilMarks = new boolean[] {false, true, true, true, true,
                                  true, true, true, true, true};
    }

    public Square(int value) {
      this.value = value;
      pencilMarks = new boolean[] {false, false, false, false, false,
                                 false, false, false, false, false};
    }


  void printAll() {
    System.out.println("value is = " + value);
    System.out.print('{');
    for (boolean mark : pencilMarks) {
      System.out.print(mark + ",");
    }
    System.out.println("\b}");
  }

  void print() {
    System.out.print(value + " ");
  }


    public int value() {
        return value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public boolean hasUniquePMark() {
      int numberPencilMarks = 0;
      for (int i = 1; i < pencilMarks.length; i++) {
        if(pencilMarks[i]) {
          numberPencilMarks++;
        }
      }
      return numberPencilMarks == 1;
    }

    public int uniquePMark() {
      assert hasUniquePMark() : "must only have one pencil mark";
      for(int i = 1; i < pencilMarks.length; i++) {
        if (pencilMarks[i]) {
          return i;
        }
      }
      return 0;
    }

    public void removePMarkIfThere(int n) {
      pencilMarks[n] = false;
    }
}