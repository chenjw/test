package emailspider.core;

import java.util.List;

/**
 * 
 *  ͬһ������ļ��ϣ�������ͨ��reload����ˢ��
 * 
 * @author chenjw
 * @version $Id: ComponentHolder.java, v 0.1 2013��7��12�� ����9:14:07 chenjw Exp $
 */
public interface ComponentGroup<T> {
    /**
     *  ���¼������
     * 
     * @param components
     */
    public void onReload(List<T> components);
}
