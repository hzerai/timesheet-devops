package tn.esprit.spring.services.mission;

import tn.esprit.spring.entities.Mission;

import java.util.List;


public interface MissionService {

    List<Mission> retrieveAllMissions();

    Mission addMission(Mission en);

    void deleteMission(Long id);

    Mission updateMission(Mission en);

    Mission retrieveMission(Long id);

}
