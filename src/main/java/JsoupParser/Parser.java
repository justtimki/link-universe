package JsoupParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by timki on 07.01.2016.
 */
public class Parser {

    private String link;

    public Parser(String link) {
        this.link = link;
    }

    public String[] findLinks() throws IOException {
        Document document = Jsoup.connect(link).userAgent("Mozilla").data("name", "jsoup").get();
        Elements elements = document.getElementsByTag("a");
        String[] strElem = new String[elements.size()];
        int i = 0;
        for(Element item : elements) {
            strElem[i] = i + " Link :" + item.attr("abs:href") + " Inner text: " + trim(item.text(), 35);
            i++;
        }

        return strElem;
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
