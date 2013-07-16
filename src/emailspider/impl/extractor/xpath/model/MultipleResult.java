package emailspider.impl.extractor.xpath.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;
import emailspider.impl.extractor.xpath.config.MultpleConfig;

public class MultipleResult extends BaseResult {

    public MultipleResult(KeyConfig config, Frame frame, XpathEngine xpathEngine) {
        super(config, frame, xpathEngine);
    }

    private List<Node>                     nodeList;
    private List<Map<String, XpathResult>> results = new ArrayList<Map<String, XpathResult>>();

    @Override
    public void doLoad() {

        // TODO ȡ��nodeList��ֵ

        MultpleConfig multpleConfig = config.getRows();
        Map<String, KeyConfig> subKeyConfigs = multpleConfig.getItems();
        for (Node node : nodeList) {
            FrameImpl newFrame = new FrameImpl(node, subKeyConfigs, xpathEngine);
            newFrame.load();
            results.add(newFrame.getResults());
        }
        // ���check��
    }

    @Override
    public String getStringValue() {
        throw new java.lang.IllegalStateException("multiple node have no string value "
                                                  + config.getKey());
    }

}
