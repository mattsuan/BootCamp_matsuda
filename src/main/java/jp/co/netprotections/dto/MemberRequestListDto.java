package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberRequestListDto {

  private List<RequestDto> memberRequestList;

//コンストラクタはテスト用、実際にSpringbootでリクエストするときは外す
public MemberRequestListDto () {
    memberRequestList = new ArrayList<RequestDto>();
}


  public List<RequestDto> getMemberRequestList() {
    return memberRequestList;
  }

  public void setMemberRequestList(List<RequestDto> memberRequestList) {
    this.memberRequestList = memberRequestList;
  }

  public void addMemberRequestList(RequestDto requestData) {
    memberRequestList.add(requestData);
  }

  public RequestDto getMemberData(int index) {
    return memberRequestList.get(index);
  }


}
