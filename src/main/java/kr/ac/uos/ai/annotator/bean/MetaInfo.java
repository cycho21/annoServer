/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 * @see http://github.com/lovebube
 */

package kr.ac.uos.ai.annotator.bean;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;
import kr.ac.uos.ai.annotator.bean.type.MsgType;
import kr.ac.uos.ai.annotator.bean.type.PropertyType;

import java.util.HashMap;

/**
 * Created by HentaiMaster on 2015-09-21.
 */

public class MetaInfo {

    private HashMap<String, String> propertyMap;

    public MetaInfo(String author, MsgType msg, String msgTime) {

        propertyMap = new HashMap<String, String>();

        propertyMap.put(PropertyType.AUTHOR.toString(), author);
        propertyMap.put(PropertyType.MSGTYPE.toString(), msg.toString().toLowerCase());
        propertyMap.put(PropertyType.MSGTIME.toString(), msgTime);
    }

    public HashMap<String, String> getPropertyMap() {
        return propertyMap;
    }

}