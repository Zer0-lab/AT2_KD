package henrotaym.env.services;

import com.querydsl.jpa.impl.JPAQueryFactory;
import henrotaym.env.clients.RickAndMortyClient;
import henrotaym.env.dto.rickandmorty.CharacterDto;
import henrotaym.env.dto.rickandmorty.CharacterPageDto;
import henrotaym.env.entities.Characters;
import henrotaym.env.entities.QCharacters;
import henrotaym.env.mappers.CharacterMapper;
import henrotaym.env.repositories.CharacterRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

  private final RickAndMortyClient client;
  private final CharacterRepository characterRepository;
  private final CharacterMapper characterMapper;
  private final EntityManager entityManager;

  public int importFromApi(int page) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
    int total = 0;

    CharacterPageDto pageDto = client.getCharacters(page);
    List<CharacterDto> characterDtos = pageDto.getResults();

    for (CharacterDto dto : characterDtos) {
      Characters existing =
          queryFactory
              .selectFrom(QCharacters.characters)
              .where(QCharacters.characters.apiCharacterId.eq((long) dto.getId()))
              .fetchFirst();

      if (existing != null) {
        existing.setName(dto.getName());
        existing.setStatus(dto.getStatus());
        existing.setImage(dto.getImage());
        characterRepository.save(existing);
        continue;
      }

      Characters character = characterMapper.fromExternal(dto);
      characterRepository.save(character);
      total++;
    }

    return total;
  }
}
