package ejer4_JAXB;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorFecha extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String date) throws Exception {
		return LocalDate.parse(date);
	}

	@Override
	public String marshal(LocalDate date) throws Exception {
		return date.toString();
	}

}
