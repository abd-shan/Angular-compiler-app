package html;

import java.util.List;

public class HtmlNode extends Html {
    private List<DivNode> divs;

    public HtmlNode(List<DivNode> divs) {
        this.divs = divs;
    }

    public List<DivNode> getDivs() {
        return divs;
    }

    public void setDivs(List<DivNode> divs) {
        this.divs = divs;
    }


    @Override
    public String toString() {
        return divs.toString();
    }
}

