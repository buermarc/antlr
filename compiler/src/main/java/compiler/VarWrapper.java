package compiler;

public class VarWrapper {
    String pseudoRegister;
    Type type;
    boolean mutable;

    public VarWrapper(String pseudoRegister, Type type, boolean mutable) {
        this.pseudoRegister = pseudoRegister; 
        this.type = type;
        this.mutable = mutable;
    }

    public String getPseudo() {
        return this.pseudoRegister;
    }

    public void setPseudo(String pseudoRegister) {
        this.pseudoRegister =  pseudoRegister;
    }

    public Type getType() {
        return this.type; 
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean getMutable() {
        return this.mutable;
    }
}
