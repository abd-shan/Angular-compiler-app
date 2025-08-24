package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTemplate {
    private List<HtmlNode> nodes;

    public HtmlTemplate() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(HtmlNode node) {
        nodes.add(node);
    }

    public List<HtmlNode> getNodes() {
        return nodes;
    }
}
