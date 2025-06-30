package henrotaym.env.http.resources;

import java.math.BigInteger;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CharacterResource {
  private final BigInteger id;
  private final String name;
  private final String status;
  private final String gender;
  private final String image;

  private List<BigInteger> episodeIds;
}
