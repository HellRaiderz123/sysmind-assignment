package com.sysmind.org.config;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sysmind.org.business.entity.Student;

@Configuration
@ComponentScan(basePackages="com.sysmind.org")
@EnableWebMvc
@Transactional
public class MvcConfiguration{
	
	//similar web.xml like configuration will be done in MvcConfigurationInitializer class
	
	MvcConfiguration(){
		
		//Hibernate - h2 DB
		Student student = new Student("Tarun", "Parashar", "tarunkumarparashar@hotmail.com");
        Student student1 = new Student("John", "Cena", "john@javaguides.com");
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            // save the student objects
            session.save(student);
            session.save(student1);
            // commit transaction
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Student > students = session.createQuery("from Student", Student.class).list();
            students.forEach( (s) -> {System.out.println(s.getFirstName()); });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

}
