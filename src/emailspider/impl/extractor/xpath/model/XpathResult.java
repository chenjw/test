package emailspider.impl.extractor.xpath.model;



public interface XpathResult {
    
    /**
     * �Ƿ��ȡ�ɹ�
     * 
     * 
     * @return
     */
    public boolean isLoaded();
    
    public void load();
    
    public String getStringValue();
}
