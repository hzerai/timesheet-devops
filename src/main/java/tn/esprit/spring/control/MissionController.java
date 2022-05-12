package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.mission.MissionService;

import java.util.List;

//MissionController
@RestController // = @Controller + @ResponseBody
//@Scope("session")
//singleton c'est par défaut
//prototype
//request
public class MissionController {

    // Couplage Faible
    @Autowired
    MissionService missionService;

    // URL : http://localhost:????/????/retrieve-all-missions
    @GetMapping("/retrieve-all-missions")
    public List<Mission> retrieveAllMissions() {
        List<Mission> list = missionService.retrieveAllMissions();
        return list;
    }

    // http://localhost:????/timesheet-devops/retrieve-mission/{mission-id}
    @GetMapping("/retrieve-mission/{mission-id}")
    public Mission retrieveMission(@PathVariable("mission-id") Long missionId) {
        return missionService.retrieveMission(missionId);
    }

    // Ajouter mission : http://localhost:????/timesheet-devops/add-mission
    @PostMapping("/add-mission")
    public Mission addMission(@RequestBody Mission en) {
        Mission mission = missionService.addMission(en);
        return mission;
    }


    // Supprimer mission :
    // http://localhost:????/timesheet-devops/remove-mission/{mission-id}
    @DeleteMapping("/remove-mission/{mission-id}")
    public void removeMission(@PathVariable("mission-id") Long missionId) {
        missionService.deleteMission(missionId);
    }

    // Modifier mission
    // http://localhost:????/timesheet-devops/modify-mission
    @PutMapping("/modify-mission")
    public Mission updateMission(@RequestBody Mission mission) {
        return missionService.updateMission(mission);
    }

}
