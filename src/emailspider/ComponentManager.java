package emailspider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import emailspider.core.ComponentBuilder;
import emailspider.core.ComponentGroup;
import emailspider.core.ReloadCallback;
import emailspider.core.Scanner;

public class ComponentManager {
    private Map<Class<?>, ComponentGroup<?>> componentsHolder = new ConcurrentHashMap<Class<?>, ComponentGroup<?>>();
    private Scanner scanner;
    private ComponentBuilder componentBuilder;

    
    public void init(){
        if(scanner!=null){
            scanner.start(new ReloadCallback(){

                @SuppressWarnings({ "unchecked", "rawtypes" })
                @Override
                public void onReload(String type, List<String> contents) {
                    Class<?> clazz=null;;
                    try {
                      clazz=Class.forName(type);
                    } catch (ClassNotFoundException e) {
                       // TODO Å×Òì³£
                    }
                    ComponentGroup<?> holder=componentsHolder.get(clazz);
                    if(holder==null){
                        return;
                    }
                    List newComponents=new ArrayList();
                    for(String content:contents){
                       Object newComponent= componentBuilder.build(clazz, content);
                       newComponents.add(newComponent);
                    }
                    holder.onReload(newComponents);
                }
                
            });
        }
    }
    
    public static <T extends ComponentGroup<?>> T getGroup(Class<?> spiClazz) {
        return null;
    }
    
    
    
}
