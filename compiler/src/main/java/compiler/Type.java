package compiler;

import java.util.Stack;

public enum Type implements TypeInterface {
    VOID ("void"),
    INT ("i32"),
    INT1 ("i1"),
    FLOAT ("float"),
    STRING ("String"),
    DOUBLE ("double");

    private final String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    public boolean isArray() { return false;}

    public String typeName() { return this.typeName; } 

    static public TypeInterface fromString(String string) {
        switch (string) {
            case "void":
                return VOID;
            case "i32":
                return INT;
            case "i1":
                return INT1;
            case "float":
                return FLOAT;
            case "String":
                return STRING;
            case "double":
                return DOUBLE;
            default:
                return ArrayType.fromString(string);
        }
    }
    static public Pair<String, String> trunc(String pseudo, TypeInterface inputType,
                                 TypeInterface targetType,
                                 Stack<Integer> pseudoRegisters,
                                 String block) {
        String localPseudoRegister = "%"+pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop()+1);
        block += localPseudoRegister+" = trunc "+inputType.typeName()+" "+pseudo+
                                   " to "+ targetType.typeName()+"\n";
        return new Pair<String, String>(localPseudoRegister, block);
    }
}
