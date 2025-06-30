package henrotaym.env.http.resources;

import java.math.BigInteger;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EpisodeResource {
  private final BigInteger id;
  private final BigInteger externalId;
  private final String name;
  private final String airDate;
  private final String episode;

  private List<BigInteger> characterIds;
}