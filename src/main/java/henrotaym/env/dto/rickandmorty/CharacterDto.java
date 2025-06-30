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
public class CharacterDto {
  private int id;
  private String name;
  private String status;
  private String species;
  private String type;
  private String gender;
  private OriginLocationDto origin;
  private OriginLocationDto location;
  private String image;
  private List<String> episode;
  private String url;
  private String created;
}
