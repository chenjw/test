package emailspider.holder;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import emailspider.core.ComponentGroup;
import emailspider.spi.Parser;

public class ParseGroup implements ComponentGroup<Parser> {
    public Map<String, List<Parser>> scriptMap = new ConcurrentHashMap<String, List<Parser>>();

    public List<Parser> findByBankAndDate(String bankCode, Date time) {
//        if (time == null) {
//            throw new IllegalArgumentException("time cant be null");
//        }
//        List<String> result = new ArrayList<String>();
//
//        List<ParserItem> scriptList = scriptMap.get(bankCode);
//        // TODO ����һ��
//        for (ParserItem item : scriptList) {
//            if (item.startDate != null && item.startDate.compareTo(time) < 0) {
//                continue;
//            }
//            if (item.endDate != null && item.endDate.compareTo(time) >= 0) {
//                continue;
//            }
//            result.add(item.script);
//        }
   return null;
    }

    private class ParserItem {
        private String script;
        //  ���startDateΪnull����ʾ��Ч��������
        private Date   startDate;
        //  ���startDateΪnull����ʾ��Ч��������
        private Date   endDate;
    }

    @Override
    public void onReload(List<Parser> components) {
    }
}
