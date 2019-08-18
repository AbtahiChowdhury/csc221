package mortgagecalculator;

import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Slider;
import java.text.DecimalFormat;

public class FXMLDocumentController implements Initializable {
    
    @FXML private TextField purchasepricetextfield;
    @FXML private TextField interestratetextfield;
    @FXML private TextField downpaymentamounttextfield;
    @FXML private TextArea display;
    @FXML private Slider loanplanslider;
    
    @FXML
    private void calculate()
    {
        double purchaseprice = Double.parseDouble(purchasepricetextfield.getText());
        double downpaymentamount = Double.parseDouble(downpaymentamounttextfield.getText());
        double intersetrate = (Double.parseDouble(interestratetextfield.getText()))/100;
        int loanplanyears = (int)loanplanslider.getValue();
        int loanplanmonths = loanplanyears*12;
        
        double loanamount = purchaseprice - downpaymentamount;
        
        double temp10 = Math.pow(1+intersetrate, (10*12));
        double temp10_2 = (intersetrate*temp10)/(temp10-1);
        double monthlypayment10years = loanamount * temp10_2;
        
        double temp20 = Math.pow(1+intersetrate, (20*12));
        double temp20_2 = (intersetrate*temp20)/(temp20-1);
        double monthlypayment20years = loanamount * temp20_2;
        
        double temp30 = Math.pow(1+intersetrate, (30*12));
        double temp30_2 = (intersetrate*temp30)/(temp30-1);
        double monthlypayment30years = loanamount * temp30_2;
        
        double tempcustom = Math.pow(1+intersetrate, loanplanmonths);
        double tempcustom_2 = (intersetrate*tempcustom)/(tempcustom-1);
        double monthlypaymentcustomyears = loanamount * tempcustom_2;
        
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        
        display.setText("Loan Amount: "+df.format(loanamount)+"\n"
                       +"10-Year Monthly Payment: $"+df.format(monthlypayment10years)+"\n"
                       +"20-Year Monthly Payment: $"+df.format(monthlypayment20years)+"\n"
                       +"30-Year Monthly Payment: $"+df.format(monthlypayment30years)+"\n"
                       +loanplanyears+"-Year Monthly Payment: $"+df.format(monthlypaymentcustomyears)+"\n");
    }
    
    @FXML
    private void helpInfoDialog()
    {
        Alert helpdialog = new Alert(Alert.AlertType.INFORMATION);
        helpdialog.setTitle("Information");
        helpdialog.setHeaderText("How to use calculator");
        helpdialog.setContentText("Enter purchase price, down payment amount\n"+
                                  "and monthly interest rate in percent form.\n"+
                                  "Use the slider to select the number of years\n"+
                                  "and press calculate");
        helpdialog.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        boolean testmode=false;
        if(testmode)
        {
            purchasepricetextfield.setText("300000");
            downpaymentamounttextfield.setText("30000");
            interestratetextfield.setText("0.5");
            calculate();
        }
        display.setEditable(false);
    }    
    
}
