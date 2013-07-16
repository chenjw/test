package emailspider.impl.extractor.xpath.config;

import java.util.regex.Pattern;

import emailspider.impl.extractor.spi.Selector;
import emailspider.impl.extractor.xpath.model.TypeEnum;

public class KeyConfig {
    private String        key;
    private boolean       required = false;
    private TypeEnum      type     = TypeEnum.STRING;
    private String[]      selector = null;
    private Pattern       checker;
    private Selector      javaSelector;
    private String        parent;

    private MultpleConfig rows;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String[] getSelector() {
        return selector;
    }

    public void setSelector(String[] selector) {
        this.selector = selector;
    }

    public Pattern getChecker() {
        return checker;
    }

    public void setChecker(Pattern checker) {
        this.checker = checker;
    }

    public Selector getJavaSelector() {
        return javaSelector;
    }

    public void setJavaSelector(Selector javaSelector) {
        this.javaSelector = javaSelector;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public MultpleConfig getRows() {
        return rows;
    }

    public void setRows(MultpleConfig rows) {
        this.rows = rows;
    }

}
