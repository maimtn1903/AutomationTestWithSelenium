package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSupplierModel extends BaseModel {
    public DataModel userName;
    public DataModel phone;
    public DataModel contact;
    public DataModel country;
    public DataModel city;
    public DataModel address;
    public DataModel postalCode;

    public CreateSupplierModel() {
        super();
        userName = createDataModelObj("supplierName");
        phone = createDataModelObj("supplierPhone");
        contact = createDataModelObj("supplierContact");
        country = createDataModelObj("supplierCountry");
        city = createDataModelObj("supplierCity");
        address = createDataModelObj("supplierAddress");
        postalCode = createDataModelObj("supplierPostalCode");
    }
}
