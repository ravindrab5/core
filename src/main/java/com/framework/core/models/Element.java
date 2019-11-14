package com.framework.core.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Ravindra on 18-09-2019.
 */

@XmlRootElement(name = "element")
@XmlType(propOrder = { "name","uiname", "locator_type","locator","next_page"})
public class Element {

    private String uiname;
    private String locator_type;
    private String locator;
    private String next_page;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUiname() {
        return uiname;
    }

    public void setUiname(String uiname) {
        this.uiname = uiname;
    }

    public String getLocator_type() {
        return locator_type;
    }

    public void setLocator_type(String locator_type) {
        this.locator_type = locator_type;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

}
