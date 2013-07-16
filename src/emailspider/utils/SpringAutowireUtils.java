package emailspider.utils;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * 使用spring自动装载机制，帮助bean注入依赖
 * 
 * @author chenjw
 * @version $Id: SpringAutowireUtils.java, v 0.1 2013年7月15日 下午3:28:34 chenjw Exp $
 */
public class SpringAutowireUtils {

    /**
     * 创建实例 并注入依赖
     * 
     * @param beanClass
     * @param context
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T  autowire(Class<T> beanClass,ApplicationContext context) {
        AutowireCapableBeanFactory acbf = findAutoWiringBeanFactory(context);
        if (acbf != null) {
            // 第二个参数表示装配模式
            // 第三个参数表示是否auto-check
           return  (T) acbf.autowire(beanClass,AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT,true);
        }
        else {
            return null;
        }
    }
    
    /**
     *  注入依赖
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
