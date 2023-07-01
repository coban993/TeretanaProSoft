/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



/**
 *
 * @author jovan
 */
public class DBProperties {
    Properties properties;

    public DBProperties() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("properties.config"));
    }
    
    public String vratiDbUrl() {
        return properties.getProperty(DBKonstante.URL);
    }

    public String vratiDbUsername() {
        return properties.getProperty(DBKonstante.USERNAME);
    }
    
    public String vratiDbPassword() {
        return properties.getProperty(DBKonstante.PASSWORD);
    }
    
    public String vratiDbPort() {
        return properties.getProperty(DBKonstante.PORT);
    }
}
