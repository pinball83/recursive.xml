package com.thrd.demoxmlparse.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * @author safronov
 * @version 29/11/13.
 */
public class Category {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    private int sort;
    @JacksonXmlProperty(localName = "operator")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CategoryOperator> categoryOperators;

    @JacksonXmlProperty(localName = "group")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Category> categoryCollection;


    public Category() {
    }

//    public Category(String id, String name, int sort) {
//        this.id = id;
//        this.name = name;
//        this.sort = sort;
//    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryOperator> getCategoryOperators() {
        return categoryOperators;
    }

    public void setCategoryOperators(List<CategoryOperator> categoryOperators) {
        this.categoryOperators = categoryOperators;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(List<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

}