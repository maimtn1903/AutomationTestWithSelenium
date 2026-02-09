package com.testek.projects.dataprovider.providers;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.DataPath;
import com.testek.projects.dataprovider.model.CreateProductModel;
import com.testek.projects.dataprovider.model.CreateSupplierModel;
import com.testek.utils.configloader.JsonUtils;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class CreateSupplierProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();

    @DataProvider(name = "TK_CreateSupplier_001_Valid")
    public Object[][] TK_CreateSupplier_001_Valid(Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_SUPPLIER, method.getName());

        // Using Model Class and Data From Json file
        CreateSupplierModel templateModel = new CreateSupplierModel();
        return updateDataModel(templateModel, dataList);
    }
}
