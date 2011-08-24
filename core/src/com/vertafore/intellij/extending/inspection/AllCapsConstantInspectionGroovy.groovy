package com.vertafore.intellij.extending.inspection

import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.psi.PsiElementVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiReferenceExpression
import com.intellij.psi.PsiField
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierList
import com.intellij.psi.PsiNamedElement
import com.intellij.openapi.util.text.StringUtil
import com.vertafore.intellij.extending.inspection.fix.CapitalizeConstantNameFixGroovy

/**
 *
 *
 * @author bhandy
 */
class AllCapsConstantInspectionGroovy extends BaseJavaLocalInspectionTool {

  String getDisplayName() {
    return "Constants should have names with ALL CAPS";
  }

  String getGroupDisplayName() {
    return "Vertafore";
  }

  String getShortName() {
    return "AllCapsConstantInspection";
  }

  def PsiElementVisitor buildVisitor(ProblemsHolder holder, boolean isOnTheFly) {
    return new AllCapsConstantNameVisitor(holder);
  }

}

class AllCapsConstantNameVisitor extends JavaElementVisitor {

  ProblemsHolder holder;

  AllCapsConstantNameVisitor(newHolder) {
    holder = newHolder
  }

  def void visitField(PsiField field) {
    PsiModifierList modifiers = field.getModifierList();

    if (modifiers != null && modifiers.hasExplicitModifier(PsiModifier.FINAL) && !hasAllCapsName(field)) {
        holder.registerProblem(field, "Constant names should be ALL CAPS.", new CapitalizeConstantNameFixGroovy());
    }
  }

  void visitReferenceExpression(PsiReferenceExpression psiReferenceExpression) {
    // Move along; nothing to see here.
  }

  def boolean hasAllCapsName(PsiNamedElement element) {
      String name = element.getName();
      return (StringUtil.isEmptyOrSpaces(name) || name.toUpperCase().equals(name));
  }


}