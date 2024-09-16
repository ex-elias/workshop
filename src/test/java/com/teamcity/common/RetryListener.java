package com.teamcity.common;

import com.teamcity.ui.BaseUiTest;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// Листенер добавлен в pom.xml, чтобы работал механизм ретрая упавших тестов
public final class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
        if (BaseUiTest.class.isAssignableFrom(testMethod.getDeclaringClass())) {
            annotation.setDataProvider("browserProvider");
        }
    }

}
