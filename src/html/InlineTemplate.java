package html;

import java.util.List;

public class InlineTemplate implements HtmlOption {
    private final String nodes;

    public InlineTemplate(String nodes) {
        this.nodes = nodes;
    }

    public String getNodes() {
        return nodes;
    }
}

