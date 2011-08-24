package com.vertafore.intellij.extending.inspection.fix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.openapi.project.Project
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.psi.PsiNamedElement
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement

/**
 *
 *
 * @author bhandy
 */
class CapitalizeConstantNameFixGroovy implements LocalQuickFix {

  void applyFix(Project project, ProblemDescriptor problemDescriptor) {
    PsiElement element = problemDescriptor.getPsiElement();
    if (element instanceof PsiNamedElement) {
      String name = ((PsiNamedElement) element).getName();
      if (!StringUtil.isEmptyOrSpaces(name)) {
          ((PsiNamedElement) element).setName(name.toUpperCase());
      }
    }
  }

  String getFamilyName() {
    return "Extending IntelliJ";
  }

  String getName() {
    return "Capitalize Constant Name";
  }


}
