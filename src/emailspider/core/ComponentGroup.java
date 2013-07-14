package emailspider.core;

import java.util.List;

/**
 * 
 *  同一类组件的集合，单例，通过reload方法刷新
 * 
 * @author chenjw
 * @version $Id: ComponentHolder.java, v 0.1 2013年7月12日 下午9:14:07 chenjw Exp $
 */
public interface ComponentGroup<T> {
    /**
     *  重新加载组件
     * 
     * @param components
     */
    public void onReload(List<T> components);
}
