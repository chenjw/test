package emailspider.spi;

import emailspider.model.EmailInfo;

public interface Filter  {
    
    /**
     * ���˵����б���
     * 
     * @return
     */
    public String getBankCode();
    
    /**
     * �ж��ʼ��Ƿ����˵�
     * 
     * @param emailInfo
     * @return
     */
    public boolean isBill(EmailInfo emailInfo);
}
