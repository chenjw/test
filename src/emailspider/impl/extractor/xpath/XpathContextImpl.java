package emailspider.impl.extractor.xpath;

import java.util.Stack;

import org.springframework.util.Assert;

import emailspider.impl.extractor.xpath.model.Frame;
import emailspider.impl.extractor.xpath.model.GroupResult;
import emailspider.impl.extractor.xpath.model.XpathResult;

/**
 * xpath上下文
 * 
 * @author chenjw
 * @version $Id: XpathContextImpl.java, v 0.1 2013年7月16日 下午1:51:16 chenjw Exp $
 */
public class XpathContextImpl implements XpathContext {

    // 已经解析的字段值
    private Stack<Frame> parseStack = new Stack<Frame>();

    
    public void addFrame(Frame frame) {
        parseStack.add(frame);
    }
    
    public void removeFrame(Frame frame) {
       Frame f= parseStack.pop();
       Assert.isTrue(f==frame);
    }

    
    /**
     * 实现
     * 
     * @param r
     */
    public void load(XpathResult r){
        
    }
    
    private String getFromXpathResult(XpathResult r) {
        if(!r.isLoaded()){
            load(r);
        }
        return null;
    }

    public GroupResult getGroup(String key) {
        Frame f = parseStack.peek();
        XpathResult r = f.get(key);
        if(r==null){
            throw new IllegalStateException(key + "not found");
        }
        else  if (!(r instanceof GroupResult)) {
            throw new IllegalStateException(key + "not a group");
        }
        return (GroupResult) r;
    }

    public String get(String key) {
        int i = parseStack.size();
        while (i > 0) {
            Frame f = parseStack.elementAt(i - 1);
            XpathResult r = f.get(key);
            if (r != null) {
                return getFromXpathResult(r);
            } else {
                i--;
            }
        }
        return null;
    }
}
