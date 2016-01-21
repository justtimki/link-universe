package JsoupParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;


/**
 * Created by timki on 07.01.2016.
 */
public class Parser {

    private String link;

    public Parser(String link) {
        this.link = link;
    }

    public HashSet<String> findLinks() throws IOException {
        Document document = Jsoup.connect(link).userAgent("Mozilla").data("name", "jsoup").get();
        Elements elements = document.getElementsByTag("a");
        HashSet<String> links = new HashSet<String>(elements.size());
        for(Element item : elements) {
            links.add(item.attr("abs:href").trim());
        }
        return links;
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
