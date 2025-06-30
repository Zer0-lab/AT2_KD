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
public class LocationPageDto {
  private InfoDto info;
  private List<LocationDto> results;
}
