package compiler;

import java.util.Stack;

interface TypeInterface {

    static public TypeInterface fromString(String string) {
        System.err.println("Should not get here");
        return null;
    };

    public boolean isArray();
    public String name();

    public String typeName();

    static public Pair<String, String> trunc(String pseudo, TypeInterface inputType, 
                                             TypeInterface targetType, 
                                             Stack<Integer> pseudoRegisters,
                                             String block) {
        return null;
    }

}
