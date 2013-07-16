package emailspider.impl.extractor.xpath.model;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathContext;
import emailspider.impl.extractor.xpath.config.KeyConfig;


public class GroupResult extends  BaseResult {
    public GroupResult(KeyConfig config) {
        super(config);
    }

    public Node node;

    @Override
    public void load(XpathContext context) {
    }
}
