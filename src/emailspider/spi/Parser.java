package emailspider.spi;

import java.util.Date;

import emailspider.core.Lifecycle;
import emailspider.model.Bill;

/**
 * 扩展点，从html中抽取出帐单信息
 * 
 * @author chenjw
 * @version $Id: Extractor.java, v 0.1 2013年7月12日 下午9:21:31 chenjw Exp $
 */
public interface Parser {
    /**
     * <p>有效期起始日期，精确到天，包含该天</p>
     *<p> 如果为null表示没有有效期上限</p>
     * @return
     */
    public Date getValidStart();
    
    /**
     * <p>有效期失效日期，精确到天，不包含该天</p>
     * <p>如果为null表示没有有效期下限 </p>
     * @return
     */
    public Date getValidEnd();
    
    /**
     * 该解析器针对的银行编码
     * 
     * @return
     */
    public String getBankCode();
    
    public Bill parse(String text);
}
