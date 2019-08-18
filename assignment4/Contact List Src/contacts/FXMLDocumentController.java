package contacts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import java.io.File;

public class FXMLDocumentController implements Initializable
{
    
    @FXML private TableView<Contact> tableview;
    @FXML private TextField firstnamefield;
    @FXML private TextField lastnamefield;
    @FXML private TextField emailaddressfield;
    @FXML private TextField phonenumberfield;
    @FXML private TableColumn<Contact, String> tablecolumnfirstname;
    @FXML private TableColumn<Contact, String> tablecolumnlastname;
    @FXML private TableColumn<Contact, String> tablecolumnemailaddress;
    @FXML private TableColumn<Contact, String> tablecolumnphonenumber;
    @FXML private Label filepathlabel;
    
    
    @FXML
    private void getImagePath()
    {
        try
        {
            FileChooser fc = new FileChooser();
            fc.setTitle("Select Contact Image");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));
            File selectedfile = fc.showOpenDialog(null);
            if (selectedfile != null)
            {
                filepathlabel.setText(selectedfile.getPath());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clearImagePath()
    {
        filepathlabel.setText("");
    }
    
    @FXML
    protected void addContact(ActionEvent event)
    {
        ObservableList<Contact> data = tableview.getItems();
        if(!firstnamefield.getText().isEmpty() && !lastnamefield.getText().isEmpty() && !emailaddressfield.getText().isEmpty() && !phonenumberfield.getText().isEmpty())
        {
            data.add(new Contact(firstnamefield.getText(),
                                 lastnamefield.getText(),
                                 emailaddressfield.getText(),
                                 phonenumberfield.getText(),
                                 filepathlabel.getText()
                                ));
            tableview.sort();
        }
        else
        {
            Alert helpdialog = new Alert(AlertType.INFORMATION);
            helpdialog.setTitle("Adding Contacts");
            helpdialog.setHeaderText("Fill in all fields");
            helpdialog.setContentText("All fields must be filled in to add a contact.");
            helpdialog.showAndWait();
        }
        firstnamefield.setText("");
        lastnamefield.setText("");
        emailaddressfield.setText("");
        phonenumberfield.setText("");
        filepathlabel.setText("");
    }
    
    @FXML
    private void deleteSelectedContact()
    {
        Contact selecteditem = tableview.getSelectionModel().getSelectedItem();
        ObservableList<Contact> data = tableview.getItems();
        data.remove(selecteditem);
    }
    
    @FXML
    private void helpAddingContactDialog()
    {
        Alert helpdialog = new Alert(AlertType.INFORMATION);
        helpdialog.setTitle("Adding Contacts");
        helpdialog.setHeaderText("How to add contacts");
        helpdialog.setContentText("Enter in the appropriate information into\n"
                                + "corresponding text box and click add. If you\n"
                                + "wish to add a photo along with your contact\n"
                                + "information, use the add image button to\n"
                                + "choose the photo. If you wish to cancel your\n"
                                + "photo selection, use the clear image selection\n");
        helpdialog.showAndWait();
    }
    
    @FXML
    private void helpEditingContactDialog()
    {
        Alert helpdialog = new Alert(AlertType.INFORMATION);
        helpdialog.setTitle("Editing Contacts");
        helpdialog.setHeaderText("How to edit contacts");
        helpdialog.setContentText("Right click on the desired contact to edit\n"
                                + "and click on expand to bring up the contact\n"
                                + "information. In there simply type in the new\n"
                                + "information and click enter to save the changes.");
        helpdialog.showAndWait();
    }
    
    @FXML
    private void helpDeletingContactDialog()
    {
        Alert helpdialog = new Alert(AlertType.INFORMATION);
        helpdialog.setTitle("deleting Contacts");
        helpdialog.setHeaderText("How to delete contacts");
        helpdialog.setContentText("Right-click the entry and click delete.");
        helpdialog.showAndWait();
    }
    
    @FXML
    private void expandContact() throws Exception
    {
        try
        {
            Contact selectedcontact = tableview.getSelectionModel().getSelectedItem();
            
            AnchorPane expandedview = new AnchorPane();

            ImageView contactimageview = new ImageView();
            if(selectedcontact.getImageFile() != null)
            {
                if(selectedcontact.getImageFilePath().substring(0,6).equals("images"))
                {
                    contactimageview.setImage(new Image(selectedcontact.getImageFilePath()));
                }
                else
                {
                    contactimageview.setImage(new Image(selectedcontact.getImageFile().toURI().toString()));
                }
            }
            TextField contactfirstname = new TextField(selectedcontact.getFirstName());
            TextField contactlastname = new TextField(selectedcontact.getLastName());
            TextField contactemail = new TextField(selectedcontact.getEmailAddress());
            TextField contactphone = new TextField(selectedcontact.getPhoneNumber());
            Button contacteditimagebutton = new Button("Edit Image");

            contactimageview.setFitWidth(282);
            contactimageview.setFitHeight(267);
            contactimageview.setLayoutX(18);
            contactimageview.setLayoutY(21);

            contactfirstname.setPromptText("First Name");
            contactfirstname.setLayoutX(362);
            contactfirstname.setLayoutY(25);
            contactfirstname.setOnKeyPressed((event) -> { 
                if(event.getCode() == KeyCode.ENTER)
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Save contact edit?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES)
                    {
                        selectedcontact.setFirstName(contactfirstname.getText());
                        selectedcontact.setLastName(contactlastname.getText());
                        selectedcontact.setEmailAddress(contactemail.getText());
                        selectedcontact.setPhoneNumber(contactphone.getText());
                        tableview.getColumns().get(0).setVisible(false);
                        tableview.getColumns().get(0).setVisible(true);
                    }
                }
            });

            contactlastname.setPromptText("Last Name");
            contactlastname.setLayoutX(362);
            contactlastname.setLayoutY(75);
            contactlastname.setOnKeyPressed((event) -> { 
                if(event.getCode() == KeyCode.ENTER)
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Save contact edit?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES)
                    {
                        selectedcontact.setFirstName(contactfirstname.getText());
                        selectedcontact.setLastName(contactlastname.getText());
                        selectedcontact.setEmailAddress(contactemail.getText());
                        selectedcontact.setPhoneNumber(contactphone.getText());
                        tableview.getColumns().get(0).setVisible(false);
                        tableview.getColumns().get(0).setVisible(true);
                    }
                }
            });

            contactemail.setPromptText("First Name");
            contactemail.setLayoutX(362);
            contactemail.setLayoutY(125);
            contactemail.setOnKeyPressed((event) -> { 
                if(event.getCode() == KeyCode.ENTER)
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Save contact edit?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES)
                    {
                        selectedcontact.setFirstName(contactfirstname.getText());
                        selectedcontact.setLastName(contactlastname.getText());
                        selectedcontact.setEmailAddress(contactemail.getText());
                        selectedcontact.setPhoneNumber(contactphone.getText());
                        tableview.getColumns().get(0).setVisible(false);
                        tableview.getColumns().get(0).setVisible(true);
                    }
                }
            });

            contactphone.setPromptText("First Name");
            contactphone.setLayoutX(362);
            contactphone.setLayoutY(175);
            contactphone.setOnKeyPressed((event) -> { 
                if(event.getCode() == KeyCode.ENTER)
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Save contact edit?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES)
                    {
                        selectedcontact.setFirstName(contactfirstname.getText());
                        selectedcontact.setLastName(contactlastname.getText());
                        selectedcontact.setEmailAddress(contactemail.getText());
                        selectedcontact.setPhoneNumber(contactphone.getText());
                        tableview.getColumns().get(0).setVisible(false);
                        tableview.getColumns().get(0).setVisible(true);
                    }
                }
            });

            contacteditimagebutton.setLayoutX(362);
            contacteditimagebutton.setLayoutY(225);
            contacteditimagebutton.setOnAction(event -> {
                FileChooser fc = new FileChooser();
                fc.setTitle("Select Contact Image");
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg"));
                File selectedfile = fc.showOpenDialog(null);
                if (selectedfile != null)
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION, selectedfile.getPath(), ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    selectedcontact.setImageFile(selectedfile.toURI().toString());
                    contactimageview.setImage(new Image(selectedcontact.getImageFilePath()));
                    contactimageview.setVisible(false);
                    contactimageview.setVisible(true);
                }
            });

            expandedview.getChildren().addAll(contactimageview,contactfirstname,contactlastname,contactemail,contactphone,contacteditimagebutton);

            Scene secondScene = new Scene(expandedview,600,300);
            Stage secondDisplay = new Stage();
            secondDisplay.setTitle(selectedcontact.toString());
            secondDisplay.setScene(secondScene);
            secondDisplay.showAndWait();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void closeProgram()
    {
        Platform.exit();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tablecolumnfirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tablecolumnlastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tablecolumnemailaddress.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        tablecolumnphonenumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        
        Contact c1 = new Contact("Nathalie",
                                 "Debenham",
                                 "nathaliedebenham5854@generic.email.com",
                                 "690-725-1796",
                                 "images//1.jpg");
        Contact c2 = new Contact("Renata",
                                 "Belanger",
                                 "renatabelanger6818@generic.email.com",
                                 "905-806-8501",
                                 "images//2.jpg");
        Contact c3 = new Contact("Leigh",
                                 "Robertsson",
                                 "leighrobertsson6088@generic.email.com",
                                 "334-471-3856",
                                 "images//3.jpg");
        Contact c4 = new Contact("Ea",
                                 "Abarca",
                                 "eaabarca1329@generic.email.com",
                                 "694-098-5799",
                                 "images//4.jpg");
        Contact c5 = new Contact("Winona",
                                 "Vacik",
                                 "winonavacik4205@generic.email.com",
                                 "189-087-6499",
                                 "images//5.jpg");
        Contact c6 = new Contact("Shyamala",
                                 "Thorne",
                                 "shyamalathorne2653@generic.email.com",
                                 "187-035-5226",
                                 "images//6.jpg");
        Contact c7 = new Contact("Caelinus",
                                 "Capitani",
                                 "caelinuscapitani5372@generic.email.com",
                                 "840-934-4163",
                                 "images//7.jpg");
        Contact c8 = new Contact("Nedeljka",
                                 "Gustavsson",
                                 "nedeljkagustavsson4590@generic.email.com",
                                 "714-853-7544",
                                 "images//8.jpg");
        Contact c9 = new Contact("Hildebrand",
                                 "Sapienti",
                                 "hildebrandsapienti3565@generic.email.com",
                                 "993-611-8134",
                                 "images//9.jpg");
        Contact c10 = new Contact("Rhea",
                                  "Glen",
                                  "rheaglen1290@generic.email.com",
                                  "449-566-0244",
                                  "images//10.jpg");
        tableview.getItems().addAll(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
        tableview.getSortOrder().addAll(tablecolumnlastname,tablecolumnfirstname);
        
        Alert helpdialog = new Alert(AlertType.INFORMATION);
        helpdialog.setTitle("Hello");
        helpdialog.setHeaderText("Messege from the developer");
        helpdialog.setContentText("Please consult the help tab at the top of\n"
                                 +"application should you require assistance\n"
                                 +"in the use of this application.");
        helpdialog.showAndWait();
    }    
    
}
