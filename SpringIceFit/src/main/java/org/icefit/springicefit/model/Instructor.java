package org.icefit.springicefit.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "instructors")
public class Instructor extends User{

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "fitnessGoals")
    private String fitnessGoals;

    @Column(name = "nutritionalPreferences")
    private String nutritionalPreferences;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "bodyFatPercentage")
    private float bodyFat;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "aboutMe")
    private String aboutMe;

    @Column(name = "certifications")
    private String certifications;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "training_plan_id")
    @JsonIgnore
    private TrainingPlan trainingPlan;

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
        if (trainingPlan != null && trainingPlan.getInstructor() != this) {
            trainingPlan.setInstructor(this);
        }
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getNutritionalPreferences() {
        return nutritionalPreferences;
    }

    public void setNutritionalPreferences(String nutritionalPreferences) {
        this.nutritionalPreferences = nutritionalPreferences;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(float bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
