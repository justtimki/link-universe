import filters.LinkFilter;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by timki on 09.01.2016.
 */
public class TestFilter {

    @Test
    public void testEmpty() {
        LinkFilter linkFilter = new LinkFilter("");
        boolean res = linkFilter.isEmptyLink("safdasd");
        Assert.assertEquals(false, res);
    }
}
