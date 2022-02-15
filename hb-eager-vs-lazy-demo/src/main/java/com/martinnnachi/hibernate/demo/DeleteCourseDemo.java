package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {

            // start a transaction
            session.beginTransaction();

            // get a course
            int theId = 10;
            Course tempCourse = session.get( Course.class, theId );

            // delete a course
            System.out.println( "Deleting course: " + tempCourse );
            session.delete( tempCourse );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}
