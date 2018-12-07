package jp.co.netprotections.dto;

import java.util.List;

public class MemberRequestListDto {

//    //コンストラクタはテスト用、実際にSpringbootでリクエストするときは外す
//      public MemberRequestListDto () {
//          memberRequestList = new ArrayList<RequestDto>();
//    }

  private List<RequestDto> memberRequestList;


  public List<RequestDto> getMemberRequestList() {
    return memberRequestList;
  }

  public void setMemberRequestList(List<RequestDto> memberRequestList) {
      this.memberRequestList = memberRequestList;
  }

  public void addMemberRequestList(RequestDto requestData) {
    memberRequestList.add(requestData);
  }

  public RequestDto getMemberData (int index) {
      return memberRequestList.get(index);
  }


}
