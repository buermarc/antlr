package compiler;

public class ArrayWrapper extends VarWrapper {
    private int count;

    public ArrayWrapper(String pseudoName, int count, Type type) {
        super(pseudoName, type);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
