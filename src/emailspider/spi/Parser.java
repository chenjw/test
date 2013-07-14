package emailspider.spi;

import java.util.Date;

import emailspider.core.Lifecycle;
import emailspider.model.Bill;

/**
 * ��չ�㣬��html�г�ȡ���ʵ���Ϣ
 * 
 * @author chenjw
 * @version $Id: Extractor.java, v 0.1 2013��7��12�� ����9:21:31 chenjw Exp $
 */
public interface Parser {
    /**
     * <p>��Ч����ʼ���ڣ���ȷ���죬��������</p>
     *<p> ���Ϊnull��ʾû����Ч������</p>
     * @return
     */
    public Date getValidStart();
    
    /**
     * <p>��Ч��ʧЧ���ڣ���ȷ���죬����������</p>
     * <p>���Ϊnull��ʾû����Ч������ </p>
     * @return
     */
    public Date getValidEnd();
    
    /**
     * �ý�������Ե����б���
     * 
     * @return
     */
    public String getBankCode();
    
    public Bill parse(String text);
}
