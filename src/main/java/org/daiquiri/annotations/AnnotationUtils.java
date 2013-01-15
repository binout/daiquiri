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
package org.daiquiri.annotations;

import org.daiquiri.exceptions.DaiquiriException;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationUtils {

    public static <T> T invokeMethodsWithAnnotation(T object, Class<? extends Annotation> annotationClazz) throws DaiquiriException {
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotationClazz.equals(annotation.annotationType())) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        throw new DaiquiriException(e);
                    } catch (InvocationTargetException e) {
                        throw new DaiquiriException(e);
                    }
                }
            }
        }
        return object;
    }
}
