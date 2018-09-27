package io.zensoft.neliseenko.football.statistic.parser.to;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatisticTO {

  @SerializedName("standings")
  @Expose
  private List<StandingTO> standings = null;

  /**
   * No args constructor for use in serialization
   *
   */
  public StatisticTO() {}

  /**
   *
   * @param standings
   */
  public StatisticTO(
      List<StandingTO> standings) {
    super();
    this.standings = standings;
  }

  public List<StandingTO> getStandings() {
    return standings;
  }

  public void setStandings(List<StandingTO> standings) {
    this.standings = standings;
  }
}
