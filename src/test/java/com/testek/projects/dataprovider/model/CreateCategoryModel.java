package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CreateCategoryModel extends BaseModel {
    public DataModel name;
    public DataModel status;
    public DataModel description;

    public CreateCategoryModel() {
        super();
        name = createDataModelObj("categoryName");
        status = createDataModelObj("categoryStatus");
        description = createDataModelObj("categoryDescription");
    }
}
