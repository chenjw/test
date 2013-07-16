package emailspider.impl.extractor.xpath.model;



public interface XpathResult {
    
    /**
     * 是否抽取成功
     * 
     * 
     * @return
     */
    public boolean isLoaded();
    
    public void load();
    
    public String getStringValue();
}
