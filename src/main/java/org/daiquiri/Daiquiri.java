package org.daiquiri;

import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriContextFactoryBuilder;
import org.daiquiri.naming.directory.BasicDirContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.spi.NamingManager;

public class Daiquiri {

    public static class Naming {

        private static DaiquiriContextFactoryBuilder builder;

        public static Context mockInitialContext(InitialContext mockContext) throws NamingException {
            initContextFactoryBuilder();
            builder.setContext(mockContext);
            return mockContext;
        }

        public static Context mockInitialContext() throws NamingException {
            initContextFactoryBuilder();
            Context context = new BasicInitialContext();
            builder.setContext(context);
            return context;
        }

        private static void initContextFactoryBuilder() throws NamingException {
            if (builder == null) {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException("Cannot mock InitialContext because a JNDI provider is already registered.");
                }
                builder = new DaiquiriContextFactoryBuilder();
                NamingManager.setInitialContextFactoryBuilder(builder);
            }
        }

        public static DirContext mockDirContext() throws NamingException {
            initContextFactoryBuilder();
            BasicDirContext context = new BasicDirContext();
            builder.setContext(context);
            return context;
        }

        public static DirContext mockDirContext(DirContext mockDirContext) throws NamingException {
            initContextFactoryBuilder();
            builder.setContext(mockDirContext);
            return mockDirContext;
        }
    }
}
