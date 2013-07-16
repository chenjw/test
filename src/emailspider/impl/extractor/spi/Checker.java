package emailspider.impl.extractor.spi;

import emailspider.impl.extractor.xpath.model.Frame;

public interface Checker extends Tool{
    public boolean check(String input,Frame frame);
}
