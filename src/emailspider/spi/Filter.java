package emailspider.spi;

import emailspider.model.EmailInfo;

public interface Filter  {
    
    /**
     * 过滤的银行编码
     * 
     * @return
     */
    public String getBankCode();
    
    /**
     * 判断邮件是否是账单
     * 
     * @param emailInfo
     * @return
     */
    public boolean isBill(EmailInfo emailInfo);
}
