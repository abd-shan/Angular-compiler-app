package  ast.ts.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents an array literal
 */

public class ArrayLiteral implements TsAtom {
    private final List<TsExpression> elements;

    public ArrayLiteral(List<TsExpression> elements) {
        this.elements = elements != null ? new ArrayList<>(elements) : new ArrayList<>();
    }

    public List<TsExpression> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}


//public class ArrayLiteral implements TsAtom {
//
//    private Map<Literal,KeyValuePair> array;
//
//    public ArrayLiteral(Map<Literal, KeyValuePair> array) {
//        this.array = array;
//    }
//
//    public Map<Literal, KeyValuePair> getArray() {
//        return array;
//    }
//
//    @Override
//    public String toString() {
//        return "ArrayLiteral{" +
//                "array=" + array +
//                '}';
//    }
//}