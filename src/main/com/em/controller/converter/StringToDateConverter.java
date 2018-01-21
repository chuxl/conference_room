package main.com.em.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter<S,T>:
 * S:source
 * T:target
 * Created by Admiral on 2018/1/18.
 */
public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        Date date=null;
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=dateFormat.parse(source.trim());
            //return date;
        } catch (ParseException e) {
            try{
                dateFormat=new SimpleDateFormat("hh:mm:ss");
                date=dateFormat.parse(source.trim());
            }catch (ParseException e1){
                e1.printStackTrace();
            }
        }
        return date;
    }
}
