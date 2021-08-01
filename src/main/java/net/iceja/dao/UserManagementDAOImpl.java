/*
Copyright (c) 2019 Ekaterina Alexeevna Ivanova  (iceja.net). All rights reserved.
PROPRIETARY. For demo purposes only, not for redistribution or any commercial use.
*/
package net.iceja.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Ekaterina Alexeevna Ivanova (iceja.net)
 */

public class UserManagementDAOImpl implements UserManagementDAO {
    private List<String> people;
    public static final Logger LOGR = LoggerFactory.getLogger(UserManagementDAOImpl.class);

    public UserManagementDAOImpl() {
    }


    /**
     * @param newUser - the name of newly created user
     * @return true if success
     */
    @Override
    public boolean createUser(String newUser) {
        if (newUser != null) {
            getPeople().add(newUser);
            LOGR.info("User has been created", newUser);
            return true;
        } else {
            return false;
        }
    }

    /**
     *  this is the debug stub
     */
    @PostConstruct
    public void initUserList() {
        setPeople(new ArrayList<>());
    }


    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }
}
