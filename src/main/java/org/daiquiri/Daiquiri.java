package org.daiquiri;

import org.daiquiri.naming.BasicInitialContext;
import org.daiquiri.naming.DaiquiriContext;
import org.daiquiri.naming.DaiquiriContextFactoryBuilder;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;

public class Daiquiri {

    public static class Naming {

        private static DaiquiriContextFactoryBuilder builder;

        public static Context mockInitialContext() throws NamingException {
            if (builder == null) {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException("Cannot mock InitialContext because a JNDI provider is already registered.");
                }
                builder = new DaiquiriContextFactoryBuilder();
                NamingManager.setInitialContextFactoryBuilder(builder);
            }
            DaiquiriContext context = new BasicInitialContext();
            builder.setContext(context);
            return context;
        }
    }
}
