package ejer5_JAXBS;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        return sdf.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return sdf.format(v);
    }
}
