package emailspider.impl.extractor.spi;

import emailspider.impl.extractor.xpath.XpathContext;

public interface Checker extends Tool{
    public boolean check(String input,XpathContext context);
}
