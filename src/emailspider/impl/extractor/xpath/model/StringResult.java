package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;


public class StringResult extends  BaseResult {




    public StringResult(KeyConfig config, Frame frame, XpathEngine xpathEngine) {
        super(config, frame, xpathEngine);
    }

    @Override
    public void doLoad() {
    }

    @Override
    public String getStringValue() {
        return null;
    }

}
