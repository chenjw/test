package emailspider.spi;

import emailspider.model.ConnectResult;

/**
 * 扩展点，实现邮箱连接逻辑
 * 
 * @author chenjw
 * @version $Id: EmailConnector.java, v 0.1 2013年7月12日 下午9:22:16 chenjw Exp $
 */
public interface Connector {
    /**
     * 该连接器对应的邮箱服务器(邮箱地址'@'后面的部分)
     * 
     * @return
     */
    public String getEmailServer();

    /**
     * 登陆邮箱，获得登陆结果
     * 
     * @param email
     * @param password
     */
    public ConnectResult connect(String email, String password);
}
