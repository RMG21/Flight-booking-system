/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightTravelAgencyGUI;

import FlightTravelAgencyClient.FlightType;
import FlightTravelAgencyClient.IOException_Exception;
import FlightTravelAgencyClient.MalformedURLException_Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author rachellee
 */
public class FlightTravelAgencyGUI extends javax.swing.JFrame 
{
    /**
     * Creates new form FlightTravelAgencyGUI
     */
    public FlightTravelAgencyGUI() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromSearch = new javax.swing.JTextField();
        toSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        idBook = new javax.swing.JTextField();
        bookButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numOfSeats = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        flightsDisplay = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        searchAllFlightButton = new javax.swing.JButton();
        preferedCurrency = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        convPriceDisplay = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        directionsDisplay = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mapDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        weatherDisplay = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        fromSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromSearchActionPerformed(evt);
            }
        });
        getContentPane().add(fromSearch);
        fromSearch.setBounds(22, 121, 107, 26);

        toSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSearchActionPerformed(evt);
            }
        });
        getContentPane().add(toSearch);
        toSearch.setBounds(160, 120, 98, 26);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton);
        searchButton.setBounds(319, 121, 85, 29);
        getContentPane().add(idBook);
        idBook.setBounds(22, 192, 107, 26);

        bookButton.setText("Book");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });
        getContentPane().add(bookButton);
        bookButton.setBounds(319, 192, 85, 29);

        jLabel1.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel1.setText("Search From");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 100, 110, 23);

        jLabel2.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel2.setText("Search To");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 100, 90, 20);

        jLabel3.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel3.setText("Flight ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 170, 80, 23);

        jLabel5.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel5.setText("Seats");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 170, 50, 23);

        numOfSeats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        numOfSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfSeatsActionPerformed(evt);
            }
        });
        getContentPane().add(numOfSeats);
        numOfSeats.setBounds(239, 193, 74, 27);

        flightsDisplay.setColumns(20);
        flightsDisplay.setRows(5);
        jScrollPane1.setViewportView(flightsDisplay);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 305, 336, 197);

        jLabel6.setFont(new java.awt.Font("Phosphate", 1, 32)); // NOI18N
        jLabel6.setText("RMG.Ltd Flight Travel Agency");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(383, 18, 460, 39);

        jLabel7.setFont(new java.awt.Font("Phosphate", 1, 24)); // NOI18N
        jLabel7.setText("Flight Booking System");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 60, 261, 24);

        searchAllFlightButton.setText("Search All Flights");
        searchAllFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAllFlightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchAllFlightButton);
        searchAllFlightButton.setBounds(422, 121, 153, 29);

        preferedCurrency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AED", "ARS", "AUD", "BGN", "BRL", "BWP", "CAD", "CHF", "CLP", "CNY", "COP", "DKK", "EEK", "EGP", "EUR", "GBP", "HKD", "HRK", "HUF", "ILS", "INR", "ISK", "JPY", "KRW", "KZT", "LKR", "LTL", "LVL", "LYD", "MXN", "MYR", "NOK", "NPR", "NZD", "OMR", "PKR", "QAR", "RON", "RUB", "SAR", "SDG", "SEK", "SGD", "THB", "TRY", "TTD", "TWD", "UAH ", "USD ", "VEB ", "ZAR" }));
        getContentPane().add(preferedCurrency);
        preferedCurrency.setBounds(422, 193, 88, 27);

        jLabel8.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel8.setText("Currency");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(420, 170, 83, 23);

        jLabel9.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel9.setText("Converted Price");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(380, 230, 150, 23);

        convPriceDisplay.setColumns(20);
        convPriceDisplay.setRows(5);
        jScrollPane2.setViewportView(convPriceDisplay);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(384, 255, 231, 33);

        directionsDisplay.setColumns(20);
        directionsDisplay.setRows(5);
        jScrollPane3.setViewportView(directionsDisplay);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(384, 366, 308, 136);

        jLabel10.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel10.setText("Available Flights");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 280, 160, 23);

        jLabel11.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        jLabel11.setText("Directions");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(380, 340, 100, 23);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1260, 346, 0, 0);
        getContentPane().add(mapDisplay);
        mapDisplay.setBounds(782, 69, 478, 356);

        jLabel4.setFont(new java.awt.Font("Phosphate", 1, 20)); // NOI18N
        jLabel4.setText("Map");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1000, 26, 39, 26);

        weatherDisplay.setColumns(20);
        weatherDisplay.setRows(5);
        jScrollPane4.setViewportView(weatherDisplay);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(879, 431, 381, 140);

        jLabel13.setFont(new java.awt.Font("Phosphate", 0, 16)); // NOI18N
        jLabel13.setText("Destination weather:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(701, 456, 170, 20);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FlightTravelAgencyGUI/clouds7.jpeg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 1270, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        // TODO add your handling code here:
        String flightID = "", numOfSeats = "", fromCur = "", toCur = "";
        double price = 0;
        flightID = this.idBook.getText();
        toCur = this.preferedCurrency.getSelectedItem().toString().substring(0,3);//gets prefered currency code
        numOfSeats = this.numOfSeats.getSelectedItem().toString();
        int seats = Integer.parseInt(numOfSeats);
        
        List<FlightType> searchFlight = booking(flightID,seats);
        
        System.out.println(searchFlight.size());
        
        String result = "";
        
        for(int i = 0; i < searchFlight.size(); i++) 
        {
            fromCur = searchFlight.get(i).getPrice().getCurrency();//gets searched flight currency code
            result = result + "\n  ID: " + searchFlight.get(i).getID()+"\n  Origin: "+
                  searchFlight.get(i).getFrom()+"\n  Destination: "+
                  searchFlight.get(i).getTo()+"\n  Airline: "+
                  searchFlight.get(i).getAirline()+"\n  Seats Avalibility: "+
                  searchFlight.get(i).getSeats()+"\n  Connections: "+
                  searchFlight.get(i).getConnections()+"\n  Currency: "+
                  searchFlight.get(i).getPrice().getCurrency()+"\n  Price: "+
                  searchFlight.get(i).getPrice().getValue();
          
          double convRate = getConversionRate(fromCur, toCur);
           price = searchFlight.get(i).getPrice().getValue() * convRate;// gets converted price
          System.out.println(price);
        }
        String price1 = String.valueOf(price);
        this.flightsDisplay.setText(result);
        this.convPriceDisplay.setText(price1);
        this.mapDisplay.setIcon(null);
    }//GEN-LAST:event_bookButtonActionPerformed

    private void fromSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromSearchActionPerformed

    private void toSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toSearchActionPerformed

    private void numOfSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numOfSeatsActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String from = "",to = "", fromCur = "", toCur = "";
        double price = 0;
        from = this.fromSearch.getText();       
        to = this.toSearch.getText();
        toCur = this.preferedCurrency.getSelectedItem().toString().substring(0,3);//gets prefered currency code only
        System.out.println(toCur);
        this.directionsDisplay.setText("");//to clear directions everytime searched
        this.mapDisplay.setIcon(null);
        this.weatherDisplay.setText("");
        List<FlightType> searchFlight = searchFlights(from,to);
        System.out.println(searchFlight.size());
        
        List<String> string = directions(from,to);
        //for(int i =0; i<forecast(to).size(); i++)
        for(String str : forecast(to))// this way to loop runs quicker for some reason(talk about in QOS report)
        {
            //String str = forecast(to).get(i);
            this.weatherDisplay.append(str + "\n");
            System.out.println(str);
        }
        
        try {
            this.mapDisplay.setIcon(new ImageIcon(maps(from,to)));
        } catch (MalformedURLException_Exception ex) 
        {
            Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException_Exception ex) 
        {
            Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        for(int i = 0; i<string.size();i++)
        {
            String str = string.get(i);
            this.directionsDisplay.append(str+"\n");
        }
        
        
        String result = "";
        
        for(int i = 0; i < searchFlight.size(); i++) 
        {
             fromCur = searchFlight.get(i).getPrice().getCurrency();//gets searched flight currency code
             result = result + "\n  ID: " + searchFlight.get(i).getID()+"\n  Origin: "+
                  searchFlight.get(i).getFrom()+"\n  Destination: "+
                  searchFlight.get(i).getTo()+"\n  Airline: "+
                  searchFlight.get(i).getAirline()+"\n  Seats Avalibility: "+
                  searchFlight.get(i).getSeats()+"\n  Connections: "+
                  searchFlight.get(i).getConnections()+"\n  Currency: "+
                  searchFlight.get(i).getPrice().getCurrency()+"\n  Price: "+
                  searchFlight.get(i).getPrice().getValue();
       
        double convRate = getConversionRate(fromCur, toCur);
            
           price = searchFlight.get(i).getPrice().getValue() * convRate;// gets converted price
          System.out.println(price);
        }
        String price1 = String.valueOf(price);
        this.flightsDisplay.setText(result);
        this.convPriceDisplay.setText(price1);
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchAllFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAllFlightButtonActionPerformed
        // TODO add your handling code here:
        
        List<FlightType> searchFlight = searchAllFlights();
        System.out.println(searchFlight.size());

        String result = "";
  
        for(int i = 0; i < searchFlight.size(); i++) 
        {
          result = result + "\n  ID: " + searchFlight.get(i).getID()+"\n  Origin: "+
                  searchFlight.get(i).getFrom()+"\n  Destination: "+
                  searchFlight.get(i).getTo()+"\n  Airline: "+
                  searchFlight.get(i).getAirline()+"\n  Seats Avalibility: "+
                  searchFlight.get(i).getSeats()+"\n  Connections: "+
                  searchFlight.get(i).getConnections()+"\n  Currency: "+
                  searchFlight.get(i).getPrice().getCurrency()+"\n  Price: "+
                  searchFlight.get(i).getPrice().getValue()+"\n   ";
        }
        this.flightsDisplay.setText(result);
        this.convPriceDisplay.setText("");// removes previous converted curency code
        this.directionsDisplay.setText("");
        this.mapDisplay.setIcon(null);
    }//GEN-LAST:event_searchAllFlightButtonActionPerformed

