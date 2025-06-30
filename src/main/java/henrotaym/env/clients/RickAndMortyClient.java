package henrotaym.env.clients;

import henrotaym.env.dto.rickandmorty.CharacterPageDto;
import henrotaym.env.dto.rickandmorty.EpisodePageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RickAndMortyClient {

  private final RestTemplate restTemplate;
  private static final String BASE_URL = "https://rickandmortyapi.com/api";

  public CharacterPageDto getCharacters(int page) {
    String url = BASE_URL + "/character?page=" + page;
    return restTemplate.getForObject(url, CharacterPageDto.class);
  }

  public EpisodePageDto getEpisodes(int page) {
    String url = BASE_URL + "/episode?page=" + page;
    return restTemplate.getForObject(url, EpisodePageDto.class);
  }
}
