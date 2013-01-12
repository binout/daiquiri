package org.daiquiri;

import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriInitialContextFactoryBuilder;
import org.daiquiri.naming.directory.BasicInitialDirContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.spi.NamingManager;

/**
 * Main class for Daiquiri utilities
 */
public class Daiquiri {

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
        public static Context mockInitialContext(InitialContext mockContext) throws NamingException {
            initContextFactoryBuilder();
            daiquiriBuilder.setContext(mockContext);
            return mockContext;
        }

        /**
         * Mock the initial context factory with a basic implementation of initial context
         * @return the mocked context
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static Context mockInitialContext() throws NamingException {
            initContextFactoryBuilder();
            Context context = new BasicInitialContext();
            daiquiriBuilder.setContext(context);
            return context;
        }

        private static void initContextFactoryBuilder() throws NamingException {
            if (daiquiriBuilder == null) {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException("Cannot mock InitialContext because a JNDI provider is already registered.");
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
        public static DirContext mockInitialDirContext() throws NamingException {
            initContextFactoryBuilder();
            BasicInitialDirContext context = new BasicInitialDirContext();
            daiquiriBuilder.setContext(context);
            return context;
        }

        /**
         * Mock the initial dircontext factory with the given initial dircontext instance
         * @param mockDirContext an instance of initial dircontext
         * @return the mocked dircontext
         * @throws NamingException exception throw if a problem with jndi provider
         */
        public static DirContext mockInitialDirContext(DirContext mockDirContext) throws NamingException {
            initContextFactoryBuilder();
            daiquiriBuilder.setContext(mockDirContext);
            return mockDirContext;
        }
    }
}
