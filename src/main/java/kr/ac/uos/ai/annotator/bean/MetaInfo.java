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

    private HashMap<PropertyType, String> propertyMap;

    public MetaInfo(String author, MsgType msg, String msgTime) {
        this.propertyMap.put(PropertyType.AUTHOR, author);
        this.propertyMap.put(PropertyType.MSGTYPE, msg.toString().toLowerCase());
        this.propertyMap.put(PropertyType.MSGTIME, msgTime);
    }

    public HashMap<PropertyType, String> getPropertyMap() {
        return propertyMap;
    }

}