package compiler;

public class ArrayWrapper extends VarWrapper {
    private int count;

    public ArrayWrapper(String pseudoName, int count, boolean mutable, Type type) {
        super(pseudoName, type, mutable);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
