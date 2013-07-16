package emailspider.impl.extractor.xpath;

import emailspider.impl.extractor.xpath.model.Frame;

public interface XpathContext {

    public String get(String key);

    public void addFrame(Frame frame);
}
