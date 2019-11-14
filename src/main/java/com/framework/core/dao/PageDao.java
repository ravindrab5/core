package com.framework.core.dao;

/**
 * Created by Ravindra on 19-09-2019.
 */
public interface PageDao {
    String getUiName(String name);
    String getLocatorType(String name);
    String getLocator(String name);
    String getNextPage(String name);
}
