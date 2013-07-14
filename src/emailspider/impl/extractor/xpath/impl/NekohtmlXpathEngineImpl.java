package emailspider.impl.extractor.xpath.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import emailspider.impl.extractor.xpath.XpathEngine;

public class NekohtmlXpathEngineImpl implements XpathEngine {

    @Override
    public String parse(String text, String path) {

        DOMParser parser = new DOMParser();
        //        try {
        //            parser.setProperty("http://cyberneko.org/html/properties/default-encoding","gb2312");
        //        } catch (SAXNotRecognizedException e2) {
        //            e2.printStackTrace();
        //        } catch (SAXNotSupportedException e2) {
        //            e2.printStackTrace();
        //        }  
        //
        //        try {
        //            parser.setFeature("http://xml.org/sax/features/namespaces", false);
        //        } catch (SAXNotRecognizedException e2) {
        //            e2.printStackTrace();
        //        } catch (SAXNotSupportedException e2) {
        //            e2.printStackTrace();
        //        }  
        //…Ë÷√Õ¯“≥µƒƒ¨»œ±‡¬Î
        try {

            parser.parse(new InputSource(new StringReader(text)));
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Document doc = parser.getDocument();
        //System.out.println(text);
        XPathFactory factory = XPathFactory.newInstance();

        XPath xpath = factory.newXPath();
        
        try {
      
            System.out.println(xpath.evaluate(path, doc));

            return null;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<String> multiParse(String text, String path) {
        return null;
    }
}
