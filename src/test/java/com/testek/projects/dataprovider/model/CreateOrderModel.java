package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderModel extends BaseModel {

    public DataModel phone;
    public DataModel shipperPhone;
    public DataModel email;
    public DataModel address;

    public CreateOrderModel() {
        phone = createDataModelObj("Phone");
        shipperPhone = createDataModelObj("ShipperPhone");
        email = createDataModelObj("Email");
        address = createDataModelObj("Address");
    }
}
