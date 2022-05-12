package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.mission.MissionService;

import java.text.ParseException;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MissionServiceTest {


    @Autowired
    private MissionService missionService;


    @Test
    @Order(1)
    public void testRetrieveAllMissions() {
        List<Mission> listMissions = missionService.retrieveAllMissions();
        Assertions.assertEquals(0, listMissions.size());

    }

    @Test
    @Order(2)
    public void testAddMission() throws ParseException {
        Mission mission = new Mission("Mission Name 1", "Mission Description 1");
        Mission missionAdded = missionService.addMission(mission);
        Assertions.assertEquals(mission.getName(), missionAdded.getName());
    }

    @Test
    @Order(3)
    public void testUpdateMission() throws ParseException {
        Mission mission = new Mission("Mission Name 2", "Mission Description 2");
        Mission missionUpdated = missionService.updateMission(mission);
        Assertions.assertEquals(mission.getName(), missionUpdated.getName());
    }

    @Test
    @Order(4)
    public void testRetrieveMission() {
        Mission missionRetreived = missionService.retrieveMission(1L);
        Assertions.assertEquals(1L, missionRetreived.getId());
    }

    @Test
    @Order(5)
    public void testDeleteMission() {
        missionService.deleteMission(1L);
        Assertions.assertEquals(0, missionService.retrieveAllMissions().size());

    }
}

