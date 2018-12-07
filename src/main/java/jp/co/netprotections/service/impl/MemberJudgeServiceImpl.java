package jp.co.netprotections.service.impl;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {

  public ResponseDto judge(RequestDto member) {

    ResponseDto response = new ResponseDto();

    // 合計値を取得します。
    int totalValue = this.sumTotalValue(member.getCogitation(), member.getCoordination(),
            member.getEventPlanning(), member.getInfrastructureKnowledge(),
            member.getProgrammingKnowledge());

    // 以下、入隊可否判断処理
    // イベント企画力 <= 1 || 調整力 <= 1 || 合計 <= 10ならfalse
    //それ以外はすべてtrue
    if (member.getEventPlanning() <= 1 || member.getCoordination() <= 1
        || totalValue <= 10) {
      //enlistsdProprietyの値をfalseにする
      response.setEnlistedPropriety(false);
    } else {
      //上記以外はすべてtrueでかえす
      response.setEnlistedPropriety(true);
    }
    //レスポンスのメンバーネーム設定
    response.setResponseMemberName(member.getMemberName());

    //レスポンスインスタンスの返却
    return response;

  }

  /**
  *
  * @param i
  * @param j
  * @param k
  * @param l
  * @param m
  * @return
  */
 private int sumTotalValue(int i, int j, int k, int l, int m) {
     return i + j + k + l + m;
 }



}
