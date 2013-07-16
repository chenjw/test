package emailspider.core;


public interface ComponentBuilder {
    /**
     * 根据目标类型和源码创建目标实例
     * 
     * @param clazz 目标类型，可以是某个接口
     * @param source 目标源码
     * @return
     */
    public <T> T build(Class<T> clazz,String source);
}

