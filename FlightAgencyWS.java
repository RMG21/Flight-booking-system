/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightAgencyWS;

import flightOrder.AllFlights;
import flightOrder.FlightType;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rachellee
 */
@WebService(serviceName = "FlightAgencyWS")
@Stateless()
public class FlightAgencyWS 
{
    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchFlights")
    public List<FlightType> SearchFlights(@WebParam(name = "From") String From, @WebParam(name = "To") String To) 
    {
        //TODO write your implementation code here:

        List<FlightType> FlightCollection = RetreiveFlights(); // all the flights from file
        List<FlightType> WantedFlights = new ArrayList(); // Flights user searched

        for (int i = 0; i < FlightCollection.size(); i++) 
        {
            if (FlightCollection.get(i).getFrom().equalsIgnoreCase(From)) 
            {
                if (FlightCollection.get(i).getTo().equalsIgnoreCase(To)) 
                {
                    WantedFlights.add(FlightCollection.get(i));
                }
            }
        }
        return WantedFlights;
    }

    public List<FlightType> RetreiveFlights() 
    {

        AllFlights FlightList = new AllFlights();

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(FlightList.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            FlightList = (AllFlights) unmarshaller.unmarshal(new java.io.File("/Users/richardmagnus-george/Desktop/FlightTravelAgency/Flights_Showing.xml")); //NOI18N You cast the instance to its type
            return FlightList.getFlightsCollection();
        } catch (javax.xml.bind.JAXBException ex) 
        {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return null;
    }

    @WebMethod(operationName = "Booking")
    public List<FlightType> Booking(@WebParam(name = "flightID") String flightID, @WebParam(name = "NumSeats") int NumSeats) 
    {
        int newSeats = NumSeats;

        AllFlights allFlights = new AllFlights();

        List<FlightType> FlightCollection = RetreiveFlights(); // all the flights from file
        List<FlightType> WantedFlights = new ArrayList(); // Flights user searched

        for (int i = 0; i < FlightCollection.size(); i++) 
        {
            if (FlightCollection.get(i).getID().equalsIgnoreCase(flightID)) 
            {
                if (newSeats > FlightCollection.get(i).getSeats()) 
                {
                    System.out.print("Insuficient seats available for this flight"); //Make sure output in GUI
                } else 
                {
                    FlightCollection.get(i).setSeats(FlightCollection.get(i).getSeats() - newSeats); //deducts seats booked
                    WantedFlights.add(FlightCollection.get(i));
                }
            }
            allFlights.getFlightsCollection().add(FlightCollection.get(i)); //add bk to main fight list to update file

            try {
                javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allFlights.getClass().getPackage().getName());
                javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(allFlights, System.out);

                //Writing the whole XML document to file
                File flightstored = new File("/Users/richardmagnus-george/Desktop/FlightTravelAgency/Flights_Showing.xml");
                marshaller.marshal(allFlights, flightstored);

            } catch (javax.xml.bind.JAXBException ex) 
            {
                // XXXTODO Handle exception
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
            }
        }
        return WantedFlights;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchAllFlights")
    public List<FlightType> SearchAllFlights() 
    {
        //TODO write your implementation code here:

        List<FlightType> FlightCollection = RetreiveFlights(); // all the flights in file
        List<FlightType> WantedFlights = new ArrayList(); // will return all Flights as theres no conditions

        for (int i = 0; i < FlightCollection.size(); i++) 
        {
            WantedFlights.add(FlightCollection.get(i));
        }
        return WantedFlights;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Directions")
    @SuppressWarnings("empty-statement")
    public List<String> Directions(String origin, String destination) 
    {
        String tempOrigin, tempDestination; //http dosent react well to spaces
        tempOrigin = origin.replace(" ", "+");
        tempDestination = destination.replace(" ", "+");

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/directions/xml?origin=" + tempOrigin + "&destination=" + tempDestination + "&key=AIzaSyC97SsRqtgyTliZbD2zZRMV6HB15wvRAfc");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();; //establish connection & Check for successful response code or throw error
            if (conn.getResponseCode() != 200) 
            {
                throw new IOException(conn.getResponseMessage());
            }
            BufferedReader ins = new BufferedReader(new InputStreamReader(conn.getInputStream()));//reads directions
            String inString;
            StringBuilder sb = new StringBuilder();
            while ((inString = ins.readLine()) != null)// reads to end of line
            {
                sb.append(inString + "\n");// adds to string builer of new line
            }
            ins.close(); // closses dirrections url connecton
            return parseXML(sb.toString());// extracts exything needed from the string builder

        } catch (MalformedURLException me) 
        {
            System.out.println("MalformedURLException: " + me);;
        } catch (IOException ioe) 
        {
            System.out.println("IOException: " + ioe);;
        }
        return null;
    }

    private List<String> parseXML(String xml) 
    {
        List<String> directions = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler;
            handler = new DefaultHandler() //helps handle inputs opening stream & outputs closing stream
            {
                boolean instructions = false;
                boolean distance = false;

                //<html_instructions>
                //<text> Gets the starting tag

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
                {
                    super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
                    if (qName.equalsIgnoreCase("html_instructions"))//checks if tag names exist
                    {
                        instructions = true;
                    }
                    if (qName.equalsIgnoreCase("text"))//checks if tag names exist
                    {
                        distance = true;
                    }
                }

                //<_____> Gets everything in between the tags

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException 
                {
                    super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
                    if (instructions == true) 
                    {
                        sb.append(ch, start, length);//adds all intstuctions inbetween tags to SB if instructions=true
                    }

                    if (distance == true) 
                    {
                        sb.append(ch, start, length);//adds all distances/text inbetween tags to SB if instructions=true
                    }
                }

                //</html_instructions> Gets the ending tag

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException 
                {
                    super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
                    if (qName.equalsIgnoreCase("html_instructions")) 
                    {
                        directions.add(sb.toString().replaceAll("<.*?>", ""));//add to list& replaces unwanted with ""
                        sb.delete(0, sb.length()); // reset the string builder
                        instructions = false; // closses tab so can go onto next starting tab in loop
                    }

                    if (qName.equalsIgnoreCase("text")) 
                    {
                        directions.add(sb.toString().replaceAll("<.*?>", ""));
                        sb.delete(0, sb.length());
                        distance = false;
                    }
                }
            };
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) 
        {

        }
        return directions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Maps")
    public byte[] Maps(String origin, String destination) throws MalformedURLException, IOException 
    {
        String tempOrigin, tempDestination; // to replace blank spaces as http dosent react well to them
        tempOrigin = origin.replace(" ", "+");
        tempDestination = destination.replace(" ", "+");

        URL url = new URL("https://maps.googleapis.com/maps/api/staticmap?size=600x300&maptype=roadmap&markers=" + tempOrigin
                + "|" + tempDestination + "&key=AIzaSyC97SsRqtgyTliZbD2zZRMV6HB15wvRAfc");
        InputStream in = new BufferedInputStream(url.openStream());//opening stream of image of map
        ByteArrayOutputStream out = new ByteArrayOutputStream(); //stream output to byte array
        byte[] buf = new byte[1024];//uses big number of bytes as we dont know the length of input stream
        int n = 0;
        while (-1 != (n = in.read(buf))) 
        {
            out.write(buf, 0, n);
        }
        out.close();// clossing byte stream & and maps url stream
        in.close();
        byte[] response = out.toByteArray();
        return response;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "forecast")
    @SuppressWarnings("empty-statement")
    public List<String> forecast(String destination) 
    {
        String tempDestination; // to replace blank spaces as http dosent react well to them
        tempDestination = destination.replace(" ", "+");

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + tempDestination + "&mode=xml&APPID=ed2e93ad9478055942e331d032918ea2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();; //establish connection & Check for successful response code or throw error
            if (conn.getResponseCode() != 200) 
            {
                throw new IOException(conn.getResponseMessage());
            }
            BufferedReader ins = new BufferedReader(new InputStreamReader(conn.getInputStream()));//reads directions
            String inString;
            StringBuilder sb = new StringBuilder();
            while ((inString = ins.readLine()) != null)// reads to end of line
            {
                sb.append(inString + "\n");// adds to string builer on new line
            }
            ins.close(); // closses dirrections url connecton
            return parseXMLWeather(sb.toString());// extracts exything needed from the string

        } catch (MalformedURLException me) 
        {
            System.out.println("MalformedURLException: " + me);;
        } catch (IOException ioe) 
        {
            System.out.println("IOException: " + ioe);;
        }
        return null;
    }

