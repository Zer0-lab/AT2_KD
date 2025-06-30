package henrotaym.env.queues.events;

import henrotaym.env.enums.EventName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SyncCharactersEvent implements Event {
  private int page;

  public static final String EVENT_NAME = EventName.SYNC_CHARACTERS;

  @Override
  public String eventName() {
    return EVENT_NAME;
  }
}
