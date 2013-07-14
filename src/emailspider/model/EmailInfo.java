package emailspider.model;

/**
 * 邮箱信息
 * @author chenjw
 * @version $Id: EmailInfo.java, v 0.1 2013年7月12日 下午9:37:39 chenjw Exp $
 */
public class EmailInfo {
    /** 發件人 */
    private String sender;
    
    /** 郵箱標題 */
    private String title;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
