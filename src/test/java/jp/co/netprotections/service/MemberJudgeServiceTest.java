package jp.co.netprotections.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

@RunWith(JUnit4.class)
@SpringBootTest
public class MemberJudgeServiceTest {

  @Test
  public void ServiceImplTest() {
    System.out.println("judgeメソッドのテストです");

    //インスタンスの初期化
    RequestDto request1 = new RequestDto();
    MemberJudgeServiceImpl response1 = new MemberJudgeServiceImpl();

    request1.setEventPlanning(2);
    request1.setCogitation(2);
    request1.setCoordination(2);
    request1.setProgrammingKnowledge(3);
    request1.setInfrastructureKnowledge(2);
    request1.setMemberName("Takashi");
    //↑コンストラクタ設定すると良いが、それは余裕あったらでいい。

    //期待する値の設定
    String expectedName = "Takashi";
    boolean expectedPropriety = true;


    //実際の値（テスト先のメソッド通した値）の設定
    ResponseDto actualResponse = response1.judge(request1);
    String actualName = actualResponse.getResponseMemberName();
    boolean actualPropriety = actualResponse.isEnlistedPropriety();


    //期待する値と実際の値の比較
    assertEquals(expectedName, actualName);
    assertEquals(expectedPropriety, actualPropriety);


  }

//    @Test
//    public void validationTest() {
//        RequestDto testMember = new RequestDto();
//        testMember.setMemberName("MATSUDA");
//        testMember.setEventPlanning(2);
//        testMember.setCogitation(3);
//        testMember.setCoordination(3);
//        testMember.setInfrastructureKnowledge(2);
//        testMember.setProgrammingKnowledge(2);
//
//        boolean expectedResult = true;
//
//        MemberJudgeServiceImpl TestResult = new MemberJudgeServiceImpl();
//        boolean TestResponse = TestResult.invalidCheck(testMember);
//
//        assertEquals(expectedResult, TestResponse);
//    }
//
//    @Test
//    public void afterValidationFlowTest() {
//        //インスタンスの初期化
//        RequestDto requestData = new RequestDto();
//        MemberRequestListDto requestList = new MemberRequestListDto();
////        ListToList JudgedList = new ListToList();
//
//
//        //期待する値の設定
//        requestData.setMemberName(null);
//        requestData.setEventPlanning(4);
//        requestData.setCogitation(3);
//        requestData.setCoordination(2);
//        requestData.setProgrammingKnowledge(3);
//        requestData.setInfrastructureKnowledge(2);
//        requestList.addMemberRequestList(requestData);;
//
//
//        RequestDto requestData2 = new RequestDto();
//        requestData2.setMemberName("kyamaura");
//        requestData2.setEventPlanning(12);
//        requestData2.setCogitation(3);
//        requestData2.setCoordination(5);
//        requestData2.setProgrammingKnowledge(2);
//        requestData2.setInfrastructureKnowledge(5);
//        requestList.addMemberRequestList(requestData2);
//
//
//
//
//
//        MemberJudgeServiceImpl testResult = new MemberJudgeServiceImpl();
//        List<ResponseDto> abnormalList = testResult.afterValidationFlow1(requestList);
//
//        assertEquals(null, abnormalList.get(0).getResponseMemberName());
//        assertEquals(false, abnormalList.get(0).isEnlistedPropriety());
//        assertEquals(null, abnormalList.get(1).getResponseMemberName());
//        assertEquals(false, abnormalList.get(1).isEnlistedPropriety());
//
//
//
//
//    }










}
