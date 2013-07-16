package emailspider.impl.extractor.spi;

import emailspider.impl.extractor.xpath.model.Frame;


public interface Transformer extends Tool{
    public String transform(String input,Frame frame);
}
