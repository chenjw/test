package emailspider.impl.extractor;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.model.Bill;
import emailspider.spi.Parser;

public abstract class JqueryParserTemplate implements Parser {
    private XpathEngine xpathEngine;

    protected abstract Map<String, String> getXpath();

    @Override
    public Bill parse(String  text) {
        for (Entry<String, String> entry : getXpath().entrySet()) {
            String key = entry.getKey();
            xpathEngine.parse(text, entry.getValue());
        }
        return null;
    }
    
    @Override
    public Date getValidStart() {
        return null;
    }

    @Override
    public Date getValidEnd() {
        return null;
    }


}
