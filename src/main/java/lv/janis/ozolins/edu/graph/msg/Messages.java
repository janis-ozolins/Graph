package lv.janis.ozolins.edu.graph.msg;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by janis.ozolins on 14.14.10.
 */
public class Messages {

    public static String msg(String key){
        try{
            ResourceBundle bundle = ResourceBundle.getBundle("msg", Locale.forLanguageTag("lv")); //TODO get OS locale
            return bundle.getString(key);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return key;
    }
}
