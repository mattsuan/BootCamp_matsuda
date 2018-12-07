package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberResponseListDto {

  private List<ResponseDto> memberResponseList;
  private ResponseDto memberResponseData;

  public MemberResponseListDto() {
      memberResponseList = new ArrayList<ResponseDto>();
  }

  public List<ResponseDto> getMemberResponseList() {
    return memberResponseList;
  }

  public void addMemberResponseList(ResponseDto JudgedMember) {
      memberResponseList.add(JudgedMember);
  }

  public void addAllMemberResponseList(List<ResponseDto> judgedList) {
      memberResponseList.addAll(judgedList);
  }

  public ResponseDto getMemberResponseData(int index) {
      return memberResponseList.get(index);
  }

}
