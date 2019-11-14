package com.framework.core.dao;

import com.framework.core.models.Page;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravindra on 19-09-2019.
 */
public class PageDaoImpl implements PageDao {
    Page page;

    private Map<String,String> uiname;
    private Map<String,String> locator_type;
    private Map<String,String> locator;
    private Map<String,String> next_page;

    public PageDaoImpl(String page) {
        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Page.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read
            File XMLfile = new File("./Views/"+page+".xml");

            // this will create Java object - country from the XML file
            this.page = (Page) jaxbUnmarshaller.unmarshal(XMLfile);

            initElementData();

        }catch (JAXBException e){

        }

    }

    private void initElementData(){
        uiname=new HashMap<String,String>();


        page.getListOfElements().stream().forEach((n)->{
          uiname.put(n.getName(),n.getUiname());
        });


        locator_type=new HashMap<String,String>();

        page.getListOfElements().stream().forEach((n)->{
            locator_type.put(n.getName(),n.getLocator_type());
        });

        locator=new HashMap<String,String>();

        page.getListOfElements().stream().forEach((n)->{
            locator.put(n.getName(),n.getLocator());
        });

        next_page=new HashMap<String,String>();

        page.getListOfElements().stream().forEach((n)->{
            next_page.put(n.getName(),n.getNext_page());
        });

    }

    @Override
    public String getUiName(String name) {
        return uiname.get(name);
    }

    @Override
    public String getLocatorType(String name) {
        return locator_type.get(name);
    }

    @Override
    public String getLocator(String name) {
        return locator.get(name);
    }

    @Override
    public String getNextPage(String name) {
        return next_page.get(name);
    }
}
