package emailspider.model;

/**
 * ������Ϣ
 * @author chenjw
 * @version $Id: EmailInfo.java, v 0.1 2013��7��12�� ����9:37:39 chenjw Exp $
 */
public class EmailInfo {
    /** �l���� */
    private String sender;
    
    /** �]����} */
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
