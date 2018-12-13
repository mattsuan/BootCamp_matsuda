package jp.co.netprotections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberRequestListDto;
import jp.co.netprotections.dto.MemberResponseListDto;
import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

/**
 * リクエストを処理するControllerクラスです.
 * @author t.matsuda
 */

@RestController
public class MemberJudgeController {

  //レスポンスのインスタンス作成
  @Autowired
  private MemberResponseListDto response;

  //リストから取り出したメンバーの不正チェックを行うためのインスタンス作成
  @Autowired
  private MemberJudgeController rqMemberData;

  //入隊審査にかけるためのサービスクラスのインスタンス作成
  @Autowired
  private MemberJudgeServiceImpl beforeJudgeData;

  //不正チェックエラーが出たデータを処理するためのインスタンスを作成
  @Autowired
  private ResponseDto abnormalMemberData;


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
    //リストフィールドを持たないリクエストに対してnullを返す
    if (requestList == null) {
      response = null;
    } else {
      //リクエストからメンバーのデータを取り出して、入力不正チェックにかける
      for (int i = 0; i < requestList.getMemberRequestList().size(); i++) {
        RequestDto memberData = requestList.getMemberData(i);
        boolean validationResult = rqMemberData.invalidCheck(memberData);

        if (validationResult == true) {
          //正常なデータは入隊可否審査にかける
          ResponseDto judgedData = beforeJudgeData.judge(memberData);
          response.addMemberResponseList(judgedData);
        } else {
          //入力不正チェックの戻り値がfalse（不正）のデータは名前をnull、審査結果falseを設定する
          abnormalMemberData.setResponseMemberName(null);
          abnormalMemberData.setEnlistedPropriety(false);
          response.addMemberResponseList(abnormalMemberData);
        }

      }
    }

    return response;

  }


  /**
   * 隊員データのValidation実行のためのメソッドです
   * @param RequestDto rq
   * @return boolean true or false
   */
  private boolean invalidCheck(RequestDto rq) {

    //名前がnull、および空文字の場合falseを返す
    //各int値パラメータが0～5以外の値の場合、falseを返す
    //上記すべてに問題がなければtrueを返す
    if (rq.getMemberName() != null && rq.getMemberName().isEmpty() == false
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
}





