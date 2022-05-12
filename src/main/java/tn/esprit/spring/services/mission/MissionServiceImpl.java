package tn.esprit.spring.services.mission;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    MissionRepository missionRepository;

    private static final Logger l = LogManager.getLogger(tn.esprit.spring.services.mission.MissionServiceImpl.class);

    @Override
    public List<Mission> retrieveAllMissions() {
        List<Mission> missions = null;
        try {

            l.info("In Method retrieveAllMissions :");
            missions = (List<Mission>) missionRepository.findAll();
            l.debug("connexion à la DB Ok :");
            for (Mission mission : missions) {
                l.debug("mission :" + mission.getName());
            }
            l.info("Out of Method retrieveAllMissions with Success" + missions.size());
        } catch (Exception e) {
            l.error("Out of Method retrieveAllMissions with Errors : " + e);
        }

        return missions;
    }

    @Override
    public Mission addMission(Mission en) {
        Mission e_saved = null;

        try {
            l.info("In Method addMission :");
            e_saved = missionRepository.save(en);
            l.info("Out of Method addMission with Success" + e_saved.getName());

        } catch (Exception e) {
            l.error("Out of Method addMission with Errors : " + e);
        }

        return e_saved;

    }

    @Override
    public void deleteMission(Long id) {
        try {
            l.info("In Method deleteMission :");
            missionRepository.deleteById(id);
            l.info("Out of Method deleteMission with Success");

        } catch (Exception e) {
            l.error("Out of Method deleteMission with Errors : " + e);
        }
    }

    @Override
    public Mission updateMission(Mission en) {

        Mission missionUpdated = null;

        try {
            l.info("In Method missionUpdated :");
            missionUpdated = missionRepository.save(en);
            l.info("Out of Method missionUpdated with Success" + missionUpdated.getName());

        } catch (Exception e) {
            l.error("Out of Method missionUpdated with Errors : " + e);
        }

        return missionUpdated;
    }

    @Override
    public Mission retrieveMission(Long id) {
        Mission en = null;
        try {
            l.info("In Method retrieveMission :");
            en = missionRepository.findById(id).get();
            l.info("Out of Method retrieveMission with Success" + en.getName());

        } catch (Exception e) {
            l.error("Out of Method retrieveMission with Errors : " + e);
        }

        return en;
    }

}
