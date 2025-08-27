package ast.html;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlDocument {
    private List<Node> nodes;

    public HtmlDocument() {
        this.nodes = new ArrayList<>();
    }

    public HtmlDocument(List<Node> nodes) {
        this.nodes = nodes != null ? nodes : new ArrayList<>();
    }

    public void addNode(Node node) {
        if (node != null) {
            nodes.add(node);
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }


    @Override
    public String toString() {
        return nodes.stream()
                .map(Node::toString)
                .collect(Collectors.joining("\n"));
    }
}