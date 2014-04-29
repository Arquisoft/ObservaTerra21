package factories;

import factories.persistence.PersistenceFactory;

/**
 * Project: ObservaTerra21
 * Package: factories
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class Factories {

    public static PersistenceFactory getPersistenceFactory(){
        return new PersistenceFactory();
    }

}
