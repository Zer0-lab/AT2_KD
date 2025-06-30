package henrotaym.env.dto.rickandmorty;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
  private int id;
  private String name;
  private String air_date;
  private String episode;
  private List<String> characters;
  private String url;
  private String created;
}