    private List<String> parseXMLWeather(String xml) 
    {
        List<String> directions = new ArrayList();

        try {
            StringBuilder sb = new StringBuilder();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler;
            handler = new DefaultHandler() //helps handle inputs opening stream & outputs closing stream
            {
                boolean forecast = false;

                //<html_instructions>
                //<text> Gets the starting tag

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
                {
                    super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
                    
                    if (qName.equalsIgnoreCase("time"))
                    {
                        for (int i = 0; i < attributes.getLength(); i++) 
                        {
                            String sAttrName = attributes.getLocalName(i);
                            if (sAttrName.compareTo("from") == 0) 
                            {
                                String sVal = attributes.getValue(i);
                                directions.add("From: " + sVal);
                            }

                            if (sAttrName.compareTo("to") == 0) 
                            {
                                String sVal = attributes.getValue(i);
                                directions.add("To: " + sVal);
                            }
                        }
                    }

                    if (qName.equalsIgnoreCase("symbol"))
                    {
                        for (int i = 0; i < attributes.getLength(); i++) 
                        {
                            String sAttrName = attributes.getLocalName(i);
                            if (sAttrName.compareTo("name") == 0) 
                            {
                                String sVal = attributes.getValue(i);
                                directions.add("Weather Status: " + sVal);
                            }

                        }
                    }

                    if (qName.equalsIgnoreCase("windSpeed"))
                    {
                        for (int i = 0; i < attributes.getLength(); i++) 
                        {
                            String sAttrName = attributes.getLocalName(i);
                            if (sAttrName.compareTo("name") == 0) 
                            {
                                String sVal = attributes.getValue(i);
                                directions.add("Wind: " + sVal);
                            }

                        }
                    }

                    if (qName.equalsIgnoreCase("temperature"))
                    {
                        for (int i = 0; i < attributes.getLength(); i++) 
                        {
                            String sAttrName = attributes.getLocalName(i);
                            if (sAttrName.compareTo("value") == 0) 
                            {
                                String sVal = attributes.getValue(i);
                                directions.add("Temperature: " + sVal + "°C" + "\n");
                            }
                        }
                    }

                }

                //<_____> Gets everything in between the tags
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException 
                {
                    super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
                    if (forecast == true) 
                    {
                        sb.append(ch, start, length);//adds all intstuctions inbetween tags to SB if instructions=true
                    }
                }

                //</html_instructions> Gets the ending tag
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException 
                {
                    super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
                }
            };
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) 
        {

        }
        return directions;
    }

}

// AIzaSyBAT8YJVPTIVxp2jAlftksOeIFkE84W3EU // google api key
// AIzaSyBEnyjUXjBXWVfxALm5J7iTQWG3DBb10lY // google server api key
// ed2e93ad9478055942e331d032918ea2 // Open Weather Map API ID 
