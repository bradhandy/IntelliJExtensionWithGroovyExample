package com.vertafore.intellij.extending.inspection.fix;

import com.intellij.codeInsight.daemon.quickFix.LightQuickFixTestCase;
import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * @author bhandy
 */
public class CapitalizeConstantNameFixTest extends LightQuickFixTestCase {

    public void test() throws Exception {
        doAllTests();
    }

    @Override
    protected void doAction(String text, boolean actionShouldBeAvailable, String testFullPath, String testName)
            throws Exception {
        LocalQuickFix fix = new CapitalizeConstantNameFixGroovy();
        int offset = getEditor().getCaretModel().getOffset();
        PsiElement psiElement = getFile().findElementAt(offset);

        assert psiElement != null : "Should have found a PsiElement at the <caret> position.";

        psiElement = PsiTreeUtil.getParentOfType(psiElement, PsiField.class, true);

        assert psiElement != null : "Should have found a parent of type PsiField.";

        ProblemDescriptor descriptor = InspectionManager.getInstance(getProject())
                .createProblemDescriptor(psiElement, "", fix, ProblemHighlightType.GENERIC_ERROR_OR_WARNING, true);

        fix.applyFix(getProject(), descriptor);
        String expectedFilePath = getBasePath() + "/after" + testName;
        checkResultByFile("In file: " + expectedFilePath, expectedFilePath, false);
    }

    protected String getTestDataPath() {
        return "core/testData/AllCapsConstantInspection";
    }

    protected String getBasePath() {
        return "/quickFix";
    }

}
