package compiler;

public class StringWrapper {
    private String string;
    private int length;

    public StringWrapper(String string, int length) {
        this.string = string;
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    public String getString() {
        return this.string;
    }
}
