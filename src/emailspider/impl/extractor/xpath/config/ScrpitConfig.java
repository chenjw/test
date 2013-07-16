package emailspider.impl.extractor.xpath.config;

import java.util.Date;
import java.util.regex.Pattern;

import emailspider.impl.extractor.spi.Checker;

public class ScrpitConfig {
    private String bankCode;
    private Date validStart;
    private Date validEnd;
    private int index=0;
    private Pattern checker;
    private Checker javaChecker;
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public Date getValidStart() {
        return validStart;
    }
    public void setValidStart(Date validStart) {
        this.validStart = validStart;
    }
    public Date getValidEnd() {
        return validEnd;
    }
    public void setValidEnd(Date validEnd) {
        this.validEnd = validEnd;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public Pattern getChecker() {
        return checker;
    }
    public void setChecker(Pattern checker) {
        this.checker = checker;
    }
    public Checker getJavaChecker() {
        return javaChecker;
    }
    public void setJavaChecker(Checker javaChecker) {
        this.javaChecker = javaChecker;
    }
    
}
