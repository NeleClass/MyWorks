package lt.bit.springdata.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lt.bit.springdata.db.Persons;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-28T12:27:16")
@StaticMetamodel(Addresses.class)
public class Addresses_ { 

    public static volatile SingularAttribute<Addresses, String> addresses;
    public static volatile SingularAttribute<Addresses, String> city;
    public static volatile SingularAttribute<Addresses, String> postalCode;
    public static volatile SingularAttribute<Addresses, Persons> personId;
    public static volatile SingularAttribute<Addresses, Integer> id;

}