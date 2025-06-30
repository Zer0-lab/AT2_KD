package henrotaym.env.mappers;

import henrotaym.env.dto.rickandmorty.EpisodeDto;
import henrotaym.env.entities.Episodes;
import org.springframework.stereotype.Component;

@Component
public class EpisodeMapper {

  public Episodes fromExternal(EpisodeDto dto) {
    Episodes episode = new Episodes();
    episode.setApiEpisodeId((long) dto.getId());
    episode.setName(dto.getName());
    episode.setEpisodeCode(dto.getEpisode());
    return episode;
  }

  public EpisodeDto toExternal(Episodes entity) {
    EpisodeDto dto = new EpisodeDto();
    dto.setId(entity.getApiEpisodeId().intValue());
    dto.setName(entity.getName());
    dto.setEpisode(entity.getEpisodeCode());
    return dto;
  }
}
