package html;

import java.util.List;

public class InlineTemplate implements HtmlOption {
    private final List<HtmlNode> nodes;

    public InlineTemplate(List<HtmlNode> nodes) {
        this.nodes = nodes;
    }

    public List<HtmlNode> getNodes() {
        return nodes;
    }
}

