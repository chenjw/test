package emailspider.impl.extractor.xpath.model;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class NodeResult extends BaseResult {

    public NodeResult(KeyConfig config, Frame frame, XpathEngine xpathEngine) {
        super(config, frame, xpathEngine);
    }

    public Node node;

    @Override
    public void doLoad() {
    }

    @Override
    public String getStringValue() {
        throw new java.lang.IllegalStateException("multiple node have no string value "
                                                  + config.getKey());
    }
}
