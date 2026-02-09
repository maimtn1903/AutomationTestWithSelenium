package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class LoginModel extends BaseModel {
    public DataModel userName;
    public DataModel password;
    public DataModel expectedRes;
    public DataModel errMsg;
    public DataModel toastMsg;

    public LoginModel() {
        super();
        userName = createDataModelObj("UserName");
        password = createDataModelObj("Password");
        expectedRes = createDataModelObj("ExpectedResult");
        errMsg= createDataModelObj("ErrorMessage");
        toastMsg= createDataModelObj("ToastMessage");
    }
}
