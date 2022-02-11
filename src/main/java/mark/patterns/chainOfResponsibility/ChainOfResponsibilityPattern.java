package mark.patterns.chainOfResponsibility;

import java.util.ArrayList;

class MsgProcessor {
    private String msg;
    private FilterChain fc;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setFc(FilterChain fc) {
        this.fc = fc;
    }

    public String process() {
        return fc.doFilter(msg);
    }

}

class FilterChain implements Filter{

    ArrayList<Filter> filters = new ArrayList<>();
    public FilterChain addFilter(Filter f) {
        this.filters.add(f);
        return this;
    }
    public String doFilter(String str) {
        String result = str;
        for(Filter f: filters)
            result = f.doFilter(result);
        return result;
    }

}

interface Filter {
    String doFilter(String str);
}

class HTMLFilter implements Filter {

    public String doFilter(String str) {
        return str.replaceAll("</", "(").
                replaceAll(">",")").
                    replaceAll("<","(");
    }

}

class FirstLetterFilter implements Filter {

    public String doFilter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

class PolitenessFilter implements Filter {

    public String doFilter(String str) {
        return str.replaceAll ("Привет", "Здравствуйте");
    }

}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        String msg = "Привет, <h1>Как настроение?</h1>.";

        MsgProcessor mp = new MsgProcessor();
        mp.setMsg(msg);

        FilterChain fc = new FilterChain();
        fc.addFilter(new FirstLetterFilter()).addFilter(new PolitenessFilter()).addFilter(new HTMLFilter());

        mp.setFc(fc);
        String result = mp.process();
        System.out.println("Исходная строка: " + msg);
        System.out.println("Результирующая строка: " + result);
    }
}
