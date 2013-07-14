package emailspider.holder;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import emailspider.core.ComponentGroup;
import emailspider.spi.Filter;
import emailspider.spi.Parser;

public class FilterGroup implements ComponentGroup<Filter> {
    public Map<String, List<Parser>> scriptMap = new ConcurrentHashMap<String, List<Parser>>();

    public List<Filter> getFilters() {

   return null;
    }

    private class ParserItem {
        private String script;
        //  如果startDate为null，表示有效期无上限
        private Date   startDate;
        //  如果startDate为null，表示有效期无下限
        private Date   endDate;
    }

    @Override
    public void onReload(List<Filter> components) {
    }
}
