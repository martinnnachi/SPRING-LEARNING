package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import com.martinnnachi.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .addAnnotatedClass( Review.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // start a transaction
            session.beginTransaction();

            // get the course
            int theId = 10;
            Course tempCourse = session.get( Course.class, theId );

            // print the course
            System.out.println(tempCourse);

            // print out the course reviews
            System.out.println(tempCourse.getReviews());


            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}
