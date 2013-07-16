package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.config.KeyConfig;

public abstract class BaseResult implements XpathResult {
    private KeyConfig config;
    private boolean   loaded;

    public BaseResult(KeyConfig config) {
        this.config = config;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public KeyConfig getConfig() {
        return config;
    }

    public void setConfig(KeyConfig config) {
        this.config = config;
    }

}
