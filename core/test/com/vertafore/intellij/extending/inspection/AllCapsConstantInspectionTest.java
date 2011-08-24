package com.vertafore.intellij.extending.inspection;

/**
 * @author bhandy
 */
public class AllCapsConstantInspectionTest extends BaseInspectionTestCase {

    public void testFindConstantNotAllCaps() throws Exception {
        doTest();
    }

    private void doTest() throws Exception {
        AllCapsConstantInspectionGroovy inspection = new AllCapsConstantInspectionGroovy();
        doTest(getTestPath(inspection) + getTestName(true), inspection);
    }

}
