package com.group12.vanPool;

import com.group12.vanPool.data.entity.Driver;
import com.group12.vanPool.data.entity.Users;
import com.group12.vanPool.data.repository.DriverRepository;
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
    }

} // class