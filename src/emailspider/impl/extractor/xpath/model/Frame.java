package emailspider.impl.extractor.xpath.model;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Frame {
    //  Éú³ÉµÄdomÊ÷
    private Node root;
    private Map<String,XpathResult> parsedResults=new HashMap<String,XpathResult>();
    
    public XpathResult get(String key){
        return parsedResults.get(key);
    }
}
