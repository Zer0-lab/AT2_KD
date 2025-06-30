package henrotaym.env.test.feature.services;

import static org.junit.jupiter.api.Assertions.*;

import henrotaym.env.ApplicationTest;
import henrotaym.env.database.factories.CharacterFactory;
import henrotaym.env.entities.Characters;
import henrotaym.env.repositories.CharacterRepository;
import henrotaym.env.services.EpisodeService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EpisodeServiceFeatureTest extends ApplicationTest {

  @Autowired EpisodeService episodeService;
  @Autowired CharacterFactory characterFactory;
  @Autowired CharacterRepository characterRepository;
  @Autowired EntityManager entityManager;

  @Test
  void it_increments_episode_count_when_character_exists() {
    Characters character = characterFactory.create(c -> c.setApiCharacterId(2L));

    int initialCount = character.getEpisodeCount();

    episodeService.importFromApi(2);

    entityManager.flush();
    entityManager.clear();

    Characters updated = characterRepository.findById(character.getId()).orElseThrow();
    assertEquals(initialCount + 1, updated.getEpisodeCount());
  }

  @Test
  void it_does_nothing_if_character_not_found() {

    characterRepository.deleteAll();

    assertDoesNotThrow(() -> episodeService.importFromApi(2));

    assertEquals(0, characterRepository.count());
  }
}
