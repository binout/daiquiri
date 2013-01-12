package org.daiquiri;

import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriInitialContextFactoryBuilder;
import org.daiquiri.naming.directory.BasicInitialDirContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.spi.NamingManager;

public class Daiquiri {

    public static class Naming {

        private static DaiquiriInitialContextFactoryBuilder daiquiriBuilder;

        public static Context mockInitialContext(InitialContext mockContext) throws NamingException {
            initContextFactoryBuilder();
            daiquiriBuilder.setContext(mockContext);
            return mockContext;
        }

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

        public static DirContext mockInitialDirContext() throws NamingException {
            initContextFactoryBuilder();
            BasicInitialDirContext context = new BasicInitialDirContext();
            daiquiriBuilder.setContext(context);
            return context;
        }

        public static DirContext mockInitialDirContext(DirContext mockDirContext) throws NamingException {
            initContextFactoryBuilder();
            daiquiriBuilder.setContext(mockDirContext);
            return mockDirContext;
        }
    }
}
