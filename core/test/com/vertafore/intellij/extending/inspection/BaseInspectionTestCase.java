package com.vertafore.intellij.extending.inspection;

import com.intellij.codeInspection.GlobalInspectionTool;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.openapi.application.PathManager;
import com.intellij.testFramework.InspectionTestCase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * @author bhandy
 */
public class BaseInspectionTestCase extends InspectionTestCase {

    protected String getTestPath(@NotNull LocalInspectionTool inspection) {
        return inspection.getShortName() + "/";
    }

    protected String getTestPath(@NotNull GlobalInspectionTool inspection) {
        return inspection.getShortName() + "/";
    }

    protected String getTestDataPath() {
        return "core/testData/";
    }

}
