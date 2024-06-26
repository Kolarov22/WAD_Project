package org.icefit.springicefit.api.controller.auth;


import jakarta.validation.Valid;
import org.icefit.springicefit.api.model.TrainingPlanBody;
import org.icefit.springicefit.dao.UserDao;
import org.icefit.springicefit.model.Client;
import org.icefit.springicefit.model.Instructor;
import org.icefit.springicefit.model.TrainingPlan;
import org.icefit.springicefit.service.TrainingService;
import org.icefit.springicefit.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/training/")
@CrossOrigin
public class TrainingPlanControllerv1 {

    private TrainingService trainingService;
    private UserDao userDao;
    public TrainingPlanControllerv1(UserService userService, TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    //post for instructor to add a plan
    @PostMapping("/create")
    public ResponseEntity createTrainingPlan(@Valid @RequestBody TrainingPlanBody trainingPlanBody, @AuthenticationPrincipal Instructor instructor){
        try{
            trainingService.createTrainingBody(trainingPlanBody,instructor);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/plans")
    public ResponseEntity<List<TrainingPlan>> getAllTrainingPlans() {
        List<TrainingPlan> trainingPlans = trainingService.getTrainingPlans();
        return ResponseEntity.ok(trainingPlans);
    }

    @PostMapping("/add/{planId}")
    public ResponseEntity<?> addTrainingPlanToClient(@PathVariable Long planId, @AuthenticationPrincipal Client client) {
        try {
            trainingService.addTrainingPlanToClient(planId, client);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/client/training-plan")
    public ResponseEntity<List<TrainingPlan>> getTrainingPlanForClient(@AuthenticationPrincipal Client client) {
        List<TrainingPlan> trainingPlans = trainingService.getTrainingPlanForClient(client.getId());
        if (trainingPlans != null) {
            return ResponseEntity.ok(trainingPlans);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
