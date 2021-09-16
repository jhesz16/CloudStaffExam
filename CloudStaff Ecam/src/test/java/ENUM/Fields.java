package ENUM;

public enum Fields {


    FORENAME("forename"),
    SURNAME("surname"),
    EMAIL("email"),
    TELEPHONE("telephone"),
    MESSAGE("message");

    public final String val;

    Fields(String val) {
        this.val = val;
    }
}
