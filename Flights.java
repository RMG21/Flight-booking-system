
import flightOrder.*;
import java.io.File;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rachellee
 */
public class Flights 
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create root XML node 'allFlights' and get its main element 'movies_today'
        AllFlights allFlights = new AllFlights();
        List<FlightType> flights_today = allFlights.getFlightsCollection();
        
        FlightType flight;
        
        // had to create new insance of fare for each flight to stop overriding price
        Fare Price1 = new Fare();
        Fare Price2 = new Fare();
        Fare Price3 = new Fare();
        Fare Price4 = new Fare();
        Fare Price5 = new Fare();
        Fare Price6 = new Fare();
        Fare Price7 = new Fare();
        Fare Price8 = new Fare();
        Fare Price9 = new Fare();
        Fare Price10 = new Fare();
        Fare Price11 = new Fare();
        
        // had to create new insance of flight to stop overriding flights
        flight = new FlightType();
        flight.setID("F0001");
        flight.setFrom("London");
        flight.setTo("China");
        flight.setAirline("British Airways");
        flight.setSeats(30);
        flight.setConnections(2);
        Price1.setCurrency("GBP");
        Price1.setValue(600.00);
        flight.setPrice(Price1);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0002");
        flight.setFrom("France");
        flight.setTo("India");
        flight.setAirline("Virgin Airlines");
        flight.setSeats(35);
        flight.setConnections(1);
        Price2.setCurrency("EUR");
        Price2.setValue(750.00);
        flight.setPrice(Price2);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0003");
        flight.setFrom("Miami");
        flight.setTo("Atlanta");
        flight.setAirline("American Airlines");
        flight.setSeats(40);
        flight.setConnections(0);
        Price3.setCurrency("USD");
        Price3.setValue(200.00);
        flight.setPrice(Price3);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0004");
        flight.setFrom("London");
        flight.setTo("New York");
        flight.setAirline("British Airways");
        flight.setSeats(20);
        flight.setConnections(2);
        Price4.setCurrency("GBP");
        Price4.setValue(600.00);
        flight.setPrice(Price4);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0005");
        flight.setFrom("Dubai");
        flight.setTo("Scotland");
        flight.setAirline("Virgin Airlines");
        flight.setSeats(3);
        flight.setConnections(2);
        Price5.setCurrency("USD");
        Price5.setValue(810.00);
        flight.setPrice(Price5);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0006");
        flight.setFrom("Russia");
        flight.setTo("France");
        flight.setAirline("Russian International");
        flight.setSeats(50);
        flight.setConnections(1);
        Price6.setCurrency("EUR");
        Price6.setValue(600.00);
        flight.setPrice(Price6);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0007");
        flight.setFrom("London");
        flight.setTo("Scotland");
        flight.setAirline("British Airways");
        flight.setSeats(10);
        flight.setConnections(0);
        Price7.setCurrency("GBP");
        Price7.setValue(600.00);
        flight.setPrice(Price7);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0008");
        flight.setFrom("Nice");
        flight.setTo("Paris");
        flight.setAirline("France International");
        flight.setSeats(3);
        flight.setConnections(0);
        Price8.setCurrency("EUR");
        Price8.setValue(100.00);
        flight.setPrice(Price8);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0009");
        flight.setFrom("South Africa");
        flight.setTo("Chicago");
        flight.setAirline("American Airlines");
        flight.setSeats(80);
        flight.setConnections(1);
        Price9.setCurrency("USD");
        Price9.setValue(550.00);
        flight.setPrice(Price9);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0010");
        flight.setFrom("London");
        flight.setTo("Ghana");
        flight.setAirline("British Airways");
        flight.setSeats(7);
        flight.setConnections(0);
        Price10.setCurrency("GBP");
        Price10.setValue(600.00);
        flight.setPrice(Price10);
        flights_today.add(flight); // Creates and adds film to list
        
        flight = new FlightType();
        flight.setID("F0011");
        flight.setFrom("London");
        flight.setTo("Scotland");
        flight.setAirline("American Airways");
        flight.setSeats(10);
        flight.setConnections(0);
        Price11.setCurrency("GBP");
        Price11.setValue(600.00);
        flight.setPrice(Price11);
        flights_today.add(flight); // Creates and adds film to list
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allFlights.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(allFlights, System.out);
            
            //Writing the whole XML document to file
            File flightstored = new File("Flights_Showing.xml");
            marshaller.marshal(allFlights, flightstored);
            
        } catch (javax.xml.bind.JAXBException ex) 
        {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
    }
    
}
