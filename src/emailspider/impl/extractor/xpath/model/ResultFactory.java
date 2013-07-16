package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class ResultFactory {
    public static XpathValue createResult(KeyConfig c, Frame f,XpathEngine xpathEngine) {

        switch (c.getType()) {
            case STRING:
                return new StringValue(c, f,xpathEngine);
            case NODE:
                return new NodeValue(c, f,xpathEngine);
            case MULTIPLE:
                return new MultipleValue(c, f,xpathEngine);
            default:
                throw new IllegalStateException("not support type " + c.getType());
        }
    }
}
