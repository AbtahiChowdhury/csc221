package contacts;

import java.io.File;

public class Contact
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private File imageFile = null;
    
    public Contact()
    {
        this("","","","","");
    }
    public Contact(String firstnamein, String lastnamein, String emailaddressin, String phonenumberin, String filepathin)
    {
        firstName = firstnamein;
        lastName = lastnamein;
        emailAddress = emailaddressin;
        phoneNumber = phonenumberin;
        if (!filepathin.isEmpty())
        {
            imageFile = new File(filepathin);
        }
    }
    
    public void setFirstName(String firstnamein)
    {
        firstName = firstnamein;
    }
    public void setLastName(String lastnamein)
    {
        lastName = lastnamein;
    }
    public void setEmailAddress(String emailaddressin)
    {
        emailAddress = emailaddressin;
    }
    public void setPhoneNumber(String phonenumberin)
    {
        phoneNumber = phonenumberin;
    }
    public void setImageFile(String filepathin)
    {
        imageFile = new File(filepathin);
    }
    public void setImageFile(File filein)
    {
        imageFile = filein;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmailAddress()
    {
        return emailAddress;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getImageFilePath()
    {
        if(imageFile == null)
        {
            return null;
        }
        else
        {
            return imageFile.getPath();
        }
    }
    public File getImageFile()
    {
        if(imageFile == null)
        {
            return null;
        }
        else
        {
            return imageFile;
        }
    }
    
    @Override
    public String toString()
    {
        return firstName+" "+lastName;
    }
}
