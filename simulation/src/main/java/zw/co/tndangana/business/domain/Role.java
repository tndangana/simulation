package zw.co.tndangana.business.domain;

/**
 *
 * @author tonderai ndangana created 26/04/2016
 */
public enum Role {

    GENEREL_USER("General User"),
    ADMINISTRATOR("Adminstrator");

    private final String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }

}
