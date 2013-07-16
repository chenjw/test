package emailspider.impl.extractor.xpath.model;


public class BaseResult implements XpathResult {
    private boolean extracted;

    public boolean isExtracted() {
        return extracted;
    }
    public void setExtracted(boolean extracted) {
        this.extracted = extracted;
    }
    

}
