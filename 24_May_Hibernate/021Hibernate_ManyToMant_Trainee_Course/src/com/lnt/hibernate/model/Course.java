/**
 * 
 */
package com.lnt.hibernate.model;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * @author Smita
 *
 */
@Entity
@Table(name="COURSE_MTM")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COURSE_ID")
	private Long courseId;
	
	@Column(name="COURSE_NAME",nullable=false)
	private String courseName;
	
	@ManyToMany(targetEntity=Trainee.class,
			 mappedBy="course")
	private Set<Trainee> trainees;
	
	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> studentSet) {
		this.trainees = studentSet;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

}
