package edu.bootcamp.pos.dto.query;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public interface OrderDetails {

    //Customer
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumber();

    //order
    Data getDate();
    Double getTotal();
}
