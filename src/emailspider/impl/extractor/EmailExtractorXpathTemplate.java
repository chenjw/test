package emailspider.impl.extractor;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import emailspider.core.Lifecycle;
import emailspider.impl.extractor.spi.Checker;
import emailspider.impl.extractor.spi.Transformer;
import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.model.Bill;
import emailspider.spi.Parser;

public abstract class EmailExtractorXpathTemplate implements Parser,Lifecycle {
    private XpathEngine xpathEngine;

    public void init() {
       config();
       rule();
    }

    public void destroy() {

    }

    protected abstract Map config();
    
    protected abstract Map rule();

    @Override
    public String getBankCode() {
        return null;
    }
    
    protected  Transformer[] transformers(){
        return null;
    }

    protected  Checker[] checkers(){
        return null;
    }

    public Bill parse(String text) {

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
