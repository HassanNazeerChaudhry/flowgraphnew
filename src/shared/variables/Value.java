package shared.variables;

public class Value extends Operands {
  private  int val;

    public Value() {
    }

    public Value(int val) {
        this.val = val;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
