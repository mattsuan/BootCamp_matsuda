package jp.co.netprotections.dto;

public class RequestDto {

  private String memberName;
  private int eventPlanning;
  private int cogitation;
  private int coordination;
  private int programmingKnowledge;
  private int infrastructureKnowledge;

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public int getEventPlanning() {
    return eventPlanning;
  }

  public void setEventPlanning(int eventPlanning) {
    this.eventPlanning = eventPlanning;
  }

  public int getCogitation() {
    return cogitation;
  }

  public void setCogitation(int cogitation) {
    this.cogitation = cogitation;
  }

  public int getCoordination() {
    return coordination;
  }

  public void setCoordination(int coordination) {
    this.coordination = coordination;
  }

  public int getProgrammingKnowledge() {
    return programmingKnowledge;
  }

  public void setProgrammingKnowledge(int programmingKnowledge) {
    this.programmingKnowledge = programmingKnowledge;
  }

  public int getInfrastructureKnowledge() {
    return infrastructureKnowledge;
  }

  public void setInfrastructureKnowledge(int infrastructureKnowledge) {
    this.infrastructureKnowledge = infrastructureKnowledge;
  }



}
