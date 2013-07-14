package emailspider.impl.extractor.spi;

import emailspider.impl.extractor.xpath.XpathContext;


public interface Transformer extends Tool{
    public String transform(String input,XpathContext context);
}
