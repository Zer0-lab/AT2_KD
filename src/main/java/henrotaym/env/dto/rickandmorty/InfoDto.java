package henrotaym.env.dto.rickandmorty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {
  private int count;
  private int pages;
  private String next;
  private String prev;
}
