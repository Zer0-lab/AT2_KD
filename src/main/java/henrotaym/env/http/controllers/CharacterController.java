package henrotaym.env.http.controllers;

import henrotaym.env.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {

  private final CharacterService characterService;

  @PostMapping("/import")
  public String importCharacters(@RequestParam(defaultValue = "1") int page) {
    int count = characterService.importFromApi(page);
    return count + " characters imported successfully from page " + page + ".";
  }
}
