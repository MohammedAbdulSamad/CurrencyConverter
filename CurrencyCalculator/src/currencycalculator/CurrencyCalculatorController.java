/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencycalculator;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Mohammed Abdul Samad
 */
public class CurrencyCalculatorController implements Initializable {
    
    @FXML
    private ComboBox currencySelect1;
    @FXML
    private ComboBox currencySelect2;
    @FXML
    private TextField entry1;     
    @FXML
    private TextField result;    
    @FXML
    private Button convertB;
    
    private ObservableList<String> currencies;
    
    private ArrayList<String[]> britishConversionRates;
    private ArrayList<String[]> euroConversionRates;
    private ArrayList<String[]> dollarConversionRates;
    private ArrayList<String[]> yenConversionRates;
    private ArrayList<String[]> rupeeConversionRates;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currencies = FXCollections.observableArrayList();
        initialiseRates();
        initialiseCurrencies();
        currencySelect1.getItems().addAll(currencies);
        currencySelect2.getItems().addAll(currencies);
    }
    
    public void initialiseRates() {
        /******** British Conversion ********************/
        britishConversionRates = new ArrayList<String[]>();
        String[] GBPtoUSD = {"US Dollar (USD)","1.3539"};
        String[] GBPtoEUR = {"Euro (EUR)","1.1249"};
        String[] GBPtoGBP = {"British Pound (GBP)","1.0000"};
        String[] GBPtoJPY = {"Japanese Yen (JPY)","150.8059"};
        String[] GBPtoINR = {"Indian Rupee (INR)","86.3056"};
        britishConversionRates.add(GBPtoUSD);
        britishConversionRates.add(GBPtoEUR);
        britishConversionRates.add(GBPtoGBP);
        britishConversionRates.add(GBPtoJPY);
        britishConversionRates.add(GBPtoINR);
        
        /******** US Conversion ********************/
        dollarConversionRates = new ArrayList<String[]>();
        String[] USDtoUSD = {"US Dollar (USD)","1.0000"};
        String[] USDtoEUR = {"Euro (EUR)","0.8309"};
        String[] USDtoGBP = {"British Pound (GBP)","0.7384"};
        String[] USDtoJPY = {"Japanese Yen (JPY)","111.3726"};
        String[] USDtoINR = {"Indian Rupee (INR))","63.7352"};
        dollarConversionRates.add(USDtoUSD);
        dollarConversionRates.add(USDtoEUR);
        dollarConversionRates.add(USDtoGBP);
        dollarConversionRates.add(USDtoJPY);
        dollarConversionRates.add(USDtoINR);
        
        /******** Euro Conversion ********************/
        euroConversionRates = new ArrayList<String[]>();
        String[] EURtoUSD = {"US Dollar (USD)","1.2034"};
        String[] EURtoEUR = {"Euro (EUR)","1.0000"};
        String[] EURtoGBP = {"British Pound (GBP)","0.8887"};
        String[] EURtoJPY = {"Japanese Yen (JPY)","134.0177"};
        String[] EURtoINR = {"Indian Rupee (INR)","76.7009"};
        euroConversionRates.add(EURtoUSD);
        euroConversionRates.add(EURtoEUR);
        euroConversionRates.add(EURtoGBP);
        euroConversionRates.add(EURtoJPY);
        euroConversionRates.add(EURtoINR);
        
       
        /******** Japanese Conversion ********************/
        yenConversionRates = new ArrayList<String[]>();
        String[] JPYtoUSD = {"US Dollar (USD)","0.0089"};
        String[] JPYtoEUR = {"Euro (EUR)","0.0074"};
        String[] JPYtoGBP = {"British Pound (GBP)","0.0066"};
        String[] JPYtoJPY = {"Japanese Yen (JPY)","1.0000"};
        String[] JPYtoINR = {"Indian Rupee (INR)","0.5724"};
        yenConversionRates.add(JPYtoUSD);
        yenConversionRates.add(JPYtoEUR);
        yenConversionRates.add(JPYtoGBP);
        yenConversionRates.add(JPYtoJPY);
        yenConversionRates.add(JPYtoINR);
        
        /******** Rupee Conversion ********************/
        rupeeConversionRates = new ArrayList<String[]>();
        String[] INRtoUSD = {"US Dollar (USD)","0.0156"};
        String[] INRtoEUR = {"Euro (EUR)","0.0130"};
        String[] INRtoGBP = {"British Pound (GBP)","0.0115"};
        String[] INRtoJPY = {"Japanese Yen (JPY)","1.7469"};
        String[] INRtoINR = {"Indian Rupee (INR)","1.0000"};
        rupeeConversionRates.add(INRtoUSD);
        rupeeConversionRates.add(INRtoEUR);
        rupeeConversionRates.add(INRtoGBP);
        rupeeConversionRates.add(INRtoJPY);
        rupeeConversionRates.add(INRtoINR);
        
    }
    
    public void initialiseCurrencies() {
        currencies.add("British Pound (GBP)");
        currencies.add("Euro (EUR)");
        currencies.add("US Dollar (USD)");
        currencies.add("Indian Rupee (INR)");
        currencies.add("Japanese Yen (JPY)");
    }
    
    @FXML
    public void convert(ActionEvent event) {
        Double amount = Double.parseDouble(entry1.getText());
        String convertFrom = currencySelect1.getSelectionModel().getSelectedItem().toString();
        String convertTo = currencySelect2.getSelectionModel().getSelectedItem().toString();
        Double conversionResult = 0.00;
        
        switch (convertFrom) {
            case "British Pound (GBP)":
                for (String[] rates : britishConversionRates) {
                    if (rates[0].equals(convertTo)) {
                        conversionResult = amount * Double.parseDouble(rates[1]);
                        break;
                    }
                }
                break;
            case "Euro (EUR)":
                for (String[] rates : euroConversionRates) {
                    if (rates[0].equals(convertTo)) {
                        conversionResult = amount * Double.parseDouble(rates[1]);
                        break;
                    }
                }
                break;
            case "US Dollar (USD)":
                for (String[] rates : dollarConversionRates) {
                    if (rates[0].equals(convertTo)) {
                        conversionResult = amount * Double.parseDouble(rates[1]);
                        break;
                    }
                }
                break;
            case "Indian Rupee (INR)":
                for (String[] rates : rupeeConversionRates) {
                    if (rates[0].equals(convertTo)) {
                        conversionResult = amount * Double.parseDouble(rates[1]);
                        break;
                    }
                }
                break;
            case "Japanese Yen (JPY)":
                for (String[] rates : yenConversionRates) {
                    if (rates[0].equals(convertTo)) {
                        conversionResult = amount * Double.parseDouble(rates[1]);
                        break;
                    }
                }
                break;
        }
        
        result.setText(new DecimalFormat("###.###").format(conversionResult));
    }
}
