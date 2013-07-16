package emailspider.impl.extractor.xpath.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathContext;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public class Frame {
    //  Éú³ÉµÄdomÊ÷
    private Node                     root;
    private Map<String, KeyConfig>   rule;

    private Map<String, XpathResult> results = new HashMap<String, XpathResult>();

    public void load(XpathContext context) {
        for (Entry<String, XpathResult> entry : results.entrySet()) {
            XpathResult r = entry.getValue();
            if (!r.isLoaded()) {
                r.load(context);
            }
        }
    }

    public Frame(Node root, Map<String, KeyConfig> rule) {
        this.root = root;
        this.rule = rule;
        for (Entry<String, KeyConfig> entry : rule.entrySet()) {
            KeyConfig c = entry.getValue();
            XpathResult r;
            if (c.isMultiple()) {
                r = new MultipleResult(c);
            } else {
                r = new StringResult(c);
            }
            results.put(entry.getKey(), r);
        }
    }

    public XpathResult get(String key) {
        return results.get(key);
    }

    public Node getRoot() {
        return root;
    }

    public Map<String, XpathResult> getResults() {
        return results;
    }

}
