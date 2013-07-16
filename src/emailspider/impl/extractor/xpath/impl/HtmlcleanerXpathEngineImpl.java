package emailspider.impl.extractor.xpath.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.cyberneko.html.parsers.DOMParser;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import emailspider.impl.extractor.xpath.XpathEngine;

public class HtmlcleanerXpathEngineImpl implements XpathEngine {


    public String parse(String text, String path) {
      //  path = StringUtils.upperCase(path);
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(text);
        try {
            Object[] nodes=node.evaluateXPath(path);
            System.out.println(nodes[0]);
        } catch (XPatherException e) {
           e.printStackTrace();
        }
      return null;
    }



    @Override
    public Document clean(String text) {
        return null;
    }

    @Override
    public Node parseNode(String text, String path) {
        return null;
    }

    @Override
    public String parseString(Node node, String path) {
        return null;
    }

    @Override
    public List<Node> parseList(Node node, String path) {
        return null;
    }
}
