package ts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TypeScript {

  public   Map<String, Type> attributes;
  public   LinkedList<Method> methods = new LinkedList<>();
  public   Constructor constructor;


    public TypeScript() {
        constructor = new Constructor();
        attributes = new HashMap<>();
        methods = new LinkedList<>();
    }

    public Map<String, Type> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Type> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String name, Type type) {
        attributes.put(name, type);
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

    @Override
    public String toString() {

        return "{" +
                "\n attributes:" + attributes +
                ",\n methods:" + methods +
                ",\n constructor:" + constructor +
                "\n}";

    }
}
