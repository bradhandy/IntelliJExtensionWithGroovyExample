package com.vertafore.intellij.extending.inspection

import com.intellij.codeInspection.InspectionToolProvider

/**
 *
 *
 * @author bhandy
 */
class ExtendingIntelliJInspectionToolProviderGroovy implements InspectionToolProvider {

  Class[] getInspectionClasses() {
    return [ AllCapsConstantInspectionGroovy.class ].toArray(new Class[0]);
  }

}
