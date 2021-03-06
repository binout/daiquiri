/**
 * Copyright (C) 2013 Benoit Prioux <binout@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.binout.daiquiri;

import io.github.binout.daiquiri.annotations.AnnotationUtils;
import io.github.binout.daiquiri.exceptions.DaiquiriException;

import javax.naming.Context;
import java.lang.reflect.Field;

/**
 * Initialize class for Daiquiri annotations
 */
public class DaiquiriAnnotations {

    /**
     * Init Daquiri annotations on test class.
     * The following annotations are managed : @Tested, @MockContext
     * @param testClass the instance of test class
     * @throws io.github.binout.daiquiri.exceptions.DaiquiriException if problems with visibility or security for methods
     */
    public static void init(Object testClass) throws DaiquiriException {
        Field[] fields = testClass.getClass().getDeclaredFields();
        for (Field f : fields) {
            AnnotationUtils.processTestedAnnotation(testClass, f);
            AnnotationUtils.processMockContextAnnotation(testClass, f);
            Context currentContext = Daiquiri.Naming.getCurrentContext();
            if (currentContext != null) {
                AnnotationUtils.processResourceAnnotation(testClass, f, currentContext);
            }
        }
    }
}
