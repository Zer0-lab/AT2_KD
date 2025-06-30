package henrotaym.env.mappers;

import henrotaym.env.dto.rickandmorty.CharacterDto;
import henrotaym.env.entities.Characters;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

  public Characters fromExternal(CharacterDto dto) {
    Characters character = new Characters();
    character.setApiCharacterId((long) dto.getId());
    character.setName(dto.getName());
    character.setStatus(dto.getStatus());
    character.setImage(dto.getImage());
    return character;
  }

  public CharacterDto toExternal(Characters entity) {
    CharacterDto dto = new CharacterDto();
    dto.setId(entity.getApiCharacterId().intValue());
    dto.setName(entity.getName());
    dto.setStatus(entity.getStatus());
    dto.setImage(entity.getImage());

    return dto;
  }
}
