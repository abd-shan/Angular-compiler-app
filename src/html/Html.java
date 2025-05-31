package html;

import java.util.List;

public class Html {
    public List<DivNode> divs;
    public Html(List<DivNode> divs){
        this.divs=divs;

    }
    public List<DivNode> getDivs() {
        return divs;
    }

    public void setDivs(List<DivNode> divs) {
        this.divs = divs;
    }

    @Override
    public String toString() {
        return "{" +
                "divs=" + divs +
                '}';
    }
}
