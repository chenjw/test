package emailspider.core;


public interface ComponentBuilder {
    /**
     * ����Ŀ�����ͺ�Դ�봴��Ŀ��ʵ��
     * 
     * @param clazz Ŀ�����ͣ�������ĳ���ӿ�
     * @param source Ŀ��Դ��
     * @return
     */
    public <T> T build(Class<T> clazz,String source);
}

