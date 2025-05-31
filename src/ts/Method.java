package ts;

public class Method extends Constructor {

    String name;


    public Method(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Method{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
