package com.testek.projects.dataprovider;

import com.testek.consts.FrameConst;

public interface DataPath {
    String env = FrameConst.ExecuteConfig.EXE_ENV.toLowerCase();

    String DATA_LOGIN_DEMO = "data/" + env + "/json/loginData.json";
    String DATA_LOGIN = "data/" + env + "/json/loginDataFull.json";
    String DATA_CREATE_CATEGORY = "data/" + env + "/json/createCategory.json";
    String DATA_CREATE_PRODUCT = "data/" + env + "/json/createProduct.json";
    String DATA_CREATE_CUSTOMER = "data/" + env + "/json/createCustomer.json";
    String DATA_CREATE_INVALID_CUSTOMER = "data/" + env + "/json/createInvalidCustomer.json";
    String DATA_CREATE_SUPPLIER = "data/" + env + "/json/createSupplier.json";
    String DATA_CREATE_ORDER = "data/" + env + "/json/createOrder.json";
    String DATA_CREATE_DOCUMENT_CX = "data/" + env + "/json/cxDocumentCreation.json";
    String DATA_LOGIN_CX = "data/" + env + "/json/cxLogin.json";
}
