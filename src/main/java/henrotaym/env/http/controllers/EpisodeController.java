package henrotaym.env.http.controllers;

import henrotaym.env.queues.emitters.Emitter;
import henrotaym.env.queues.events.SyncEpisodesEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {

  private final Emitter emitter;

  @PostMapping("/import")
  public String importEpisodes(@RequestParam(defaultValue = "2") int page) {
    emitter.send(new SyncEpisodesEvent(page));
    return "SyncEpisodesEvent sent for page " + page;
  }
}
