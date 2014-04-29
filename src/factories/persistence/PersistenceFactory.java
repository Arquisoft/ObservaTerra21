package factories.persistence;

import persistence.*;
import persistence.TimeGateway;
import persistence.UserGateway;
import persistence.impl.*;
import services.ObservationServices;

public class PersistenceFactory {

    public UserGateway getUserGateway(){
        return new UserGatewayImpl();
    }

    public TimeGateway  getTimeGateway(){
        return new TimeGatewayImpl();
    }

    public OrganizationGateway getOrganizationGateway(){
        return new OrganizationGatewayImpl();
    }

    public ObservationGateway getObservationGateway(){
        return new ObservationGatewayImpl();
    }

    public MeasureGateway getMeasureGateway(){
        return new MeasureGatewayImpl();
    }

    public IndicatorGateway getIndicatorGateway(){
        return new IndicatorGatewayImpl();
    }

    public AreaGateway getAreaGateway(){
        return new AreaGatewayImpl();
    }

}
