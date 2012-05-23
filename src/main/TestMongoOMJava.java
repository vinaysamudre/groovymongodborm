package main;

/**
 * Created with IntelliJ IDEA.
 * User: e5017581
 * Date: 18/05/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
import com.mongodb.DBCursor;
import main.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.mongodb.DBCursor;

public class TestMongoOMJava {
    public static void main(String[] args) {
        String className ="main.Person";
        MongoEnhancer me = new MongoEnhancer();
        me.enhanceDomainClass(className);

        TestMongoOMJava t = new TestMongoOMJava();
        Person p = new Person();
        p = t.setPerson(p, "Java");

        /*
        DBCursor dbc = p.find();
        System.out.println(dbc);

        while(dbc.hasNext()) {
            Person m3;
            //m3 = new Person(dbc.next().toMap());
            //System.out.println(m3);
        }
        */
    }

    private Person setPerson(Person p, String name) {
        p.setFirstName(name);
        p.setSecondName(name);
        p.setSurName(name);
        p.setCount(1);
        List hob = new ArrayList();
        //String[] hobies = {"a", "b"};
        hob.add("a");
        hob.add("b");
        p.setHobies(hob);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            p.setDob(df.parse("20081029"));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        List comments;
        Map c1 = new HashMap();
        c1.put("c", "comment-1");
        c1.put("createdOn", new Date());
        comments = new ArrayList();
        comments.add(c1);

        Map c2 = new HashMap();
        c2.put("c", "comment-2");
        c2.put("createdOn", new Date());
        comments.add(c2);
        p.setComments(comments);
        return p;
    }

}
