package emailspider.impl.extractor.xpath.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class Frame {
    private Frame                    parent;
    //  Éú³ÉµÄdomÊ÷
    private Node                     root;
    private Map<String, KeyConfig>   config;
    protected XpathEngine            xpathEngine;
    private Map<String, XpathResult> results = new HashMap<String, XpathResult>();

    public void load() {
        for (Entry<String, XpathResult> entry : results.entrySet()) {
            XpathResult r = entry.getValue();
            if (!r.isLoaded()) {
                r.load();
            }
        }
    }

    public Frame(Node root, Map<String, KeyConfig> config,XpathEngine xpathEngine) {
        this.root = root;
        this.config = config;
        this.xpathEngine=xpathEngine;
        for (Entry<String, KeyConfig> entry : config.entrySet()) {
            KeyConfig c = entry.getValue();
            XpathResult r = ResultFactory.createResult(c, this,xpathEngine);
            results.put(entry.getKey(), r);
        }
    }

    public NodeResult getGroup(String key) {
        XpathResult r = results.get(key);
        if (r == null) {
            throw new IllegalStateException(key + " group not found");
        } else if (!(r instanceof NodeResult)) {
            throw new IllegalStateException(key + " not a group");
        }
        return (NodeResult) r;
    }

    public String getStringValue(String key) {
        XpathResult r = results.get(key);
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

    public Map<String, XpathResult> getResults() {
        return results;
    }

    public Frame getParent() {
        return parent;
    }

    public void setParent(Frame parent) {
        this.parent = parent;
    }

}
