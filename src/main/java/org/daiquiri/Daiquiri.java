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
package org.daiquiri;

import org.daiquiri.annotations.AnnotationUtils;
import org.daiquiri.annotations.Tested;
import org.daiquiri.exceptions.DaiquiriException;
import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriInitialContextFactoryBuilder;
import org.daiquiri.naming.directory.BasicInitialDirContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.spi.NamingManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for Daiquiri utilities
 */
public class Daiquiri {

    /**
     * All about reflection
     */
    public static class Reflect {

        /**
         * Invokes methods of object annotated with @PostConstruct
         * @param object the instance of object
         * @param <T> the type
         * @return the same object
         */
        public static <T> T invokePostConstruct(T object) {
            return AnnotationUtils.invokeMethodsWithAnnotation(object, PostConstruct.class);
        }

        /**
         * Invokes methods of object annotated with @PreDestroy
         * @param object the instance of object
         * @param <T> the type
         * @return the same object
         */
        public static <T> T invokePreDestroy(T object) {
            return AnnotationUtils.invokeMethodsWithAnnotation(object, PreDestroy.class);
        }

    }

    /**
     * All about mocking javax.naming
     */
    public static class Naming {

        private static DaiquiriInitialContextFactoryBuilder daiquiriBuilder;

        /**
         * Get current context used by InitialContextFactory
         * @return null or an instance of context
         */
        public static Context getCurrentContext() {
            return daiquiriBuilder == null ? null : daiquiriBuilder.getContext();
        }

        /**
         * Mock the initial context factory with the given initial context instance
         * @param mockContext an instance of initial context
         * @return the mocked context
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static InitialContext mockInitialContext(InitialContext mockContext) throws NamingException {
            initInitialContextFactoryBuilder();
            daiquiriBuilder.setContext(mockContext);
            return mockContext;
        }

        /**
         * Mock the initial context factory with a basic implementation of initial context
         * @return the mocked context
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static InitialContext mockInitialContext() throws NamingException {
            initInitialContextFactoryBuilder();
            InitialContext context = new BasicInitialContext();
            daiquiriBuilder.setContext(context);
            return context;
        }

        private static void initInitialContextFactoryBuilder() throws NamingException {
            if (daiquiriBuilder == null) {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException("Cannot mock InitialContextFactoryBuilder because a JNDI provider is already registered.");
                }
                daiquiriBuilder = new DaiquiriInitialContextFactoryBuilder();
                NamingManager.setInitialContextFactoryBuilder(daiquiriBuilder);
            }
        }

        /**
         * Mock the initial dircontext factory with a basic implementation of initial context
         * @return the mocked dircontext
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static InitialDirContext mockInitialDirContext() throws NamingException {
            initInitialContextFactoryBuilder();
            InitialDirContext context = new BasicInitialDirContext();
            daiquiriBuilder.setContext(context);
            return context;
        }

        /**
         * Mock the initial dircontext factory with the given initial dircontext instance
         * @param mockDirContext an instance of initial dircontext
         * @return the mocked dircontext
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static InitialDirContext mockInitialDirContext(InitialDirContext mockDirContext) throws NamingException {
            initInitialContextFactoryBuilder();
            daiquiriBuilder.setContext(mockDirContext);
            return mockDirContext;
        }
    }
}
