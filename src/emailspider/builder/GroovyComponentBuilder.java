package emailspider.builder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import emailspider.core.ComponentBuilder;
import emailspider.spi.Parser;
import emailspider.utils.SpringAutowireUtils;
import groovy.lang.GroovyClassLoader;

/**
 * ʵ����ʹ��groovy��д�����
 * 
 * @author chenjw
 * @version $Id: GroovyComponentBuilder.java, v 0.1 2013��7��15�� ����3:39:37 chenjw Exp $
 */
public class GroovyComponentBuilder implements ComponentBuilder, ApplicationContextAware {
    private ApplicationContext applicationcontext;
    // GroovyClassLoader��innerClassLoader�Ļ��ƣ�ʵ���ϼ��ص�ÿ��class����һ��������innerclassloader���ص�
    // �������������ʵ��û�����ú�innerClassLoaderҲ�����
    // ���ԣ��������迼�Ǽ�����Ļ������⣬�Լ��������������ͻ���⣬GroovyClassLoaderֻ��Ҫ����һ��ʵ��
    private GroovyClassLoader  groovyClassLoader = new GroovyClassLoader(Thread.currentThread()
                                                     .getContextClassLoader());

    @Override
    public <T> T build(Class<T> clazz, String source) {
       T component=load(clazz,source);
       // ����������������Ҫspringע������ԣ���Ҫ�Զ���������ע������
       if(component!=null){
           SpringAutowireUtils.autowireBean(component, applicationcontext);
       }
       return component;
    }
    
    @SuppressWarnings("unchecked")
    private <T> T load(Class<T> clazz, String source) {
        Class<?> loadedClazz = groovyClassLoader.parseClass(source);
            Assert.notNull(loadedClazz, "parse class fail " + clazz.getName());
        try {
            Object instance = loadedClazz.newInstance();
            Assert.isInstanceOf(clazz, instance, "isInstance fail " + clazz.getName());
            return (T) instance;
        } catch (InstantiationException e) {
            throw new IllegalStateException("newInstance fail " + clazz.getName(), e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("newInstance fail " + clazz.getName(), e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {
        this.applicationcontext = applicationcontext;
    }
    
    public static void main(String[] args) throws IOException{
        GroovyComponentBuilder builder=new GroovyComponentBuilder();
        {
        
            String source=FileUtils.readFileToString(new File("C:\\my_workspace\\emailspider\\src\\emailspider\\impl\\extractor\\groovy\\Zhaoshang1.groovy"));
           Parser parser= builder.build(Parser.class, source);
           System.out.println(parser);
           parser=null;
           System.gc();
        }
        {
            
            String source=FileUtils.readFileToString(new File("C:\\my_workspace\\emailspider\\src\\emailspider\\impl\\extractor\\groovy\\Zhaoshang2.groovy"));
           Parser parser= builder.build(Parser.class, source);
           System.out.println(parser);
        }
     
    }
}
