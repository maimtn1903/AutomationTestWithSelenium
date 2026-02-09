package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerModel extends BaseModel {
    public DataModel name;
    public DataModel phone;
    public DataModel email;
    public DataModel contact;
    public DataModel country;
    public DataModel city;
    public DataModel address;
    public DataModel postalCode;

    public CreateCustomerModel() {
        super();
        name = createDataModelObj("customerName");
        phone = createDataModelObj("customerPhone");
        email = createDataModelObj("customerEmail");
        contact = createDataModelObj("customerContact");
        country = createDataModelObj("customerCountry");
        city = createDataModelObj("customerCity");
        address = createDataModelObj("customerAddress");
        postalCode = createDataModelObj("customerPostalCode");
    }
}
