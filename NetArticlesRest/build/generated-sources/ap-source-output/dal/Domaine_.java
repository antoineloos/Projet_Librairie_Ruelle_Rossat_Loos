package dal;

import dal.Article;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-17T09:02:59")
@StaticMetamodel(Domaine.class)
public class Domaine_ { 

    public static volatile SingularAttribute<Domaine, Integer> idDomaine;
    public static volatile CollectionAttribute<Domaine, Article> articleCollection;
    public static volatile SingularAttribute<Domaine, String> libdomaine;

}