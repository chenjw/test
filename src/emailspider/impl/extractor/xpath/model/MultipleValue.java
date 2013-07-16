package emailspider.impl.extractor.xpath.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;
import emailspider.impl.extractor.xpath.config.MultpleConfig;

public class MultipleValue extends BaseValue {

    public MultipleValue(KeyConfig config, Frame frame, XpathEngine xpathEngine) {
        super(config, frame, xpathEngine);
    }

    private List<Node>                     nodeList;
    private List<Map<String, XpathValue>> values = new ArrayList<Map<String, XpathValue>>();

    @Override
    public void doLoad() {

        // TODO 取得nodeList的值

        MultpleConfig multpleConfig = config.getRows();
        Map<String, KeyConfig> subKeyConfigs = multpleConfig.getItems();
        for (Node node : nodeList) {
            FrameImpl newFrame = new FrameImpl(node, subKeyConfigs, xpathEngine);
            newFrame.load();
            values.add(newFrame.getValues());
        }
        // 最后check下
    }

    @Override
    public String getStringValue() {
        throw new java.lang.IllegalStateException("multiple node have no string value "
                                                  + config.getKey());
    }

}
