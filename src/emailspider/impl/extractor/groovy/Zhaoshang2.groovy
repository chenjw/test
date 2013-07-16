package emailspider.impl.extractor.groovy

import java.text.SimpleDateFormat

import org.apache.commons.lang.StringUtils

import emailspider.impl.extractor.XpathParserTemplate
import emailspider.impl.extractor.spi.Checker
import emailspider.impl.extractor.spi.Selector
import emailspider.impl.extractor.spi.Tool
import emailspider.impl.extractor.spi.Transformer
import emailspider.impl.extractor.xpath.model.Frame

class Zhaoshang2 extends XpathParserTemplate {

    def Map config() {
        return [
            "bankCode":"zhaoshang",
            "validStart":new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-20"),
            "validEnd":new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-30"),
            "index":1,
            "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
            "java-checker":"name-checker"
        ]
    }

    def Map rule() {
        return [
            "key1" : [
                "required":true,
                "selector": [
                    "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                ],
                "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
            ],
            "key2" : [
                "required":true,
                "java-selector": [
                    "test-selector"
                ],
                "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
            ],
            "group1" : [
                "required":true,
                "selector": [
                    "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]",
                    "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                ]
            ],
            "key2" : [
                "required":true,
                "parent":"group1",
                "selector": [
                    "DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]",
                    "DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                ]
            ],
            "list1" : [
                "required":true,
                "multiple":true,
                "parent":"group1",
                "selector": [
                    "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[1-3][ch-name cutoff fl]"
                ],
                "rows":[
                    "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
                    "java-checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
                    "items": [
                        "sub_key1" : [
                            "selector": [
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]",
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                            ],
                            "java-transformer" : "name-transformer",
                            "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
                        ],
                        "sub_key2" : [
                            "selector": [
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]",
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                            ],
                            "checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
                        ],
                    ],
                ]
            ]
        ]
    }

    def Tool[] tools() {
        return ["name-transformer": new Transformer(){
                public String transform(String input,Frame context){
                    if(input?.endsWith("先生")){
                        return StringUtils.substringBefore(input, "先生");
                    }
                    else  if(input?.endsWith("先生")){
                        return StringUtils.substringBefore(input, "小姐");
                    }
                }
            },"name-checker": new Checker(){
                public boolean check(String input,Frame context){
                    return true;
                }
            },"test-selector":new Selector(){
                public String select(String text){
                    return "a";
                }
            }
        ];
    }
}
