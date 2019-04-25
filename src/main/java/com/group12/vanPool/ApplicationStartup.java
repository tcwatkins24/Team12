package com.group12.vanPool;

import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Route;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.DriverRepository;
import com.group12.vanPool.data.repository.RouteRepository;
import com.group12.vanPool.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RouteRepository routeRepository;



    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        //Create a temp Admin
        Users user1 = new Users("admin","password",2,3);
        userRepository.save(user1);

        //Create a temp Driver
        Users user2 = new Users("driver","password",1,3);
        userRepository.save(user2);
        Driver driver2 = new Driver("Kyle Hall",0,"driver",false);
        driverRepository.save(driver2);

        //Create a temp Passenger
        Users user3 = new Users("user","password",0,3);
        userRepository.save(user3);

        //Create temp Routes
        Route route1 = new Route("Iowa City","Des Moines","6AM","4PM",5);
        Route route2 = new Route("Iowa City","Dubuque","7AM","5PM",4);
        Route route3 = new Route("Iowa City","Cedar Rapids","7AM","3PM",6);
        Route route4 = new Route("Iowa City","Moline","4AM","5PM",3);

        routeRepository.save(route1);
        routeRepository.save(route2);
        routeRepository.save(route3);
        routeRepository.save(route4);

    }

} // class