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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

    public static void processTestedAnnotation(Object testClass, Field f) throws DaiquiriException {
        Tested testedAnnotation = f.getAnnotation(Tested.class);
        if (testedAnnotation != null) {
            try {
                Object newInstance = newInstance(f.getType());
                f.setAccessible(true);
                f.set(testClass, newInstance);
                if (testedAnnotation.postConstruct()) {
                    invokeMethodsWithAnnotation(newInstance, PostConstruct.class);
                }
            } catch (IllegalAccessException e) {
                throw new DaiquiriException(e);
            }
        }
    }

    static <T> T newInstance(Class<T> clazz, Object... parameters) throws DaiquiriException {
        try {
            if (parameters == null || parameters.length == 0) {
                return clazz.newInstance();
            } else {
                List<Class<?>> parameterTypes = new ArrayList<Class<?>>();
                for (Object p : parameters) {
                    parameterTypes.add(p.getClass());
                }
                Constructor<T> constructor = clazz.getConstructor(parameterTypes.toArray(new Class<?>[0]));
                return constructor.newInstance(parameters);
            }
        } catch (InstantiationException e) {
            throw new DaiquiriException(e);
        } catch (IllegalAccessException e) {
            throw new DaiquiriException(e);
        } catch (NoSuchMethodException e) {
            throw new DaiquiriException(e);
        } catch (InvocationTargetException e) {
            throw new DaiquiriException(e);
        }
    }
}
