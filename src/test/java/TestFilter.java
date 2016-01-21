import JsoupParser.Parser;
import filters.LinkFilter;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by timki on 09.01.2016.
 */
public class TestFilter {

    @Test
    public void testGetValidLinks() throws IOException {
        Parser parser = new Parser("http://www.pixic.ru/");
        HashSet<String> allLinks = parser.findLinks();
        LinkFilter linkFilter = new LinkFilter("http://www.pixic.ru/", allLinks);
        HashSet<String> validLinks = linkFilter.getValidWebsiteLinks();
        for (String link : validLinks) {
            assertNotEquals(" ", link); //TODO tests another methods
        }
    }
}
