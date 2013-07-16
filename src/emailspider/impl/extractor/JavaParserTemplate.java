package emailspider.impl.extractor;

import java.util.Date;

import emailspider.model.Bill;
import emailspider.spi.Parser;

public  class JavaParserTemplate implements Parser {

    public void init() {

        
    }


    public void destroy() {
    }
    
    @Override
    public Date getValidStart() {
        return null;
    }

    @Override
    public Date getValidEnd() {
        return null;
    }

    @Override
    public String getBankCode() {
        return null;
    }

    @Override
    public Bill parse(String text) {
        return null;
    }

}
