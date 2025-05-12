package program;

import css.Css;
import html.Html;
import ts.TypeScript;

public class Program {



    Html html;
    Css css;
  public TypeScript typeScript = new TypeScript() ;

    public Program() {
        typeScript = new TypeScript();
    }

    public Program(Html html, Css css, TypeScript typeScript) {
        this.html = html;
        this.css = css;
        this.typeScript = typeScript;
    }

    public Html getHtml() {
        return html;
    }

//    public void setHtml(Html html) {
//        this.html = html;
//    }

    public Css getCss() {
        return css;
    }

//    public void setCss(Css css) {
//        this.css = css;
//    }

    @Override
    public String toString() {
        return "Program{" +
                "\n html=" + html +
                ",\n css=" + css +
                ",\n typeScript=" + typeScript +
                "\n}";
    }
}
