package main.java.dao;

import main.java.entities.UserProperties;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Created by Микитенко on 14.08.2016.
 */
public class PagingProps {
    private int pageSize;
    private UserProperties orderProperty;
    private boolean asc;

    public PagingProps(int pageSize, String orderBy, String order) {
        this.pageSize = pageSize;
        this.orderProperty = UserProperties.getPropertyByName(orderBy);
        if(!order.equalsIgnoreCase("desc"))
            this.asc = true;
    }

    public Order getHQLOrder()
    {
        if(this.asc)
            return Order.asc(orderProperty.getPropertyName());
        else
            return Order.desc(orderProperty.getPropertyName());
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public UserProperties getOrderProperty() {
        return orderProperty;
    }

    public void setOrderProperty(UserProperties orderProperty) {
        this.orderProperty = orderProperty;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
