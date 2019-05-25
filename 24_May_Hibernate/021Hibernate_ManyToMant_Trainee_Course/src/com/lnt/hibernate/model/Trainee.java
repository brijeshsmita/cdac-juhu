/**
 * 
 */
package com.lnt.hibernate.model;
/**
 * @author Smita
 *
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINEE_MTM")
public class Trainee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRAINEE_ID")
	@GeneratedValue
	private Integer traineeId;

	@Column(name = "TRAINEE_NAME", nullable = false, length = 50)
	private String traineeName;

	@ManyToMany(targetEntity = Course.class,
			cascade = CascadeType.ALL)
	@JoinTable(name = "TRAINEE_COURSE", 
	joinColumns = @JoinColumn(name = "TRAINEE_ID_FK",
	referencedColumnName = "TRAINEE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID_FK", 
	referencedColumnName = "COURSE_ID"))
	// @OneToMany(cascade=CascadeType.ALL)
	// @JoinColumn(name="TRAINEE_ID",nullable=false)
	private Set<Course> course = new HashSet<>(0);

	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", course=" + course + "]";
	}


}