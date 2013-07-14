package emailspider.impl.extractor.spi;

public interface Selector extends Tool{
    public String select(String text);
}
