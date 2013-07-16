package emailspider.impl.extractor.xpath.config;

import java.util.Map;
import java.util.regex.Pattern;

import emailspider.impl.extractor.spi.Checker;

public class MultpleConfig {
    private Pattern checker;
    private Checker javaChecker;

    private Map<String,KeyConfig> items;

    public Pattern getChecker() {
        return checker;
    }

    public void setChecker(Pattern checker) {
        this.checker = checker;
    }

    public Checker getJavaChecker() {
        return javaChecker;
    }

    public void setJavaChecker(Checker javaChecker) {
        this.javaChecker = javaChecker;
    }

    public Map<String, KeyConfig> getItems() {
        return items;
    }

    public void setItems(Map<String, KeyConfig> items) {
        this.items = items;
    }
    
    
    
}
