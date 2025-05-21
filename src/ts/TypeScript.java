package ts;

import ts.types.Type;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TypeScript {

    public Map<String, Kind> attributes;
    public LinkedList<Method> methods;
    public Constructor constructor;


    public TypeScript() {
        constructor = new Constructor();
        attributes = new HashMap<>();
        methods = new LinkedList<>();
    }

    public Map<String, Kind> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Kind> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String name, Kind kind) {
        attributes.put(name, kind);
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
