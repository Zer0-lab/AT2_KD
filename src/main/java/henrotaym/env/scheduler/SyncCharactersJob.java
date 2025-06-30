package henrotaym.env.scheduler;

import henrotaym.env.queues.emitters.Emitter;
import henrotaym.env.queues.events.SyncCharactersEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SyncCharactersJob {
  private final Emitter emitter;

  @Scheduled(fixedDelay = 60_000) // toutes les minutes (exemple)
  public void run() {
    emitter.send(new SyncCharactersEvent(1));
  }
}
