package services;

import modelo.Time;

import java.util.List;

/**
 *
 * Defines the time operations
 **/
public interface TimeServices {


    /**
     * Adds a new time interval to the database
     * @param time Time interval to be stored in the database
     */
    public void addTime(Time time);


    /**
     * Deletes a time interval from the database
     * @param time Time interval to be deleted
     */
    public void removeTime(Time time);

    /**
     * Returns all the time intervals in the database
     * @return A collection of time intervals
     */
    public List<Time> getAllTimeIntevals();

    /**
     * Find a time interval in the database by their ID
     * @param id Time interval's id
     * @return The selected time interval
     */
    public Time getByID(Integer id);



}
