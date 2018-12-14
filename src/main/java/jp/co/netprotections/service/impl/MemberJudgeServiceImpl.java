package jp.co.netprotections.service.impl;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

/**
 * @author t.matsuda
 *
 */

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {

  /**
   * @param RequestDto member
   * @return ResponseDto response
   */
  public ResponseDto judge(RequestDto member) {

    ResponseDto response = new ResponseDto();

    // 合計値を取得します。
    int totalValue = this.sumTotalValue(member.getCogitation(),
            member.getCoordination(),member.getEventPlanning(),
            member.getInfrastructureKnowledge(),member.getProgrammingKnowledge());

    // 以下、入隊可否判断処理
    // イベント企画力 <= 1 || 調整力 <= 1 || 合計 <= 10ならfalseを返す
    //それ以外はすべてtrue
    if (member.getEventPlanning() <= 1 || member.getCoordination() <= 1) {
      //enlistsdProprietyの値をfalseにする
      response.setEnlistedPropriety(false);
    } else if (totalValue <= 10) {
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
  * 隊員パラメータの合計値算出メソッドです
  * @param i
  * @param j
  * @param k
  * @param l
  * @param m
  * @return i + j + k + l + m
  */
  public int sumTotalValue(int i, int j, int k, int l, int m) {
    return i + j + k + l + m;
  }

}
