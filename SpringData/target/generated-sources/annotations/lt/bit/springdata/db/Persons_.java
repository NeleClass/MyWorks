package lt.bit.springdata.db;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lt.bit.springdata.db.Addresses;
import lt.bit.springdata.db.Contacts;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-28T12:27:16")
@StaticMetamodel(Persons.class)
public class Persons_ { 

    public static volatile SingularAttribute<Persons, String> firstName;
    public static volatile SingularAttribute<Persons, String> lastName;
    public static volatile ListAttribute<Persons, Contacts> contactsList;
    public static volatile ListAttribute<Persons, Addresses> addressesList;
    public static volatile SingularAttribute<Persons, Integer> id;
    public static volatile SingularAttribute<Persons, BigDecimal> salary;
    public static volatile SingularAttribute<Persons, Date> birthDate;

}