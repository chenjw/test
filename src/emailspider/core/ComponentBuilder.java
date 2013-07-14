package emailspider.core;

public interface ComponentBuilder {
    public <T> T build(Class<T> clazz,String desc);
}

