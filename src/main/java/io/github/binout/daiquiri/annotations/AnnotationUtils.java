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
package io.github.binout.daiquiri.annotations;

import io.github.binout.daiquiri.Daiquiri;
import io.github.binout.daiquiri.exceptions.DaiquiriException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtils {

    public static <T> T invokeMethodsWithAnnotation(T object, Class<? extends Annotation> annotationClazz) {
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

    public static void processMockContextAnnotation(Object testClass, Field f) {
        MockContext contextAnnotation = f.getAnnotation(MockContext.class);
        if (contextAnnotation != null) {
            if (f.getType().isAssignableFrom(InitialContext.class)) {
                f.setAccessible(true);
                try {
                    InitialContext mockContext = (InitialContext) f.get(testClass);
                    if (mockContext != null) {
                        Daiquiri.Naming.mockInitialContext(mockContext);
                    } else {
                        mockContext = Daiquiri.Naming.mockInitialContext();
                        f.set(testClass, mockContext);
                    }
                } catch (NamingException e) {
                    throw new DaiquiriException(e);
                } catch (IllegalAccessException e) {
                    throw new DaiquiriException(e);
                }
            }
            else if (f.getType().isAssignableFrom(InitialDirContext.class)) {
                f.setAccessible(true);
                try {
                    InitialDirContext mockContext = (InitialDirContext) f.get(testClass);
                    if (mockContext != null) {
                        Daiquiri.Naming.mockInitialDirContext(mockContext);
                    } else {
                        mockContext = Daiquiri.Naming.mockInitialDirContext();
                        f.set(testClass, mockContext);
                    }
                } catch (NamingException e) {
                    throw new DaiquiriException(e);
                } catch (IllegalAccessException e) {
                    throw new DaiquiriException(e);
                }
            }
        }
    }

    public static void processResourceAnnotation(Object testClass, Field f, Context context) {
        Resource resourceAnnotation = f.getAnnotation(Resource.class);
        if (resourceAnnotation != null) {
            String name = resourceAnnotation.name();
            if (name != null) {
                try {
                    f.setAccessible(true);
                    Object value = f.get(testClass);
                    context.bind(name, value);
                } catch (NamingException e) {
                    throw new DaiquiriException(e);
                } catch (IllegalAccessException e) {
                    throw new DaiquiriException(e);
                }
            }
        }
    }

    public static void processTestedAnnotation(Object testClass, Field f) {
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


    static <T> T newInstance(Class<T> clazz, Object... parameters) {
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
