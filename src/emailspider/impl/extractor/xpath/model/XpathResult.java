package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathContext;


public interface XpathResult {
    
    /**
     * �Ƿ��ȡ�ɹ�
     * 
     * 
     * @return
     */
    public boolean isLoaded();
    
    public void load(XpathContext context);
}
