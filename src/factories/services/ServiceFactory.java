package factories.services;

import services.*;
import services.impl.*;
/**
 * Project: ObservaTerra21
 * Package: factories.services
 * <p/>
 * <p/>
 * CREATED BY ARQUISOFT 2.1 ON abr , 2014
 * Arquisoft 2.1 is a non-profit organization composed by
 * - José Grana Fernández
 * - Paula Díaz Puertas
 * - Noé Fernández Álvarez
 * - Javier Palacio Cuenca
 */
public class ServiceFactory {

    public AreaServices getAreaServices(){
        return new AreaServiceImpl();
    }

    public IndicatorServices getIndicatorServices(){
        return new IndicatorServicesImpl();
    }

    public MeasureServices getMeasureServices(){
        return new MeasureServicesImpl();
    }

    public ObservationServices getObservationServices(){
        return new ObservationServicesImpl();
    }

    public TimeServices getTimeServices(){
        return new TimeServicesImpl();
    }

    public UserServices getUserServices(){
        return new UserServicesImpl();
    }
}
