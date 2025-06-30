package henrotaym.env.services;

import com.querydsl.jpa.impl.JPAQueryFactory;
import henrotaym.env.clients.RickAndMortyClient;
import henrotaym.env.dto.rickandmorty.EpisodeDto;
import henrotaym.env.dto.rickandmorty.EpisodePageDto;
import henrotaym.env.entities.Characters;
import henrotaym.env.entities.Episodes;
import henrotaym.env.entities.QCharacters;
import henrotaym.env.entities.QEpisodes;
import henrotaym.env.mappers.EpisodeMapper;
import henrotaym.env.repositories.CharacterRepository;
import henrotaym.env.repositories.EpisodeRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EpisodeService {

  private final RickAndMortyClient client;
  private final EpisodeRepository episodeRepository;
  private final CharacterRepository characterRepository;
  private final EpisodeMapper episodeMapper;
  private final EntityManager entityManager;

  public int importFromApi(int page) {
    int total = 0;
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

    EpisodePageDto pageDto = client.getEpisodes(page);
    List<EpisodeDto> episodeDtos = pageDto.getResults();

    for (EpisodeDto dto : episodeDtos) {

      Episodes existingEpisode =
          queryFactory
              .selectFrom(QEpisodes.episodes)
              .where(QEpisodes.episodes.apiEpisodeId.eq((long) dto.getId()))
              .fetchFirst();

      if (existingEpisode != null) continue;

      Episodes episode = episodeMapper.fromExternal(dto);
      episodeRepository.save(episode);
      total++;

      for (String characterUrl : dto.getCharacters()) {
        try {
          String idStr = characterUrl.replaceAll(".*/character/", "");
          Long characterId = Long.parseLong(idStr);

          Characters existingCharacter =
              queryFactory
                  .selectFrom(QCharacters.characters)
                  .where(QCharacters.characters.apiCharacterId.eq(characterId))
                  .fetchFirst();

          if (existingCharacter != null) {
            existingCharacter.setEpisodeCount(existingCharacter.getEpisodeCount() + 1);
            characterRepository.save(existingCharacter);
          }
        } catch (NumberFormatException e) {
          System.err.println("Invalid character ID in URL: " + characterUrl);
        }
      }
    }

    return total;
  }
}
