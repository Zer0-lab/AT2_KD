package henrotaym.env.database.factories;

import henrotaym.env.entities.Characters;
import henrotaym.env.repositories.CharacterRepository;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class CharacterFactory extends EntityFactory<Characters> {

  public CharacterFactory(Faker faker, CharacterRepository repository) {
    super(faker, repository);
  }

  @Override
  protected Characters entity() {
    return new Characters();
  }

  @Override
  protected void attributes(Characters character) {
    character.setApiCharacterId(faker.number().randomNumber());
    character.setName(faker.funnyName().name());
    character.setStatus("Alive");
    character.setImage("https://example.com/image.png");
    character.setEpisodeCount(0);
  }
}
