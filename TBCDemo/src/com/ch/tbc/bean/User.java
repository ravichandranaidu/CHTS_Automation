package com.ch.tbc.bean;

public class User
{

    String firstName        = "";

    String lastName         = "";

    String address          = "";

    String continuedAddress = "";

    String city             = "";

    String state            = "";

    String zipCode          = "";

    String primaryPhone     = "";

    String alternatePhone   = "";

    String email            = "";

    String confirmEmail     = "";

    String password         = "";

    String confirmPassword  = "";

    public User()
    {

    }

    public User(String[] data)
    {
        firstName = data[0];
        lastName = data[1];
        address = data[2];
        continuedAddress = data[3];
        city = data[4];
        state = data[5];
        zipCode = data[6];
        primaryPhone = data[7];
        alternatePhone = data[8];
        email = data[9];
        confirmEmail = data[9];
        password = data[10];
        confirmPassword = data[10];
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContinuedAddress()
    {
        return continuedAddress;
    }

    public void setContinuedAddress(String continuedAddress)
    {
        this.continuedAddress = continuedAddress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getPrimaryPhone()
    {
        return primaryPhone;
    }

    public String getFirstPhone()
    {
        return (String) primaryPhone.subSequence(0, 3);
    }
    
    public String getMiddlePhone()
    {
        if(primaryPhone.length() <= 3)
        {
            return "";
        }
        return (String) primaryPhone.subSequence(3, 6);
    }
    
    public String getLastPhone()
    {
        if(primaryPhone.length() <= 6)
        {
            return "";
        }
        return (String) primaryPhone.subSequence(6, primaryPhone.length());
    }
    
    public void setPrimaryPhone(String primaryPhone)
    {
        this.primaryPhone = primaryPhone;
    }

    public String getAlternatePhone()
    {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone)
    {
        this.alternatePhone = alternatePhone;
    }

    public String getFirstMobilePhone()
    {
        if(alternatePhone.length() <= 1)
        {
            return "";
        }
        return (String) alternatePhone.subSequence(0, 3);
    }
    
    public String getMiddleMobilePhone()
    {
        if(alternatePhone.length() <= 3)
        {
            return "";
        }
        return (String) alternatePhone.subSequence(3, 6);
    }
    
    public String getLastMobilePhone()
    {
        if(alternatePhone.length() <= 6)
        {
            return "";
        }
        return (String) alternatePhone.subSequence(6, alternatePhone.length());
    }
    
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getConfirmEmail()
    {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail)
    {
        this.confirmEmail = confirmEmail;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

}
