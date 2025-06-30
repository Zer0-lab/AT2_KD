package henrotaym.env.queues.listeners;

import henrotaym.env.queues.events.SyncCharactersEvent;
import henrotaym.env.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SyncCharactersListener implements Listener<SyncCharactersEvent> {
  private final CharacterService characterService;

  @Override
  @KafkaListener(topics = SyncCharactersEvent.EVENT_NAME, groupId = "rick-and-morty")
  public void listen(SyncCharactersEvent event) {
    characterService.importFromApi(event.getPage());
  }
}
