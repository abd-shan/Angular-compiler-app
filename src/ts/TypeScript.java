package ts;

import ts.expressions.Attribute;
import ts.types.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TypeScript {

    public ArrayList<Attribute> attributes;
    public LinkedList<Method> methods;
    public Constructor constructor;


    public TypeScript() {
        constructor = new Constructor();
        attributes = new ArrayList<>();
        methods = new LinkedList<>();
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public LinkedList<Method> getMethods() {
        return methods;
    }

    public void setMethods(LinkedList<Method> methods) {
        this.methods = methods;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public void addMethod(Method method) {
        methods.add(method);
    }


    @Override
    public String toString() {

        return "{" +
                "\n attributes:" + attributes +
                ",\n methods:" + methods +
                ",\n constructor:" + constructor +
                "\n}";

    }
}
