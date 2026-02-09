package com.testek.finalExam.locator;

import com.testek.projects.pages.locator.BaseLocator;
import lombok.Getter;

@Getter
public class CategoryLoc extends BaseLocator {
    @Getter
    public static CategoryLoc instance = new CategoryLoc();

    private CategoryLoc() {
    }

    /* Export Category */
    String btnExport = "//button[@testek='btn-export' and .//span[@aria-label='export']]";
    String btnPrint = "//span[@aria-label='printer']/ancestor::button[@testek='btn-export']";
}