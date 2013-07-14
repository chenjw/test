package emailspider.core;

import java.util.List;

public interface ReloadCallback {
    public void onReload(String type,List<String> contents);
}
