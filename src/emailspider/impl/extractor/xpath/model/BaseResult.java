package emailspider.impl.extractor.xpath.model;

import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;

public abstract class BaseResult implements XpathResult {
    protected KeyConfig config;
    private boolean     loaded=false;
    protected Frame       frame;
    protected XpathEngine xpathEngine;

    protected abstract void doLoad();

    public final void load() {
        if (!loaded) {
            doLoad();
            loaded = true;
        }
    }

    public BaseResult(KeyConfig config, Frame frame, XpathEngine xpathEngine) {
        this.config = config;
        this.frame = frame;
        this.xpathEngine = xpathEngine;
    }

    public boolean isLoaded() {
        return loaded;
    }

}
