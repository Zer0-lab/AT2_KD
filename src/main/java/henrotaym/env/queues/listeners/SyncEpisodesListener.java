package henrotaym.env.queues.listeners;

import henrotaym.env.annotations.KafkaRetryableListener;
import henrotaym.env.queues.events.SyncEpisodesEvent;
import henrotaym.env.services.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SyncEpisodesListener implements Listener<SyncEpisodesEvent> {

  private final EpisodeService service;

  @Override
  @KafkaRetryableListener(SyncEpisodesEvent.EVENT_NAME)
  public void listen(SyncEpisodesEvent event) {
    service.importFromApi(event.getPage());
  }
}
