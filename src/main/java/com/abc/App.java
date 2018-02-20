package com.abc;

import com.abc.provider.Developer;
import com.abc.provider.impl.JavaDeveloper;
import com.abc.provider.impl.PhpDeveloper;

import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Developer d1 = new JavaDeveloper();
        Developer d2 = new PhpDeveloper();
        ServiceLoader<Developer> developers = ServiceLoader.load(Developer.class);
        Iterator<Developer> iterator = developers.iterator();
        while(iterator.hasNext()){
            Developer developer = iterator.next();
            System.out.println("developer : " + developer.getClass());
        }
        Properties properties = System.getProperties();
        System.out.println("java.class.path : " + properties.get("java.class.path"));
        System.out.println("size of properties : " + properties.size());
        for (Object property: properties.keySet()) {
            System.out.println(property + " : " + properties.get(property));
        }
    }
}
