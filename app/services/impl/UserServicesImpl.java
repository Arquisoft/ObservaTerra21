package services.impl;

import model.User;
import services.UserServices;
import play.db.ebean.Model.Finder;

/**
 * Created by noe on 30/04/2014.
 */
public class UserServicesImpl implements UserServices {

    private Finder<String, User> userFinder = new Finder(Integer.class, User.class);


    @Override
    public User getUserByID(String id) {

        return userFinder.where().eq("usuario",id).findUnique();
    }
}
