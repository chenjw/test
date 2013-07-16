package emailspider.impl.extractor;

import java.util.Date;
import java.util.Map;

import org.w3c.dom.Document;

import emailspider.core.Lifecycle;
import emailspider.impl.extractor.spi.Checker;
import emailspider.impl.extractor.spi.Tool;
import emailspider.impl.extractor.xpath.XpathContextImpl;
import emailspider.impl.extractor.xpath.XpathEngine;
import emailspider.impl.extractor.xpath.config.KeyConfig;
import emailspider.impl.extractor.xpath.config.ScrpitConfig;
import emailspider.impl.extractor.xpath.model.Frame;
import emailspider.impl.extractor.xpath.model.XpathResult;
import emailspider.model.Bill;
import emailspider.spi.Parser;

public abstract class XpathParserTemplate implements Parser, Lifecycle {
    private XpathEngine            xpathEngine;
    private ScrpitConfig           config;
    private Map<String, KeyConfig> rule;

    public void init() {
        config();
        rule();
        // 初始化config和rule
    }

    public Bill parse(String text) {
        // 从text拿到document
        Document root = xpathEngine.clean(text);
        //
        XpathContextImpl context = new XpathContextImpl();
        //
        Frame f = new Frame(root, rule, xpathEngine);
        //
        context.addFrame(f);
        f.load();
        Map<String, XpathResult> results = f.getResults();
        // 最后转换results到bill
        return null;
    }

    public void destroy() {

    }

    protected abstract Map config();

    protected abstract Map rule();

    @Override
    public String getBankCode() {
        return null;
    }

    protected Tool[] tools() {
        return null;
    }

    protected Checker[] checkers() {
        return null;
    }

    @Override
    public Date getValidStart() {
        return null;
    }

    @Override
    public Date getValidEnd() {
        return null;
    }

}
