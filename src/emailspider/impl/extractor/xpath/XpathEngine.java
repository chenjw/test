package emailspider.impl.extractor.xpath;

import java.util.List;

public interface XpathEngine {
    public String parse(String text,String path);
    
    
    public List<String> multiParse(String text,String path);
}
