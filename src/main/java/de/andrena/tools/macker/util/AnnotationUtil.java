package de.andrena.tools.macker.util;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.*;

public class AnnotationUtil {
    public static String[] getAnnotations(CtBehavior behavior) {
        MethodInfo mi = behavior.getMethodInfo2();
        AnnotationsAttribute ainfo = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.invisibleTag);
        AnnotationsAttribute ainfo2 = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.visibleTag);
        return getAnnotationTypes(ainfo, ainfo2);
    }

    public static String[][] getParameterAnnotations(CtBehavior behavior) {
        MethodInfo mi = behavior.getMethodInfo2();
        ParameterAnnotationsAttribute ainfo = (ParameterAnnotationsAttribute) mi.getAttribute(ParameterAnnotationsAttribute.invisibleTag);
        ParameterAnnotationsAttribute ainfo2 = (ParameterAnnotationsAttribute) mi.getAttribute(ParameterAnnotationsAttribute.visibleTag);
        return getParameterAnnotationTypes(ainfo, ainfo2, mi);
    }

    private static String[][] getParameterAnnotationTypes(ParameterAnnotationsAttribute a1, ParameterAnnotationsAttribute a2, MethodInfo minfo) {
        int numParameters = 0;
        if (a1 != null) {
            numParameters = a1.numParameters();
        } else if (a2 != null) {
            numParameters = a2.numParameters();
        } else {
            numParameters = Descriptor.numOfParameters(minfo.getDescriptor());
        }

        String[][] result = new String[numParameters][];
        for (int i = 0; i < numParameters; i++) {
            javassist.bytecode.annotation.Annotation[] anno1, anno2;
            int size1, size2;

            if (a1 == null) {
                anno1 = null;
                size1 = 0;
            } else {
                anno1 = a1.getAnnotations()[i];
                size1 = anno1.length;
            }

            if (a2 == null) {
                anno2 = null;
                size2 = 0;
            } else {
                anno2 = a2.getAnnotations()[i];
                size2 = anno2.length;
            }

            result[i] = new String[size1 + size2];
            for (int j = 0; j < size1; ++j) {
                result[i][j] = anno1[j].getTypeName();
            }

            for (int j = 0; j < size2; ++j) {
                result[i][j + size1] = anno2[j].getTypeName();
            }
        }

        return result;
    }

    private static String[] getAnnotationTypes(AnnotationsAttribute a1, AnnotationsAttribute a2) {
        javassist.bytecode.annotation.Annotation[] anno1, anno2;
        int size1, size2;

        if (a1 == null) {
            anno1 = null;
            size1 = 0;
        } else {
            anno1 = a1.getAnnotations();
            size1 = anno1.length;
        }

        if (a2 == null) {
            anno2 = null;
            size2 = 0;
        } else {
            anno2 = a2.getAnnotations();
            size2 = anno2.length;
        }

        String[] result = new String[size1 + size2];
        for (int i = 0; i < size1; i++) {
            result[i] = anno1[i].getTypeName();
        }

        for (int j = 0; j < size2; j++) {
            result[j + size1] = anno2[j].getTypeName();
        }

        return result;
    }

    public static String[] getFieldAnnotations(CtField field) {
        FieldInfo fi = field.getFieldInfo2();
        AnnotationsAttribute ainfo = (AnnotationsAttribute) fi.getAttribute(AnnotationsAttribute.invisibleTag);
        AnnotationsAttribute ainfo2 = (AnnotationsAttribute) fi.getAttribute(AnnotationsAttribute.visibleTag);
        return getAnnotationTypes(ainfo, ainfo2);
    }

    public static String[] getClassAnnotations(CtClass classType) {
        ClassFile cf = classType.getClassFile2();
        AnnotationsAttribute ainfo = (AnnotationsAttribute) cf.getAttribute(AnnotationsAttribute.invisibleTag);
        AnnotationsAttribute ainfo2 = (AnnotationsAttribute) cf.getAttribute(AnnotationsAttribute.visibleTag);
        return getAnnotationTypes(ainfo, ainfo2);
    }
}
