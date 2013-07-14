package emailspider.spi;

import emailspider.model.ConnectResult;

/**
 * ��չ�㣬ʵ�����������߼�
 * 
 * @author chenjw
 * @version $Id: EmailConnector.java, v 0.1 2013��7��12�� ����9:22:16 chenjw Exp $
 */
public interface Connector {
    /**
     * ����������Ӧ�����������(�����ַ'@'����Ĳ���)
     * 
     * @return
     */
    public String getEmailServer();

    /**
     * ��½���䣬��õ�½���
     * 
     * @param email
     * @param password
     */
    public ConnectResult connect(String email, String password);
}
