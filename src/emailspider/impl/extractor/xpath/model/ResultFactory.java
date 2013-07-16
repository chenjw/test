package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class ResultFactory {
    public static XpathResult createResult(KeyConfig c, Frame f,XpathEngine xpathEngine) {

        switch (c.getType()) {
            case STRING:
                return new StringResult(c, f,xpathEngine);
            case NODE:
                return new NodeResult(c, f,xpathEngine);
            case MULTIPLE:
                return new MultipleResult(c, f,xpathEngine);
            default:
                throw new IllegalStateException("not support type " + c.getType());
        }
    }
}
