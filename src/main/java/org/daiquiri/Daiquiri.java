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

import org.daiquiri.exception.DaiquiriException;
import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriInitialContextFactoryBuilder;
import org.daiquiri.naming.directory.BasicInitialDirContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.spi.NamingManager;
import java.lang.reflect.Constructor;
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
         * New instance of given class
         * @param clazz the class to instantiate
         * @param <T> the type
         * @param parameters the parameters of constructor
         * @return a object with type <T> of class clazz
         * @throws DaiquiriException
         */
        public static <T> T newInstance(Class<T> clazz, Object... parameters) throws DaiquiriException {
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

    /**
     * All about mocking javax.naming
     */
    public static class Naming {

        private static DaiquiriInitialContextFactoryBuilder daiquiriBuilder;

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
