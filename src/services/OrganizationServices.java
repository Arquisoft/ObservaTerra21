package services;

import modelo.Organization;

import java.util.List;

/**
 * Defines the Organization operations
 **/
public interface OrganizationServices{

    /**
     * Adds a new Organization to the database
     * @param organization The organization to be stored
     */
    public void addOrganization(Organization organization);

    /**
     * Removes a organization from the database
     * @param organization Organization to be deleted
     */
    public void removeOrganization(Organization organization);

    /**
     * Returns a specific orgnization from the database by their ID
     * @param id organization's ID
     * @return The selected organization
     */
    public Organization getByID(Integer id);

    /**
     * Returns a collections of the stored organizations in the system
     * @return Collection of the organizations in the system
     */
    public List<Organization> getAll();
}
