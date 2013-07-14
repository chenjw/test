package emailspider.scanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;

import emailspider.core.ReloadCallback;
import emailspider.core.Scanner;

public class FolderScanner implements Scanner {
    /** 5秒钟扫一次  */
    private static final long SCAN_INTERVAL = 5 * 1000;
    private String            folderPath;
    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public void start(ReloadCallback callback) {
        new Thread(new ScanWorker(callback),"email-spider-folder-scanner").start();
    }

    private class ScanWorker implements Runnable {
        private ReloadCallback callback;
        /**  文件夹最后修改时间的备份 */
        private Map<String, Long> lastModifyTimeBackupMap=new ConcurrentHashMap<String,Long>();
        private ScanWorker(ReloadCallback callback){
            this.callback=callback;
        }
        
        @Override
        public void run() {
            File folder=new File(folderPath);
            while (true) {
                for(File f: folder.listFiles()){
                    if(f.isFile()){
                        continue;
                    }
                    String fileName=  f.getName();
                    Long lastModifyTimeBackup=lastModifyTimeBackupMap.get(fileName);
                    // 如果文件最后修改日期变化了
                    if(lastModifyTimeBackup!=null &&   f.lastModified()<= lastModifyTimeBackup){
                        continue;
                    }
                    List<String> list=new ArrayList<String>();
                    Iterator<File> fileIterator=FileUtils.iterateFiles(f, new String[]{"groovy"}, true);
                   while(fileIterator.hasNext()){
                       File ff=fileIterator.next();
                       try {
                        list.add(FileUtils.readFileToString(ff,"UTF-8"));
                    } catch (IOException e) {
                        // TODO 抛异常
                    }
                   }
                   try{
                       // 通知回调
                       callback.onReload(fileName, list);
                   }
                   catch(Exception e){
                       // TODO 抛异常
                   }
                    lastModifyTimeBackupMap.put(fileName, f.lastModified());
                }
               
                try {
                    Thread.sleep(SCAN_INTERVAL);
                } catch (InterruptedException e) {
                }
            }
        }

    }

}
