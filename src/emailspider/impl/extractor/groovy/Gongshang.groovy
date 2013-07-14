package emailspider.impl.extractor.groovy

import java.text.SimpleDateFormat

import org.apache.commons.lang.StringUtils

import emailspider.impl.extractor.EmailExtractorXpathTemplate
import emailspider.impl.extractor.spi.Checker
import emailspider.impl.extractor.spi.Transformer

class Gongshang extends EmailExtractorXpathTemplate {

    def Map config() {
        return [
            "bankCode":"zhaoshang",
            "validStart":new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-20"),
            "validEnd":new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-30"),
            "index":1
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
                    "row-checker": "(\\d{4}-\\d{1,2}-\\d{1,2})",
                    "items": [
                        "sub_key1" : [
                            "selector": [
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]",
                                "BODY[2]>DIV[0][bg-wrap]>DIV[1][app-nameInfo-wrap cf]>DIV[0][app-name fl]>DIV[0][cf]>H1[0][ch-name cutoff fl]"
                            ],
                            "java-transformer" : "name",
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

    def Transformer[] transformers() {
        return ["name": new Transformer(){
                public String transform(String input){
                    if(input?.endsWith("先生")){
                        return StringUtils.substringBefore(input, "先生");
                    }
                    else  if(input?.endsWith("先生")){
                        return StringUtils.substringBefore(input, "小姐");
                    }
                }
            }];
    }

    def Checker[] checkers() {
        return ["name": new Checker(){
                public boolean check(String input){
                    return true;
                }
            }];
    }
}
