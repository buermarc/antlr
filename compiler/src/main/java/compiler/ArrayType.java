package compiler;

import java.util.Stack;

public enum ArrayType implements TypeInterface {

    INT_ARRAY ("i32", 0),
    INT1_ARRAY ("i1", 0),
    FLOAT_ARRAY ("float", 0),
    DOUBLE_ARRAY ("double", 0);

    private int count;
    private final String typeName;

    ArrayType(String typeName, int count) {
        this.typeName = typeName;
        this.count = count;
    }

    public boolean isArray() { return true; }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() { return count; }

    static public TypeInterface fromString(String string) {
        switch (string) {
            case "i32[]":
                return INT_ARRAY;
            case "i1[]":
                return INT1_ARRAY;
            case "float[]":
                return FLOAT_ARRAY;
            case "double[]":
                return DOUBLE_ARRAY;
            default:
                return INT_ARRAY;
        }
    }

    public String internalTypeName() {
        return this.typeName;
    }

    public String typeName() {
        return "["+this.count+" x "+this.typeName+"]";
    }

    static public Pair<String, String> trunc(String pseudo, TypeInterface inputType,
                                             TypeInterface  targetType,
                                             Stack<Integer> pseudoRegisters,
                                             String block ) {
                        throw new RuntimeException("Not yet implemented");
    }

    
}
