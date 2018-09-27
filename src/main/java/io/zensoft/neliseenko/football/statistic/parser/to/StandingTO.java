package io.zensoft.neliseenko.football.statistic.parser.to;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StandingTO {

  @SerializedName("stage")
  @Expose
  private String stage;
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("group")
  @Expose
  private Object group;
  @SerializedName("table")
  @Expose
  private List<TableTO> table = null;

  /**
   * No args constructor for use in serialization
   *
   */
  public StandingTO() {}

  /**
   *
   * @param table
   * @param group
   * @param type
   * @param stage
   */
  public StandingTO(String stage, String type, Object group, List<TableTO> table) {
    super();
    this.stage = stage;
    this.type = type;
    this.group = group;
    this.table = table;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Object getGroup() {
    return group;
  }

  public void setGroup(Object group) {
    this.group = group;
  }

  public List<TableTO> getTable() {
    return table;
  }

  public void setTable(List<TableTO> table) {
    this.table = table;
  }
}
