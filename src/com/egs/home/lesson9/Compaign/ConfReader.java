package com.egs.home.lesson9.Compaign;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class ConfReader extends DefaultHandler {

    public static boolean info = false;
    public static boolean warning = false;
    public static boolean error = false;
    String cont = "";
    //boolean bMarks = false;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equals("setInfo")) {
            info=Boolean.parseBoolean(cont);
        }
        if (qName.equals("setWarning")) {
            warning=Boolean.parseBoolean(cont);
        }
        if (qName.equals("setError")) {
            error=Boolean.parseBoolean(cont);
        }
    }

    @Override
    public void characters(char ch[],
                           int start, int length) throws SAXException {
        cont=String.copyValueOf(ch,start,length);

    }

}
