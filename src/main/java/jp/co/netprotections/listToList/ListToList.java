package jp.co.netprotections.listToList;

import java.util.ArrayList;
import java.util.List;

import jp.co.netprotections.dto.MemberRequestListDto;
import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;


public class ListToList {

  public List<ResponseDto> listToList(MemberRequestListDto request) {

    //レスポンスのインスタンス設定
    List<ResponseDto> result = new ArrayList<ResponseDto>();

    //拡張for文でリストから各隊員データを析出する
    for (RequestDto member: request.getMemberRequestList()) {
      //それぞれのデータに対してserviceロジックを適用
      MemberJudgeServiceImpl beforeJudgeMember = new MemberJudgeServiceImpl();
      ResponseDto JudgedMember = beforeJudgeMember.judge(member);
      //judgeメソッドを通した各データをMemberResponseListに追加する
      result.add(JudgedMember);
    }

    return result;

  }

}
