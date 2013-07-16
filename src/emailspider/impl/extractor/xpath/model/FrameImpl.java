package emailspider.impl.extractor.xpath.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class FrameImpl implements Frame{
    private FrameImpl                    parent;
    //  Éú³ÉµÄdomÊ÷
    private Node                     root;
    private Map<String, KeyConfig>   config;
    protected XpathEngine            xpathEngine;
    private Map<String, XpathValue> values = new HashMap<String, XpathValue>();

    public void load() {
        for (Entry<String, XpathValue> entry : values.entrySet()) {
            XpathValue r = entry.getValue();
            if (!r.isLoaded()) {
                r.load();
            }
        }
    }

    public FrameImpl(Node root, Map<String, KeyConfig> config,XpathEngine xpathEngine) {
        this.root = root;
        this.config = config;
        this.xpathEngine=xpathEngine;
        for (Entry<String, KeyConfig> entry : config.entrySet()) {
            KeyConfig c = entry.getValue();
            XpathValue r = ResultFactory.createResult(c, this,xpathEngine);
            values.put(entry.getKey(), r);
        }
    }

    public NodeValue getGroup(String key) {
        XpathValue r = values.get(key);
        if (r == null) {
            throw new IllegalStateException(key + " group not found");
        } else if (!(r instanceof NodeValue)) {
            throw new IllegalStateException(key + " not a group");
        }
        return (NodeValue) r;
    }

    public String getStringValue(String key) {
        XpathValue r = values.get(key);
        if (r != null) {
            return r.getStringValue();
        }
        if (parent == null) {
            throw new IllegalStateException(key + " string value not found");
        } else {
            return parent.getStringValue(key);
        }
    }

    public Node getRoot() {
        return root;
    }

    public Map<String, XpathValue> getValues() {
        return values;
    }

    public FrameImpl getParent() {
        return parent;
    }

    public void setParent(FrameImpl parent) {
        this.parent = parent;
    }

}
