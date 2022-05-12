package tn.esprit.spring.services.mission;

import tn.esprit.spring.entities.Mission;

import java.util.List;


public interface MissionService {

    List<Mission> retrieveAllMissions();

    Mission addMission(Mission mission);

    void deleteMission(Long id);

    Mission updateMission(Mission mission);

    Mission retrieveMission(Long id);

}