//populating curency combo box, keep gettiing null exception pointer errors from currency server before program starts. However less reading QOS.
//    public void addCurrencyCodes()
//    {
//        List<String> allCCodes = getCurrencyCodes();
//        
//        for(int i = 0; i < allCCodes.size(); i++)
//        {    
//            this.preferedCurrency.addItem(allCCodes.get(i));
//        }//System.out.println(i);
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightTravelAgencyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FlightTravelAgencyGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookButton;
    private javax.swing.JTextArea convPriceDisplay;
    private javax.swing.JTextArea directionsDisplay;
    private javax.swing.JTextArea flightsDisplay;
    private javax.swing.JTextField fromSearch;
    private javax.swing.JTextField idBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel mapDisplay;
    private javax.swing.JComboBox numOfSeats;
    private javax.swing.JComboBox preferedCurrency;
    private javax.swing.JButton searchAllFlightButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField toSearch;
    private javax.swing.JTextArea weatherDisplay;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<FlightTravelAgencyClient.FlightType> searchFlights(java.lang.String from, java.lang.String to) {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.searchFlights(from, to);
    }

    private static java.util.List<FlightTravelAgencyClient.FlightType> searchAllFlights() {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.searchAllFlights();
    }

    private static java.util.List<java.lang.String> getCurrencyCodes() {
        docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getCurrencyCodes();
    }

    private static double getConversionRate(java.lang.String arg0, java.lang.String arg1) {
        docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getConversionRate(arg0, arg1);
    }

    private static java.util.List<java.lang.String> directions(java.lang.String arg0, java.lang.String arg1) {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.directions(arg0, arg1);
    }

    private static byte[] maps(java.lang.String arg0, java.lang.String arg1) throws MalformedURLException_Exception, IOException_Exception {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.maps(arg0, arg1);
    }

    private static java.util.List<FlightTravelAgencyClient.FlightType> booking(java.lang.String flightID, int numSeats) {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.booking(flightID, numSeats);
    }

    private static java.util.List<java.lang.String> forecast(java.lang.String arg0) {
        FlightTravelAgencyClient.FlightAgencyWS_Service service = new FlightTravelAgencyClient.FlightAgencyWS_Service();
        FlightTravelAgencyClient.FlightAgencyWS port = service.getFlightAgencyWSPort();
        return port.forecast(arg0);
    }

}
