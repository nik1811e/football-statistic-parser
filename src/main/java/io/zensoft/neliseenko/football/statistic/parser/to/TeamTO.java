package io.zensoft.neliseenko.football.statistic.parser.to;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamTO {

  @SerializedName("id")
  @Expose
  private long id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("crestUrl")
  @Expose
  private String crestUrl;

  /**
   * No args constructor for use in serialization
   */
  public TeamTO() {}

  /**
   * @param id
   * @param crestUrl
   * @param name
   */
  public TeamTO(long id, String name, String crestUrl) {
    super();
    this.id = id;
    this.name = name;
    this.crestUrl = crestUrl;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCrestUrl() {
    return crestUrl;
  }

  public void setCrestUrl(String crestUrl) {
    this.crestUrl = crestUrl;
  }

}
