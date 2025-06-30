package henrotaym.env.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Characters {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "api_character_id", nullable = false, unique = true)
  private Long apiCharacterId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private String image;

  @Column(name = "episode_count", nullable = false)
  private Integer episodeCount = 0;

  @ManyToMany
  @JoinTable(
      name = "character_episode",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "episode_id"))
  private List<Episodes> episodes = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "origin_id")
  private Location origin;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;
}
