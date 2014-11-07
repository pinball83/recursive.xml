package com.thrd.demoxmlparse.app.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * @author safronov
 * @version 29/11/13.
 */
@JacksonXmlRootElement(localName = "groups")
public class Categories {
    @JacksonXmlProperty(localName = "group")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
