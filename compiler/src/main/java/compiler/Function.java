package compiler;

import java.util.List;
import java.util.ArrayList;

public class Function {
    TypeInterface ret;
    String name;
    List<Pair<TypeInterface, String>> parameters;

    public Function(String name) {
        this.name = name;
        this.parameters = new ArrayList<Pair<TypeInterface, String>>();
    }

    public Function(TypeInterface ret, String name) {
        this.ret = ret;
        this.name = name;
        this.parameters = new ArrayList<Pair<TypeInterface, String>>();
    }

    public Function(TypeInterface ret, String name, List<Pair<TypeInterface, String>> parameters) {
        this.ret = ret;
        this.name = name;
        this.parameters = parameters;
    }

    public void addParameter(Pair<TypeInterface, String> param) {
        this.parameters.add(param);
    }

    public TypeInterface getRetType() {
        return this.ret;
    }

    public String getName() {
        return this.name;
    }

    public List<Pair<TypeInterface, String>> getParameters() {
        return this.parameters;
    }

    public static boolean compare(Function f1, Function f2) {
        if (!f1.name.equals(f2.name)) { 
            System.err.println("name false");
            return false;
        }

        System.err.println("CHECK FUNCTIONS " + f1.name + " " + f2.name);
        if (f1.name.equals("println"))
            return true;

        if (f1.parameters.size() == f2.parameters.size()) {
            //Check if entrys are the same TODO consider order of params
            // boolean forEach = true; 
            if ((f1.parameters.size() == 0) && (f2.parameters.size() == 0))  {
                System.err.println("Both functions have 0 params and same name");
                return true;
            }

            for (Pair<TypeInterface, String> parameter1 : f1.parameters) {
                boolean found = false;
                TypeInterface type = parameter1.getKey();

                System.err.println(type + " :: " + f1.parameters );
                for (Pair<TypeInterface, String>parameter2 : f1.parameters) {
                    // Check if type is also the same, we don't care about the name of the parameters
                    System.err.println(type + " :: " + parameter2.getKey());
                    if (type == parameter2.getKey()) {
                        found = true;
                    }
                }
                if (!found) 
                    return false;
            }
            return true;
        } else { 
            System.err.println("Wrong paramcount");
            System.err.println(f1.parameters.size()+" "+ f2.parameters.size());
            return false;
        }
    }




}
