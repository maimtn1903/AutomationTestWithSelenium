package com.testek.projects.dataprovider.providers;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.DataPath;
import com.testek.projects.dataprovider.model.CreateCategoryModel;
import com.testek.projects.dataprovider.model.CreateProductModel;
import com.testek.utils.configloader.JsonUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class CreateCategoryProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();


    @DataProvider(name = "TK_CreateCategory_001_Valid")
    public  Object[][] TK_CreateCategory_001_Valid (Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_CATEGORY, method.getName());

        // Using Model Class and Data From Json file
        CreateCategoryModel templateModel = new CreateCategoryModel();
        return updateDataModel(templateModel, dataList);
    }
}
