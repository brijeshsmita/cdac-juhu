package com.lnt.hibernate.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnt.hibernate.model.Course;
import com.lnt.hibernate.model.Trainee;
import com.lnt.hibernate.util.HibernateUtil;

/**
 * @author Smita
 *
 */
public class TraineeClientMTM {
	// step I
	static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		// create 3 course object
		Course c1 = new Course("Java");
		Course c2 = new Course("Hibernate");
		Course c3 = new Course("Angular");
		// create set
		Set<Course> course = new HashSet<>();
		// add course obj to set
		course.add(c1);
		course.add(c2);
		course.add(c3);
		// create first trainee

		Trainee trainee1 = new Trainee();
		trainee1.setTraineeName("sonAL");
		trainee1.setCourse(course);

		Trainee trainee2 = new Trainee();
		trainee2.setTraineeName("sherlyn");
		trainee2.setCourse(course);

		Trainee trainee3 = new Trainee();
		trainee3.setTraineeName("Mona");
		trainee3.setCourse(course);

		// create set of trainees
		Set<Trainee> traineeSet = new HashSet<>();
		traineeSet.add(trainee1);
		traineeSet.add(trainee2);
		traineeSet.add(trainee3);

		// now adding traineeSet set to courses
		c1.setTrainees(traineeSet);
		c2.setTrainees(traineeSet);
		c3.setTrainees(traineeSet);

		/****************** INSERT TRAINEE **************************/
		// 1>open session
		Session session = factory.openSession();
		// 2>begin tx
		Transaction tx = session.beginTransaction();
		// 3>perform insert operation
		session.save(trainee1);
		session.save(trainee2);
		session.save(trainee3);
		// 4>commit tx
		tx.commit();
		/******************* GET TRAINEE RECORD *************************/
		List<Trainee> traineeList = 
				session.createQuery("FROM Trainee").list();
		System.out.println("TRAINEE ID " + "\t TRAINEE Name" + "\t Courses");
		for (Trainee trainee : traineeList) {
			System.out
					.println(trainee.getTraineeId() + "\t" + trainee.getTraineeName() + "\t" + trainee.getCourse());
		}
		session.close();
		factory.close();/****************** DELETE TRAINEE RECORD *************************/
		/*
		 * session= factory.openSession(); tx= session.beginTransaction();
		 * session.delete(trainee1); tx.commit(); session.close();
		 */
		// step II close Factory at the last

	}

}
