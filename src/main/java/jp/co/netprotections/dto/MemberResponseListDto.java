package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberResponseListDto {

  private List<ResponseDto> memberResponseList;

  public MemberResponseListDto() {
    memberResponseList = new ArrayList<ResponseDto>();
  }

  public List<ResponseDto> getMemberResponseList() {
    return memberResponseList;
  }

  public void addMemberResponseList(ResponseDto judgedMember) {
    memberResponseList.add(judgedMember);
  }

  public void addAllMemberResponseList(List<ResponseDto> judgedList) {
    memberResponseList.addAll(judgedList);
  }

  public ResponseDto getMemberResponseData(int index) {
    return memberResponseList.get(index);
  }

}
