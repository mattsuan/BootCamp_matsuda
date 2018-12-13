package jp.co.netprotections.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;



@RunWith(JUnit4.class)
@SpringBootTest
@Component
public class MemberJudgeServiceTest {

  //テストのリクエストとレスポンスの設定
  @Autowired
  private RequestDto request;
  @Autowired
  private MemberJudgeServiceImpl response;

  //eventPlanning <= 1 の場合、結果がfalseになるかのテストです
  @Test
  public void judgeTest001() {

    //インプットする値のセット
    request.setMemberName("tmatsuda");
    request.setEventPlanning(1);
    request.setCogitation(3);
    request.setCoordination(3);
    request.setProgrammingKnowledge(3);
    request.setInfrastructureKnowledge(3);

    //レスポンスの設定
    ResponseDto testResponse = response.judge(request);
    boolean testPropriety = testResponse.isEnlistedPropriety();

    //結果がfalseになるか確認
    assertThat(false, is(testPropriety));
  }


  //coordination <= 1 の場合、結果がfalseになるかのテストです
  @Test
  public void judgeTest002() {

    //インプットする値のセット
    request.setMemberName("tmatsuda");
    request.setEventPlanning(3);
    request.setCogitation(3);
    request.setCoordination(1);
    request.setProgrammingKnowledge(3);
    request.setInfrastructureKnowledge(3);

    //レスポンスの設定
    ResponseDto testResponse = response.judge(request);
    boolean testPropriety = testResponse.isEnlistedPropriety();

    //結果がfalseになるか確認
    assertThat(false, is(testPropriety));
  }

  //totalVaule <= 10 の場合、結果がfalseになるかのテストです
  @Test
  public void judgeTest003() {

    //インプットする値のセット
    request.setMemberName("tmatsuda");
    request.setEventPlanning(2);
    request.setCogitation(2);
    request.setCoordination(2);
    request.setProgrammingKnowledge(2);
    request.setInfrastructureKnowledge(2);

    //レスポンスの設定
    ResponseDto testResponse = response.judge(request);
    boolean testPropriety = testResponse.isEnlistedPropriety();

    //結果がfalseになるか確認
    assertThat(false, is(testPropriety));
  }

  //eventPlanning, coordinationが２以上、totalValueが１１以上の場合、
  //結果がtrueになるかのテストです
  @Test
  public void judgeTest004() {

    //インプットする値のセット
    request.setMemberName("tmatsuda");
    request.setEventPlanning(2);
    request.setCogitation(3);
    request.setCoordination(2);
    request.setProgrammingKnowledge(3);
    request.setInfrastructureKnowledge(1);

    //レスポンスの設定
    ResponseDto testResponse = response.judge(request);
    boolean testPropriety = testResponse.isEnlistedPropriety();


    //結果がtrueになるか確認
    assertThat(true, is(testPropriety));
  }


}
