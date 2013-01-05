package org.daiquiri;

import org.daiquiri.naming.BasicContextFactoryBuilder;

import javax.naming.NamingException;
import javax.naming.spi.NamingManager;

public class Daiquiri {

    public static class Naming {

        private static boolean isMocked = false;

        public static void mockContext() throws NamingException {
            if (isMocked) {
                try {
                    clear();
                } catch (NamingException e) {
                    // No problem
                }
            } else {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException();
                }
                NamingManager.setInitialContextFactoryBuilder(new BasicContextFactoryBuilder());
                isMocked = true;
            }

        }

        public static void bind(String name, Object obj) throws NamingException {
            BasicContextFactoryBuilder.getCurrentContext().bind(name, obj);
        }

        public static void clear() throws NamingException {
            BasicContextFactoryBuilder.getCurrentContext().close();
        }
    }
}
