package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberRequestListDto;
import jp.co.netprotections.dto.MemberResponseListDto;
import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.listToList.ListToList;

/**
 * リクエストを処理するControllerクラスです.
 * @author t.matsuda
 */

@RestController
public class MemberJudgeController {

  //    @Autowired
  //    private MemberJudgeService memberJudgeService;

  /**
   * Controllerの実行メソッドです
   * @param MemberRequestListDto requestlist
   * @return MemberResponseListDto finalResponseList
   */

  @RequestMapping(value = "/main", method = RequestMethod.POST,
          consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public MemberResponseListDto execute(
          @RequestBody MemberRequestListDto requestList) {

    MemberRequestListDto normalList = new MemberRequestListDto();
    List<ResponseDto> abnormalList = new ArrayList<ResponseDto>();
    MemberResponseListDto finalResponseList = new MemberResponseListDto();

    if (requestList == null) {
      finalResponseList = null;
    }

    //for文を使ってリスト内の全データに不正チェックをかける
    //各隊員データの不正チェックロジックは別メソッドで記述
    for (int i = 0; i < requestList.getMemberRequestList().size(); i++) {
      RequestDto memberData = requestList.getMemberData(i);;
      MemberJudgeController requestMemberData = new MemberJudgeController();
      boolean judgedMemberData = requestMemberData.invalidCheck(memberData);
      //不正チェックの戻り値がfalse（不正）の場合はサービスロジックを介さずそのままabnormalListとして整形する
      if (judgedMemberData == false) {
        ResponseDto abnormalMemberData = new ResponseDto();
        abnormalMemberData.setResponseMemberName(null);
        abnormalMemberData.setEnlistedPropriety(false);
        abnormalList.add(abnormalMemberData);
      //正常なデータは入隊可否判断にかけるため、normalListに入れる
      } else {
        normalList.addMemberRequestList(memberData);;
      }

    }

    //normaListのみ入隊可否判断を適用
    ListToList judgeList = new ListToList();
    List<ResponseDto> judgedResponseList = judgeList.listToList(normalList);

    finalResponseList.addAllMemberResponseList(judgedResponseList);
    finalResponseList.addAllMemberResponseList(abnormalList);


    return finalResponseList;

  }


  //不正チェック
  //正常な（すべてのパラメータが揃った）隊員データが１つ以上存在している
  //パラメータはint型で0~5の値のみ受け取れる
  public boolean invalidCheck(RequestDto rq) {

    if (rq.getMemberName() != null
        && rq.getEventPlanning() >= 0 && rq.getEventPlanning() <= 5
        && rq.getCogitation() >= 0 && rq.getCogitation() <= 5
        && rq.getCoordination() >= 0 && rq.getCoordination() <= 5
        && rq.getInfrastructureKnowledge() >= 0 && rq.getInfrastructureKnowledge() <= 5
        && rq.getProgrammingKnowledge() >= 0 && rq.getProgrammingKnowledge() <= 5) {

      return true;

    } else {
      return false;
    }

  }





  //リストDTO無くす前のコード

  //   public MemberResponseListDto execute(@RequestBody MemberRequestListDto requestList) {
//
//
//      MemberRequestListDto normalList = new MemberRequestListDto();
//      MemberResponseListDto abnormalList = new MemberResponseListDto();
//      MemberResponseListDto finalResponseList = new MemberResponseListDto();
//
//    //for文を使ってリスト内の全データに不正チェックをかける
//    //各隊員データの不正チェックロジックは別にローカルで記述
//      for (int i = 0; i < requestList.getMemberRequestList().size(); i++) {
//          MemberJudgeRequestDto MemberData = requestList.getMemberRequestList().get(i);
//          MemberJudgeController requestMemberData = new MemberJudgeController();
//          boolean judgedMemberData = requestMemberData.invalidCheck(MemberData);
//          //不正チェックの戻り値がfalse（不正）の場合は入隊可否判断を介さずそのままabnormalListにぶちこむ
//          if (judgedMemberData == false) {
//              abnormalList.addMemberResponseList(null);
//          //正常なデータは入隊可否判断にかけるため、normalListに入れる
//          } else {
//              normalList.addMemberRequestList(MemberData);
//          }
//
//      }
//
//    //normaListのみサービスロジックを適用
//    listToList judgeList = new listToList();
//    MemberResponseListDto judgedResponseList = judgeList.listToList(normalList);
//
//    finalResponseList
//
//
//    return finalResponseList;
//
//  }
//
//
//  //不正チェック
//  //正常な（すべてのパラメータが揃った）隊員データが１つ以上存在している
//  //パラメータはint型で0~5の値のみ受け取れる
//  public boolean invalidCheck(MemberJudgeRequestDto rq) {
//
//      if (rq.getMemberName() != null &&
//          rq.getEventPlanning() >= 0 && rq.getEventPlanning() <= 5 &&
//          rq.getCogitation() >= 0 && rq.getCogitation() <= 5 &&
//          rq.getCordination() >= 0 && rq.getCordination() <= 5 &&
//          rq.getInfrastructureKnowledge() >= 0 && rq.getInfrastructureKnowledge() <= 5 &&
//          rq.getProgrammingKnowledge() >= 0 && rq.getProgrammingKnowledge() <= 5) {
//
//          return true;
//
//      } else {
//          return false;
//      }
//
//  }


}





//    //例外処理
//    try {
//        MemberJudgeResponseDto judgedRes = memberJudgeService.judge(request);
//    }catch (Exception e) {
//        e.getMessage();
//    }
//
//
//  }


  /**
   *
   * @param i
   * @param j
   * @param k
   * @param l
   * @param m
   * @return
   */
//  private int sumTotalValue(int i, int j, int k, int l, int m) {
//      return i + j + k + l + m;
//  }






