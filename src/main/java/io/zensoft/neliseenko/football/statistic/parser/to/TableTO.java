package io.zensoft.neliseenko.football.statistic.parser.to;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableTO {

  @SerializedName("position")
  @Expose
  private long position;
  @SerializedName("team")
  @Expose
  private TeamTO team;
  @SerializedName("playedGames")
  @Expose
  private long playedGames;
  @SerializedName("won")
  @Expose
  private long won;
  @SerializedName("draw")
  @Expose
  private long draw;
  @SerializedName("lost")
  @Expose
  private long lost;
  @SerializedName("points")
  @Expose
  private long points;

  /**
   * No args constructor for use in serialization
   *
   */
  public TableTO() {}

  /**
   *
   * @param draw
   * @param position
   * @param lost
   * @param points
   * @param won
   * @param team
   */
  public TableTO(long position, TeamTO team, long playedGames, long won, long draw, long lost,
      long points, long goalsFor, long goalsAgainst, long goalDifference) {
    super();
    this.position = position;
    this.team = team;
    this.playedGames = playedGames;
    this.won = won;
    this.draw = draw;
    this.lost = lost;
    this.points = points;
  }

  public long getPosition() {
    return position;
  }

  public void setPosition(long position) {
    this.position = position;
  }

  public TeamTO getTeam() {
    return team;
  }

  public void setTeam(TeamTO team) {
    this.team = team;
  }

  public long getPlayedGames() {
    return playedGames;
  }

  public void setPlayedGames(long playedGames) {
    this.playedGames = playedGames;
  }

  public long getWon() {
    return won;
  }

  public void setWon(long won) {
    this.won = won;
  }

  public long getDraw() {
    return draw;
  }

  public void setDraw(long draw) {
    this.draw = draw;
  }

  public long getLost() {
    return lost;
  }

  public void setLost(long lost) {
    this.lost = lost;
  }

  public long getPoints() {
    return points;
  }

  public void setPoints(long points) {
    this.points = points;
  }
}
