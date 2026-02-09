package com.testek.projects.dataprovider;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.model.CreateOrderModel;
import com.testek.utils.configloader.JsonUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class CreateOrderProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();


    @DataProvider(name = "TK_CreateOrder_001_Valid")
    public  Object[][] TK_CreateOrder_001_Valid (Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_ORDER, method.getName());

        // Using Model Class and Data From Json file
        CreateOrderModel templateModel = new CreateOrderModel();
        return updateDataModel(templateModel, dataList);
    }
    @DataProvider(name = "TK_CreateOrder_002_Valid")
    public  Object[][] TK_CreateOrder_002_Valid (Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_ORDER, method.getName());

        // Using Model Class and Data From Json file
        CreateOrderModel templateModel = new CreateOrderModel();
        return updateDataModel(templateModel, dataList);
    }
}
