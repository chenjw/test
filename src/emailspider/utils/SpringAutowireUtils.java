package emailspider.utils;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * ʹ��spring�Զ�װ�ػ��ƣ�����beanע������
 * 
 * @author chenjw
 * @version $Id: SpringAutowireUtils.java, v 0.1 2013��7��15�� ����3:28:34 chenjw Exp $
 */
public class SpringAutowireUtils {

    /**
     * ����ʵ�� ��ע������
     * 
     * @param beanClass
     * @param context
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T  autowire(Class<T> beanClass,ApplicationContext context) {
        AutowireCapableBeanFactory acbf = findAutoWiringBeanFactory(context);
        if (acbf != null) {
            // �ڶ���������ʾװ��ģʽ
            // ������������ʾ�Ƿ�auto-check
           return  (T) acbf.autowire(beanClass,AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT,true);
        }
        else {
            return null;
        }
    }
    
    /**
     *  ע������
     *  
     * @param bean
     * @param context
     */
    public static void autowireBean(Object bean, ApplicationContext context) {
        if(context==null){
            return;
        }
        AutowireCapableBeanFactory acbf = findAutoWiringBeanFactory(context);
        if (acbf != null) {
            acbf.autowireBean(bean);
        }
    }

    private static AutowireCapableBeanFactory findAutoWiringBeanFactory(ApplicationContext context) {
        if (context instanceof AutowireCapableBeanFactory) {
            return (AutowireCapableBeanFactory) context;
        } else if (context instanceof ConfigurableApplicationContext) {
            return ((ConfigurableApplicationContext) context).getBeanFactory();
        } else if (context.getParent() != null) {
            return findAutoWiringBeanFactory(context.getParent());
        }
        return null;
    }
}
