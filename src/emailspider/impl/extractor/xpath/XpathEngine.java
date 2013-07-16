package emailspider.impl.extractor.xpath;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface XpathEngine {
    public Document clean(String text);
    
    
    public Node parseNode(String text,String path);
    
    public String parseString(Node node,String path);
    
    public List<Node> parseList(Node node,String path);
}
