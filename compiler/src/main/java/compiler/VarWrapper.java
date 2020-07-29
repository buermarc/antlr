package compiler;

public class VarWrapper {
    String pseudoRegister;
    Type type;

    public VarWrapper(String pseudoRegister, Type type) {
        this.pseudoRegister = pseudoRegister; 
        this.type = type;
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
}
