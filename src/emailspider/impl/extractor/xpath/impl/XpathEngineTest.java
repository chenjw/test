package emailspider.impl.extractor.xpath.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import emailspider.impl.extractor.xpath.XpathEngine;

public class XpathEngineTest {
    public static void main(String[] args) throws IOException{
        XpathEngine engine=new NekohtmlXpathEngineImpl();
        engine.parse(FileUtils.readFileToString(new File("C:\\test\\zhaohang.htm")), "//*[@id='fixBand15']/table/tbody/tr/td/table/tbody/tr");

    }
}
