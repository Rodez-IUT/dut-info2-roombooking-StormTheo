package xmlws.roombooking.xmltools;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Date;

public class RoomBookingSaxParser implements RoomBookingParser {

    RoomBooking roomBooking = new RoomBooking();
    private String roomLabel;
    private String username;
    private Date startDate;
    private Date endDate;


    @Override
    public RoomBooking parse(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingBasicHandler());

        } catch (Exception e) {

        }
        return null;
    }


    private class RoomBookingBasicHandler extends DefaultHandler {

        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts)
                                 throws SAXException {

            switch (localName) {
                case "label":
                    roomBooking.setRoomLabel();
                    break;
                case "username":
                    roomBooking.setUsername();
                    break;
                case "startDate":
                    roomBooking.setStartDate();
                    break;
                case "endDate":
                    roomBooking.setEndDate();
                    break;
            }

            System.out.println("In element: " + localName);
        }


        public void characters(char ch[], int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
        }


    }

}