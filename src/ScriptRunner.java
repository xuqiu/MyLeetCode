//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//
//import org.hibernate.validator.internal.util.scriptengine.ScriptEvaluator;
//import org.hibernate.validator.internal.util.scriptengine.ScriptEvaluatorFactory;
import org.junit.Test;

//import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-15 14:32
 */
//@Slf4j
public class ScriptRunner {
//    private final ScriptEvaluatorFactory factory = ScriptEvaluatorFactory.getInstance();
//
//
//    public void doHandler(String message, String script) {
//        try {
//            final ScriptEvaluator javascript = factory.getScriptEvaluatorByLanguageName("ECMAScript");
//            Map<String, Object> map = new HashMap<>();
//            final JSONObject jsonObject = JSON.parseObject(message);
//            map.put("message", jsonObject);
//            javascript.evaluate(script, map);
//        } catch (ScriptException e) {
//            log.error("执行脚本异常，script:{},message:{}", script, message, e);
//        }
//    }
//    @Test
//    public void runScript(){
//        String message = "{\"content\":\"\\n就诊情况：去医院就诊过\\n确诊疾病：感冒\\n病情描述：111111111111\",\"extBizDesc\":\"{\\\"medicineInfo\\\":\\\"\\\",\\\"patientGuarderName\\\":\\\"\\\",\\\"images\\\":\\\"http://kano.guahao-test.com/KFr43194306?token=V1.0_L2l3WVAyWFlVaU5kTFhkY1JuTlRxUT09X1RJTUVfQUVTCOUSTOM\\\",\\\"highlightedContent\\\":\\\"\\\\n就诊情况：去医院就诊过\\\\n确诊疾病：感冒\\\\n病情描述：111111111111\\\",\\\"firstConsultCard\\\":\\\"\\\",\\\"shownDesc\\\":false,\\\"lastVisitDate\\\":\\\"\\\",\\\"title\\\":\\\"\\\",\\\"kindOfHelp\\\":[],\\\"content\\\":\\\"\\\\n就诊情况：去医院就诊过\\\\n确诊疾病：感冒\\\\n病情描述：111111111111\\\",\\\"diseaseName\\\":\\\"感冒\\\",\\\"patientWeight\\\":\\\"\\\",\\\"chronicDiseaseAssessment\\\":[],\\\"hospitalDept\\\":\\\"\\\",\\\"hasPatientCard\\\":false,\\\"goHospital\\\":true,\\\"p_generalCardUI\\\":{\\\"images\\\":[\\\"http://kano.guahao-test.com/KFr43194306?token=V1.0_L2l3WVAyWFlVaU5kTFhkY1JuTlRxUT09X1RJTUVfQUVTCOUSTOM\\\"],\\\"actionText\\\":\\\"查看订单详情\\\",\\\"detaillist\\\":[{\\\"name\\\":\\\"就诊人:\\\",\\\"value\\\":\\\"程凯  男  28岁\\\"},{\\\"name\\\":\\\"就诊情况:\\\",\\\"value\\\":\\\"去医院就诊过\\\"},{\\\"name\\\":\\\"确诊疾病:\\\",\\\"value\\\":\\\"感冒\\\"},{\\\"name\\\":\\\"病情描述:\\\",\\\"value\\\":\\\"111111111111\\\"}],\\\"title\\\":\\\"您向医生发起了快速问诊\\\"},\\\"patientAge\\\":\\\"28岁\\\",\\\"p_generalUIType\\\":5,\\\"sickTime\\\":\\\"\\\",\\\"desc\\\":\\\"查看患者资料\\\"}\",\"extBizType\":66,\"highlightedContent\":\"\\n就诊情况：去医院就诊过\\n确诊疾病：感冒\\n病情描述：111111111111\",\"msgId\":\"812583408955539458\",\"msgType\":3,\"orderInfoId\":\"4snqkhuzv1220412133942839\",\"patientId\":\"123123401485\",\"replyTime\":\"2022-04-12 13:39:43\",\"replyTimestamp\":1649741983000,\"senderId\":\"60168112322515605\",\"sessionId\":\"62551d0bc5c61200018881ae\",\"subType\":1,\"userType\":\"0\"}";
//        String script = "/**\n" + " * 患者主诉卡片\n" + " */\n" + "function change(message){\n"
//            + "    let extBizDesc = message.extBizDesc;\n" + "    if(!extBizDesc){\n" + "        return message;\n"
//            + "    }\n" + "    let card = {};\n" + "    try {\n" + "        card = JSON.parse(extBizDesc);\n"
//            + "    }finally{}\n" + "    let newCard\n" + "    if(card.p_generalCardUI){\n"
//            + "        newCard = changeCard_p(card);\n" + "    }else if(card.cardOption){\n"
//            + "        newCard = changeCard_new(card);\n" + "    }else{\n" + "        newCard = changeCard(card);\n"
//            + "    }\n" + "    console.info(JSON.stringify(newCard,undefined,2));\n"
//            + "    message.extBizDesc = JSON.stringify(newCard)\n" + "    return message;\n" + "}\n"
//            + "change(message);\n" + "function changeCard_p(oldCard){\n" + "    let card = {\n"
//            + "        cardType: 5,//5消息卡片\n" + "        cardOption:{\n" + "            detailList:[]\n" + "        }\n"
//            + "    };\n" + "    oldCard.p_generalCardUI.detaillist.forEach(detail=>{\n"
//            + "        if (detail.name === \"就诊人:\") {\n" + "            card.cardOption.title = detail.value\n"
//            + "        }else{\n" + "            card.cardOption.detailList.push(detail)\n" + "        }\n" + "    })\n"
//            + "    card.cardOption.images = oldCard.p_generalCardUI.images\n" + "    //todo\n"
//            + "    card.cardOption.icon = null;\n" + "    card.cardOption.action = {\n" + "        text: '查看患者资料',\n"
//            + "        path: '/todo'\n" + "    }\n" + "    return card;\n" + "}\n" + "function changeCard(oldCard){\n"
//            + "    let card = {\n" + "        cardType: 5,//5消息卡片\n" + "        cardOption:{\n"
//            + "            detailList:[]\n" + "        }\n" + "    };\n"
//            + "    card.cardOption.title = oldCard.generalCardUI.title;\n" + "    // detail\n"
//            + "    oldCard.contentList.forEach(content=>{\n"
//            + "        card.cardOption.detailList.push({\"name\":content.title,\"value\":content.detail})\n"
//            + "    })\n" + "    card.cardOption.images = oldCard.generalCardUI.images\n" + "    //todo\n"
//            + "    card.cardOption.icon = null;\n" + "    card.cardOption.action = {\n" + "        text: '查看患者资料',\n"
//            + "        //todo\n" + "        path: '/todo'\n" + "    }\n" + "    return card;\n" + "}\n"
//            + "function changeCard_new(oldCard){\n" + "    oldCard.cardOption.action = {\n"
//            + "        text: '查看患者资料',\n" + "        //todo\n" + "        path: '/todo'\n" + "    }\n"
//            + "    return oldCard;\n" + "}\n";
//
//        doHandler(message,script);
//
//    }
    @Test
    public void showEngineVersions(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = (new ScriptEngineManager()).getEngineByName("javascript");
        // Get the list of all available engines
        List<ScriptEngineFactory> list = manager.getEngineFactories();

        // Print the details of each engine
        for (ScriptEngineFactory f : list) {
            System.out.println("Engine Name:" + f.getEngineName());
            System.out.println("Engine Version:" + f.getEngineVersion());
            System.out.println("Language Name:" + f.getLanguageName());
            System.out.println("Language Version:" + f.getLanguageVersion());
            System.out.println("Engine Short Names:" + f.getNames());
            System.out.println("Mime Types:" + f.getMimeTypes());
            System.out.println("===");
        }

    }
}
