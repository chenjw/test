package emailspider.holder;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import emailspider.core.ComponentGroup;
import emailspider.spi.Connector;
import emailspider.spi.Parser;

public class ConnectorGroup implements ComponentGroup<Connector> {
    public Map<String, List<Connector>> scriptMap = new ConcurrentHashMap<String, List<Connector>>();

    public Connector getByEmail(String email) {
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
    public void onReload(List<Connector> components) {
    }
}
