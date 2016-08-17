package main.java.entities;

/**
 * Created by Микитенко on 14.08.2016.
 */
public enum UserProperties {
    ID("userID"), USERNAME("username"), CREATION_DATE("creationDate"), AGE("age"), ADMIN("admin");

    private String propertyName;
    public static UserProperties getPropertyByName(String prop)
    {
        if (prop == null)  return ID;

        if(prop.equalsIgnoreCase("id"))
            return ID;
        else if(prop.equalsIgnoreCase("username"))
            return USERNAME;
        else if(prop.equalsIgnoreCase("creation_date"))
            return CREATION_DATE;
        else if(prop.equalsIgnoreCase("age"))
            return AGE;
        else if(prop.equalsIgnoreCase("admin"))
            return ADMIN;
        else
            return ID;//default
    }
    private UserProperties(String propertyName)
    {
        this.propertyName = propertyName;
    }

    public String getPropertyName()
    {
        return this.propertyName;
    }
}
