package henrotaym.env.scheduler;

import henrotaym.env.queues.emitters.Emitter;
import henrotaym.env.queues.events.SyncEpisodesEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SyncEpisodesJob {
  private final Emitter emitter;

  @Scheduled(fixedDelay = 60_000)
  public void run() {
    emitter.send(new SyncEpisodesEvent(2)); //exemple pour la page 2
  }
}
