package models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Ravindra on 18-09-2019.
 */
@XmlRootElement
public class Page {

    public String getName() {
        return name;
    }

    @XmlElement(name="name")
    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public ArrayList<Element> getListOfElements() {
        return listOfElements;
    }

    @XmlElementWrapper(name = "elements")
    @XmlElement(name="element")
    public void setListOfElements(ArrayList<Element> listOfElements) {
        this.listOfElements = listOfElements;
    }

    private ArrayList<Element> listOfElements;


}
