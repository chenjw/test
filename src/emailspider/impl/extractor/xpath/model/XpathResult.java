package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathContext;


public interface XpathResult {
    
    /**
     * 是否抽取成功
     * 
     * 
     * @return
     */
    public boolean isLoaded();
    
    public void load(XpathContext context);
}
