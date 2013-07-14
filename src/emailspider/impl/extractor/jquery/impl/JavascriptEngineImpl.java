package emailspider.impl.extractor.jquery.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;

import emailspider.impl.extractor.jquery.JavascriptEngine;

public class JavascriptEngineImpl implements JavascriptEngine {

    private Context    cx;

    private Scriptable scope;

    public void init() throws IOException {

        cx = ContextFactory.getGlobal().enterContext();

        scope = cx.initStandardObjects(null);

        cx.setOptimizationLevel(-1);

        cx.setLanguageVersion(Context.VERSION_1_8);

        String[] file = {"C:\\test\\env.js", "C:\\test\\jquery-2.0.3.min.js" };

        for (String f : file) {
            evaluateJsFile(f);
        }
 
    }

    protected void evaluateJsFile(String filePath) throws IOException {

        FileReader in = null;

        in = new FileReader(filePath);
        cx.evaluateReader(scope, in, filePath, 1, null);

    }

    @Override
    public Map<String, String> execute(String html, String js) {
        scope.put("data", scope, html);
        cx.evaluateString(scope, js, "test.js", 1, null);
        System.out.println(scope.get("result", scope));
        return null;
    }

    public static void main(String[] args) throws IOException {
        JavascriptEngineImpl engine = new JavascriptEngineImpl();
        engine.init();
        engine.execute(FileUtils.readFileToString(new File("C:\\test\\jh.htm")),
            FileUtils.readFileToString(new File("C:\\test\\test.js")));
    }
}
