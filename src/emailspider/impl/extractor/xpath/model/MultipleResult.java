package emailspider.impl.extractor.xpath.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

import emailspider.impl.extractor.xpath.XpathContext;
import emailspider.impl.extractor.xpath.config.KeyConfig;
import emailspider.impl.extractor.xpath.config.MultpleConfig;


public class MultipleResult extends  BaseResult {
    private List<Node> nodeList;
    private List<Map<String, XpathResult>> results=new ArrayList<Map<String, XpathResult>>();
    
    public MultipleResult(KeyConfig config) {
        super(config);
    }
    
   

    @Override
    public void load(XpathContext context) {
        
        // TODO 取得nodeList的值
        
        
        MultpleConfig multpleConfig=this.getConfig().getRows();
        Map<String,KeyConfig> subKeyConfigs=multpleConfig.getItems();
        for(Node node:nodeList){
            Frame newFrame=new Frame(node,subKeyConfigs);
            context.addFrame(newFrame);
            newFrame.load(context);
            results.add(newFrame.getResults());
        }
        // 最后check下
    }
    
}
